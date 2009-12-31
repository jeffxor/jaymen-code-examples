/*
 * Copyright Easynet 2006
 */
package com.jaymen.test.dvdstore;

/**
 * @author Jonathan Rogers
 *
 */
public interface DvdService {

	public Dvd retrieveDvd(String dvdReference) throws DvdNotFoundException;

	public String getDvdSummary(String dvdReference) throws DvdNotFoundException;
}
