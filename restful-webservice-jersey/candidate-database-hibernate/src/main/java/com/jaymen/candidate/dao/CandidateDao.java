package com.jaymen.candidate.dao;

import java.util.List;

import com.jaymen.candidate.domain.Candidate;

public interface CandidateDao {

	public List<Candidate> findCandidatesByName(String name);
	public List<Candidate> getCandidates();
	public Candidate getCandidate(Integer id);
	public Candidate updateCandidate(Candidate candidate);
	public Candidate insertCandidate(Candidate candidate);
	public Boolean removeCandidate(Integer id);
}
