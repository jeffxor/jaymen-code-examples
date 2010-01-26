package com.jaymen.candidate.service;

import java.util.List;

import com.jaymen.candidate.dao.exceptions.DaoStoreException;
import com.jaymen.candidate.model.Employment;

/**
 * Defines service level operations allowed for employment entities.
 */
public interface EmploymentService {
	Employment persist(Employment employment) throws DaoStoreException;
	void remove(Employment employment) throws DaoStoreException;
    Employment findById(Integer id);
    List<Employment> findAll();
}
