package com.jaymen.candidate.dao.jpa;

import com.jaymen.candidate.dao.OrganisationDao;
import com.jaymen.candidate.model.Organisation;

/**
 * Implementation using Java Persistence API of the organisation dao interface.
 * 
 * The basic API function find, update, delete have been abstracted out to a base class
 * @see com.jaymen.candidate.dao.jpa.AbstractDao
 * 
 */
public class OrganisationDaoJpa extends AbstractDao<Integer, Organisation> implements OrganisationDao{

}
