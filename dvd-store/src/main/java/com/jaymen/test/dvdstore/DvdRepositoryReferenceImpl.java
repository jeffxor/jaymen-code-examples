/*
 * Copyright Easynet 2006
 */
package com.jaymen.test.dvdstore;

import java.util.HashMap;
import java.util.Map;

public class DvdRepositoryReferenceImpl implements DvdRepository {

	protected static final String DVD_REFERENCE_PREFIX = "DVD-";
	
	protected static final String DVD_TOPGUN_REFERENCE = DVD_REFERENCE_PREFIX + "TG423";
	protected static final String DVD_DIRTYDANCING_REFERENCE = DVD_REFERENCE_PREFIX + "DD878";
	protected static final String DVD_SHREK_REFERENCE = DVD_REFERENCE_PREFIX + "S765";
	
	private static final Map<String, DvdReferenceImpl> dvds;
	
	static {
		dvds = new HashMap<String, DvdReferenceImpl>();
		dvds.put(DVD_TOPGUN_REFERENCE, 
			new DvdReferenceImpl(DVD_TOPGUN_REFERENCE, "Topgun", "All action film"));
		dvds.put(DVD_DIRTYDANCING_REFERENCE, 
			new DvdReferenceImpl(DVD_DIRTYDANCING_REFERENCE, "Dirty Dancing", "Nobody leaves baby in the corner"));
		dvds.put(DVD_SHREK_REFERENCE, 
			new DvdReferenceImpl(DVD_SHREK_REFERENCE, "Shrek", "Green monsters seem to be all " +
					"the rage these days, what with Hulk, Yoda, and that big ugly troll " +
					"thingy out of the first Harry Potter movie. But Shrek, the flatulent " +
					"swamp-dwelling ogre with a heart of gold (well, silver at least), " +
					"is more than capable of rivalling any of them."));
	}
	
	/* (non-Javadoc)
	 * @see com.easynet.dvdstore.DvdRepository#retrieveDvd(java.lang.String)
	 */
	public Dvd retrieveDvd(String reference) throws DvdNotFoundException {
		Dvd dvd = (Dvd) dvds.get(reference);
		if(dvd == null) throw new DvdNotFoundException();
		return dvd;
	}
}
