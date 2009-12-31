package com.jaymen.candidate.service;

import java.util.Collection;

import com.jaymen.candidate.model.Organisation;;

public interface OrganisationService {
	void persist(Organisation organisation);
    void remove(Organisation organisation);
    Organisation findById(Integer id);
    Collection<Organisation> findAll();
}
