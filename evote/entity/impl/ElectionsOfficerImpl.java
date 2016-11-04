package edu.uga.cs.evote.entity.impl;

import edu.uga.cs.evote.entity.ElectionsOfficer;

public class ElectionsOfficerImpl extends UserImpl implements ElectionsOfficer {

	//default constructor, setting everything to null
	public ElectionsOfficerImpl()
	{
		super.setFirstName(null);
		super.setLastName(null);
		super.setUserName(null);
		super.setPassword(null);
		super.setAddress(null);
		super.setPersistencaLayer(getPersistencaLayer());
		super.setEmailAddress(null);
	}
	
	
	
	public ElectionsOfficerImpl(String firstName, String lastName, String userName, String password, String emailAddress, String address)
	{
		super.setFirstName(firstName);
		super.setLastName(lastName);
		super.setUserName(userName);
		super.setPassword(password);
		super.setAddress(address);
		super.setEmailAddress(emailAddress);
		
	}
	
	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return super.getFirstName();
	}

	@Override
	public void setFirstName(String firstName) {
		// TODO Auto-generated method stub
		super.setFirstName(firstName);

	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return super.getLastName();
	}

	@Override
	public void setLastName(String lastName) {
		// TODO Auto-generated method stub
		super.setLastName(lastName);
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return super.getUserName();
	}

	@Override
	public void setUserName(String userName) {
		// TODO Auto-generated method stub
		super.setUserName(userName);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		super.setPassword(password);
	}

	@Override
	public String getEmailAddress() {
		// TODO Auto-generated method stub
		return super.getEmailAddress();
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		// TODO Auto-generated method stub
		super.setEmailAddress(emailAddress);
	}

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return super.getAddress();
	}

	@Override
	public void setAddress(String address) {
		// TODO Auto-generated method stub
		super.setAddress(address);
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public void setId(long id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}

	@Override
	public boolean isPersistent() {
		// TODO Auto-generated method stub
		return super.isPersistent();
	}

}
