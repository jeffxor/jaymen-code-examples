package com.jaymen.flex.database.dao;

import java.util.List;

import com.jaymen.flex.database.domain.Organisation;

public interface OrganisationDao {

	public List<Organisation> getOrganisations();
	public List<Organisation> findOrganisationsByName(String name);
	public Organisation getOrganisation(Integer id);
	public Boolean updateOrganisation(Organisation organisation);
	public Boolean insertOrganisation(Organisation organisation);
	public Boolean removeOrganisation(Integer id);
}
