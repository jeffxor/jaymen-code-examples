package com.jaymen.candidate.dao;

import java.util.List;

import com.jaymen.candidate.domain.Organisation;

public interface OrganisationDao {

	public List<Organisation> getOrganisations();
	public List<Organisation> findOrganisationsByName(String name);
	public Organisation getOrganisation(Integer id);
	public Organisation updateOrganisation(Organisation organisation);
	public Organisation insertOrganisation(Organisation organisation);
	public Boolean removeOrganisation(Integer id);
}
