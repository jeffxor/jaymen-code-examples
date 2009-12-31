/*
 * Copyright Easynet 2006
 */
package com.jaymen.test.dvdstore;

/**
 * @author Jonathan Rogers
 *
 */
public interface DvdRepository {
	
	Dvd retrieveDvd(String reference) throws DvdNotFoundException;
}
