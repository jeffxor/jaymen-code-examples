package com.jaymen.candidate.service;

import java.util.Collection;

import com.jaymen.candidate.model.Candidate;

public interface CandidateService {
	void persist(Candidate candidate);
    void remove(Candidate candidate);
    Candidate findById(Integer id);
    Collection<Candidate> findAll();
}
