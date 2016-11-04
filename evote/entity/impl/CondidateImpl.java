package edu.uga.cs.evote.entity.impl;

import edu.uga.cs.evote.EVException;
import edu.uga.cs.evote.entity.Candidate;
import edu.uga.cs.evote.entity.Election;
import edu.uga.cs.evote.entity.PoliticalParty;

public class CondidateImpl implements Candidate {

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setId(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isPersistent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getVoteCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setVoteCount(int voteCount) throws EVException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addVote() {
		// TODO Auto-generated method stub

	}

	@Override
	public Election getElection() throws EVException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setElection(Election election) throws EVException {
		// TODO Auto-generated method stub

	}

	@Override
	public PoliticalParty getPoliticalParty() throws EVException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPoliticalParty(PoliticalParty politicalParty) throws EVException {
		// TODO Auto-generated method stub

	}

}
