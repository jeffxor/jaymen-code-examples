package com.jaymen.candidate.mvc.service;


import java.util.List;

import com.jaymen.cv.schemas.types.Organisation;

public interface OrganisationService extends AbstractService<Integer, Organisation>{

	List<Organisation> searchOrganisations(String name);
}
