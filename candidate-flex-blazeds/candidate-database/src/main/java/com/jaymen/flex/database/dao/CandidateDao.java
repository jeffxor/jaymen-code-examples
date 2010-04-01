package com.jaymen.flex.database.dao;

import java.util.List;

import com.jaymen.flex.database.domain.Candidate;

public interface CandidateDao {

	public List<Candidate> getCandidates();
	public List<Candidate> findCandidatesByName(String name);
	public Candidate getCandidate(Integer id);
	public Boolean updateCandidate(Candidate candidate);
	public Boolean insertCandidate(Candidate candidate);
	public Boolean removeCandidate(Integer id);
}
