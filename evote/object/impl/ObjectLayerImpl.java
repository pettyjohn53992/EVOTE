package edu.uga.cs.evote.object.impl;

import java.util.Date;
import java.util.List;

import edu.uga.cs.evote.EVException;
import edu.uga.cs.evote.entity.Ballot;
import edu.uga.cs.evote.entity.Candidate;
import edu.uga.cs.evote.entity.Election;
import edu.uga.cs.evote.entity.ElectionsOfficer;
import edu.uga.cs.evote.entity.ElectoralDistrict;
import edu.uga.cs.evote.entity.Issue;
import edu.uga.cs.evote.entity.PoliticalParty;
import edu.uga.cs.evote.entity.VoteRecord;
import edu.uga.cs.evote.entity.Voter;
import edu.uga.cs.evote.entity.impl.ElectionsOfficerImpl;
import edu.uga.cs.evote.object.ObjectLayer;

public class ObjectLayerImpl implements ObjectLayer {

	@Override
	public ElectionsOfficer createElectionsOfficer(String firstName, String lastName, String userName, String password,
			String emailAddress, String address) throws EVException {
		// TODO Auto-generated method stub
		return new ElectionsOfficerImpl(firstName, lastName, userName, password, emailAddress, address);
	}

	@Override
	public ElectionsOfficer createElectionsOfficer() {
		// TODO Auto-generated method stub
		return new ElectionsOfficerImpl();
	}

	@Override
	public List<ElectionsOfficer> findElectionsOfficer(ElectionsOfficer modelElectionsOfficer) throws EVException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void storeElectionsOfficer(ElectionsOfficer electionsOfficer) throws EVException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteElectionsOfficer(ElectionsOfficer electionsOfficer) throws EVException {
		// TODO Auto-generated method stub

	}

	@Override
	public Voter createVoter(String firstName, String lastName, String userName, String password, String emailAddress,
			String address, int age) throws EVException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Voter createVoter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Voter> findVoter(Voter modelVoter) throws EVException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void storeVoter(Voter voter) throws EVException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteVoter(Voter voter) throws EVException {
		// TODO Auto-generated method stub

	}

	@Override
	public PoliticalParty createPoliticalParty(String name) throws EVException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PoliticalParty createPoliticalParty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PoliticalParty> findPoliticalParty(PoliticalParty modelPoliticalParty) throws EVException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void storePoliticalParty(PoliticalParty politicalParty) throws EVException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePoliticalParty(PoliticalParty politicalParty) throws EVException {
		// TODO Auto-generated method stub

	}

	@Override
	public ElectoralDistrict createElectoralDistrict(String name) throws EVException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ElectoralDistrict createElectoralDistrict() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ElectoralDistrict> findElectoralDistrict(ElectoralDistrict modelElectoralDistrict) throws EVException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void storeElectoralDistrict(ElectoralDistrict electoralDistrict) throws EVException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteElectoralDistrict(ElectoralDistrict electoralDistrict) throws EVException {
		// TODO Auto-generated method stub

	}

	@Override
	public Ballot createBallot(Date openDate, Date closeDate, boolean approved, ElectoralDistrict electoralDistrict)
			throws EVException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ballot createBallot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ballot> findBallot(Ballot modelBallot) throws EVException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void storeBallot(Ballot ballot) throws EVException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBallot(Ballot ballot) throws EVException {
		// TODO Auto-generated method stub

	}

	@Override
	public Candidate createCandidate(String name, PoliticalParty politicalParty, Election election) throws EVException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Candidate createCandidate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Candidate> findCandidate(Candidate modelCandidate) throws EVException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void storeCandidate(Candidate candidate) throws EVException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCandidate(Candidate candidate) throws EVException {
		// TODO Auto-generated method stub

	}

	@Override
	public Issue createIssue(String question) throws EVException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Issue createIssue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Issue> findIssue(Issue modelIssue) throws EVException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void storeIssue(Issue issue) throws EVException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteIssue(Issue issue) throws EVException {
		// TODO Auto-generated method stub

	}

	@Override
	public Election createElection(String office, boolean isPartisan) throws EVException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Election createElection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Election> findElection(Election modelElection) throws EVException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void storeElection(Election election) throws EVException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteElection(Election election) throws EVException {
		// TODO Auto-generated method stub

	}

	@Override
	public VoteRecord createVoteRecord(Ballot ballot, Voter voter, Date date) throws EVException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VoteRecord createVoteRecord() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VoteRecord> findVoteRecord(VoteRecord modelVoteRecord) throws EVException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void storeVoteRecord(VoteRecord voteRecord) throws EVException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteVoteRecord(VoteRecord voteRecord) throws EVException {
		// TODO Auto-generated method stub

	}

}
