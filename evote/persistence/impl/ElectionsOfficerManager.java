package edu.uga.cs.evote.persistence.impl;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import edu.uga.cs.evote.EVException;
//import edu.uga.ElectionsOfficers.entity.ElectionsOfficer;
import edu.uga.cs.evote.entity.ElectionsOfficer;
import edu.uga.cs.evote.entity.User;
import edu.uga.cs.evote.object.ObjectLayer;

class ElectionsOfficerManager
{
    private ObjectLayer objectLayer = null;
    private Connection  conn = null;
    
    public ElectionsOfficerManager( Connection conn, ObjectLayer objectLayer )
    {
        this.conn = conn;
        this.objectLayer = objectLayer;
    }
    
    public void store( User User ) 
            throws EVException
    {
        String               insertUserSql = "INSERT INTO ElectionsOfficer (eoID, username, fName, lName) Values (1, 'johntheEo', 'John', 'Smith')";
        		//"insert into User ( username, userpass, emailAddress, firstname, lastname, address, phone ) values ( ?, ?, ?, ?, ?, ?, ? )";              
        String               updateUserSql = "update User  set username = ?, userpass = ?, emailAddress = ?, firstname = ?, lastname = ?, address = ?, phone = ? where id = ?";              
        PreparedStatement    stmt;
        int                  inscnt;
        long                 UserId;
        
        try {
            
            if( !User.isPersistent() )
                stmt = (PreparedStatement) conn.prepareStatement( insertUserSql );
            else
                stmt = (PreparedStatement) conn.prepareStatement( updateUserSql );

            if( User.getUserName() != null ) // ElectionsOfficersuser is unique, so it is sufficient to get a User
                stmt.setString( 1, User.getUserName() );
            else 
                throw new EVException( "UserManager.save: can't save a User: userName undefined" );

            if( User.getPassword() != null )
                stmt.setString( 2, User.getPassword() );
            else
                throw new EVException( "UserManager.save: can't save a User: password undefined" );

            if( User.getEmailAddress() != null )
                stmt.setString( 3,  User.getEmailAddress() );
            else
                throw new EVException( "UserManager.save: can't save a User: emailAddress undefined" );

            if( User.getFirstName() != null )
                stmt.setString( 4, User.getFirstName() );
            else
                throw new EVException( "UserManager.save: can't save a User: first name undefined" );

            if( User.getLastName() != null )
                stmt.setString( 5, User.getLastName() );
            else
                throw new EVException( "UserManager.save: can't save a User: last name undefined" );

            if( User.getAddress() != null )
                stmt.setString( 6, User.getAddress() );
            else
                stmt.setNull(6, java.sql.Types.VARCHAR);

            //if( User.getPhone() != null )
               // stmt.setString( 7,  User.getPhone() );
            //else
              //  stmt.setNull(7, java.sql.Types.VARCHAR);
            
            if( User.isPersistent() )
                stmt.setLong( 8, User.getId() );

            inscnt = stmt.executeUpdate();

            if( !User.isPersistent() ) {
                // in case this this object is stored for the first time,
                // we need to establish its persistent identifier (primary key)
                if( inscnt == 1 ) {
                    String sql = "select last_insert_id()";
                    if( stmt.execute( sql ) ) { // statement returned a result
                        // retrieve the result
                        ResultSet r = stmt.getResultSet();
                        // we will use only the first row!
                        while( r.next() ) {
                            // retrieve the last insert auto_increment value
                            UserId = r.getLong( 1 );
                            if( UserId > 0 )
                                User.setId( UserId ); // set this User's db id (proxy object)
                        }
                    }
                }
            }
            else {
                if( inscnt < 1 )
                    throw new EVException( "UserManager.save: failed to save a User" ); 
            }
        }
        catch( SQLException e ) {
            e.printStackTrace();
            throw new EVException( "UserManager.save: failed to save a User: " + e );
        }
    }

    public List<User> restore( User modelUser ) 
            throws EVException
    {
        String       selectUserSql = "select id, username, userpass, emailAddress, firstname, lastname, address, phone from User";
        Statement    stmt = null;
        StringBuffer query = new StringBuffer( 100 );
        StringBuffer condition = new StringBuffer( 100 );
        List<User> Users = new ArrayList<User>();

        condition.setLength( 0 );
        
        // form the query based on the given User object instance
        query.append( selectUserSql );
        
        if( modelUser != null ) {
            if( modelUser.getId() >= 0 ) // id is unique, so it is sufficient to get a User
                query.append( " where id = " + modelUser.getId() );
            else if( modelUser.getUserName() != null ) // userName is unique, so it is sufficient to get a User
                query.append( " where username = '" + modelUser.getUserName() + "'" );
            else {
                if( modelUser.getPassword() != null )
                    condition.append( " password = '" + modelUser.getPassword() + "'" );

                if( modelUser.getEmailAddress() != null ) {
                    if( condition.length() > 0 )
                        condition.append( " and" );
                    condition.append( " emailAddress = '" + modelUser.getEmailAddress() + "'" );
                }

                if( modelUser.getFirstName() != null ) {
                    if( condition.length() > 0 )
                        condition.append( " and" );
                    condition.append( " firstName = '" + modelUser.getFirstName() + "'" );
                }

                if( modelUser.getLastName() != null ) {
                    if( condition.length() > 0 )
                        condition.append( " and" );
                    condition.append( " lastName = '" + modelUser.getLastName() + "'" );
                }

                if( modelUser.getAddress() != null ) {
                    if( condition.length() > 0 )
                        condition.append( " and" );
                    condition.append( " address = '" + modelUser.getAddress() + "'" );
                }        

                /*if( modelUser.getPhone() != null ) {
                    if( condition.length() > 0 )
                        condition.append( " and" );
                    condition.append( " phone = '" + modelUser.getPhone() + "'" );
                }*/

                if( condition.length() > 0 ) {
                    query.append(  " where " );
                    query.append( condition );
                }
            }
        }
        
        try {

            stmt = conn.createStatement();

            // retrieve the persistent User objects
            //
            if( stmt.execute( query.toString() ) ) { // statement returned a result
                ResultSet rs = stmt.getResultSet();
                long   id;
                String userName;
                String password;
                String emailAddress;
                String firstName;
                String lastName;
                String address;
                String phone;  
                
                while( rs.next() ) {

                    id = rs.getLong( 1 );
                    userName = rs.getString( 2 );
                    password = rs.getString( 3 );
                    emailAddress = rs.getString( 4 );
                    firstName = rs.getString( 5 );
                    lastName = rs.getString( 6 );
                    address = rs.getString( 7 );
                    phone = rs.getString( 8 );

                    User User = objectLayer.createElectionsOfficer(firstName, lastName, userName, password, emailAddress, address);
                    User.setId( id );

                    Users.add( User );

                }
                
                return Users;
            }
        }
        catch( Exception e ) {      // just in case...
            throw new EVException( "UserManager.restore: Could not restore persistent User object; Root cause: " + e );
        }
        
        // if we get to this point, it's an error
        throw new EVException( "UserManager.restore: Could not restore persistent User objects" );
    }
    
    public List<ElectionsOfficer> restoreElectionsOfficerEstablishedByUser( User User ) 
            throws EVException
    {
        String selectUserSql = "select c.id, c.name, c.address, c.established, p.id, " +
                                 "p.username, p.userpass, p.emailAddress, p.firstname, p.lastname, p.address, " +
                                 "p.phone from ElectionsOfficer c, User p where c.founderid = p.id";
        Statement    stmt = null;
        StringBuffer query = new StringBuffer( 100 );
        StringBuffer condition = new StringBuffer( 100 );
        List<ElectionsOfficer>   ElectionsOfficers = new ArrayList<ElectionsOfficer>();

        condition.setLength( 0 );
        
        // form the query based on the given User object instance
        query.append( selectUserSql );
        
        if( User != null ) {
            if( User.getId() >= 0 ) // id is unique, so it is sufficient to get a User
                query.append( " and p.id = " + User.getId() );
            else if( User.getUserName() != null ) // userName is unique, so it is sufficient to get a User
                query.append( " and p.username = '" + User.getUserName() + "'" );
            else {
                if( User.getPassword() != null )
                    condition.append( " p.password = '" + User.getPassword() + "'" );

                if( User.getEmailAddress() != null && condition.length() == 0 )
                    condition.append( " p.emailAddress = '" + User.getEmailAddress() + "'" );
                else
                    condition.append( " AND p.emailAddress = '" + User.getEmailAddress() + "'" );

                if( User.getFirstName() != null && condition.length() == 0 )
                    condition.append( " p.firstname = '" + User.getFirstName() + "'" );
                else
                    condition.append( " AND p.firstname = '" + User.getFirstName() + "'" );

                if( User.getLastName() != null && condition.length() == 0 )
                    condition.append( " p.lastname = '" + User.getLastName() + "'" );
                else
                    condition.append( " AND p.lastname = '" + User.getLastName() + "'" );

                if( User.getAddress() != null && condition.length() == 0 )
                    condition.append( " p.address = '" + User.getAddress() + "'" );
                else
                    condition.append( " AND p.address = '" + User.getAddress() + "'" );         

                /*if( User.getPhone() != null && condition.length() == 0 )
                    condition.append( " p.phone = '" + User.getPhone() + "'" );
                else
                    condition.append( " AND p.phone = '" + User.getPhone() + "'" );
                */
                if( condition.length() > 0 ) {
                    query.append( condition );
                }
            }
        }
                
        try {

            stmt = conn.createStatement();

            // retrieve the persistent ElectionsOfficer objects
            //
            if( stmt.execute( query.toString() ) ) { // statement returned a result
                          
                long   id;
                String name;
                String address;
                Date   establishedOn;
                ElectionsOfficer   nextElectionsOfficer = null;
                
                ResultSet rs = stmt.getResultSet();
                
                while( rs.next() ) {
                    
                    id = rs.getLong( 1 );
                    name = rs.getString( 2 );
                    address = rs.getString( 3 );
                    establishedOn = rs.getDate( 4 );
                    
                    nextElectionsOfficer = objectLayer.createElectionsOfficer(); // create a proxy ElectionsOfficer object
                    // and now set its retrieved attributes
                    nextElectionsOfficer.setId( id );
                    nextElectionsOfficer.setUserName( name );
                    nextElectionsOfficer.setAddress( address );
                    //nextElectionsOfficer.setEstablishedOn( establishedOn );
                    // set this to null for the "lazy" association traversal
                    //nextElectionsOfficer.setUserFounder( null );
                    
                    ElectionsOfficers.add( nextElectionsOfficer );
                }
                
                return ElectionsOfficers;
            }
        }
        catch( Exception e ) {      // just in case...
            throw new EVException( "UserManager.restoreEstablishedBy: Could not restore persistent ElectionsOfficer objects; Root cause: " + e );
        }

        throw new EVException( "UserManager.restoreEstablishedBy: Could not restore persistent ElectionsOfficer objects" );
    }
    
    public void delete( User User ) 
            throws EVException
    {
        String               deleteUserSql = "delete from User where id = ?";              
        PreparedStatement    stmt = null;
        int                  inscnt;
        
        // form the query based on the given User object instance
        if( !User.isPersistent() ) // is the User object persistent?  If not, nothing to actually delete
            return;
        
        try {
            
            //DELETE t1, t2 FROM t1, t2 WHERE t1.id = t2.id;
            //DELETE FROM t1, t2 USING t1, t2 WHERE t1.id = t2.id;
            stmt = (PreparedStatement) conn.prepareStatement( deleteUserSql );
            
            stmt.setLong( 1, User.getId() );
            
            inscnt = stmt.executeUpdate();
            
            if( inscnt == 0 ) {
                throw new EVException( "UserManager.delete: failed to delete this User" );
            }
        }
        catch( SQLException e ) {
            throw new EVException( "UserManager.delete: failed to delete this User: " + e.getMessage() );
        }
    }
}
