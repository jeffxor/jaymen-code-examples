package com.jaymen.spring.dao;



import java.util.List;

import com.jaymen.spring.model.Candidate;

public interface CandidateDao {

	public Candidate getCandidate(Integer id);
	public List<Candidate> getCandidates();
	public Boolean addCandidate(Candidate candidate);
	public Boolean updateCandidate(Candidate candidate);
}
