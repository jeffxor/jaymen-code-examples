package com.jaymen.candidate.dao.jpa;

import com.jaymen.candidate.dao.CandidateDao;
import com.jaymen.candidate.model.Candidate;

/**
 * Implementation using Java Persistence API of the candidate dao interface.
 * 
 * The basic API function find, update, delete have been abstracted out to a base class
 * @see com.jaymen.candidate.dao.jpa.AbstractDao
 * 
 */
public class CandidateDaoJpa extends AbstractDao<Integer, Candidate> implements CandidateDao{

}
