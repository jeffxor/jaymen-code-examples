package com.jaymen.candidate.service;

import java.util.List;

import com.jaymen.candidate.dao.exceptions.DaoStoreException;
import com.jaymen.candidate.model.Organisation;

/**
 * Defines service level operations allowed for organisation entities.
 */
public interface OrganisationService {
	Organisation persist(Organisation organisation) throws DaoStoreException;
	void remove(Organisation organisation) throws DaoStoreException;
    Organisation findById(Integer id);
    List<Organisation> findAll();
}
