package edu.uga.cs.evote.entity.impl;

import java.util.List;

import edu.uga.cs.evote.EVException;
import edu.uga.cs.evote.entity.Ballot;
import edu.uga.cs.evote.entity.ElectoralDistrict;
import edu.uga.cs.evote.entity.Voter;

public class ElectoralDistrictImpl implements ElectoralDistrict {

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
	public List<Voter> getVoters() throws EVException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ballot> getBallots() throws EVException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addBallot(Ballot ballot) throws EVException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBallot(Ballot ballot) throws EVException {
		// TODO Auto-generated method stub

	}

}
