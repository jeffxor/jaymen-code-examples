package com.jaymen.candidate.service;

import java.util.Collection;

import com.jaymen.candidate.model.Employment;;

public interface EmploymentService {
	void persist(Employment employment);
    void remove(Employment employment);
    Employment findById(Integer id);
    Collection<Employment> findAll();
}
