package com.jaymen.test.dvdstore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DvdReferenceImplTest {
	
	
	Dvd nullDvd = new DvdReferenceImpl("DVD-null", "nullDVD", null);
	Dvd exactDvd = new DvdReferenceImpl("DVD-exact","exactDVD","one two three four five six seven eight nine ten");
	Dvd topGunDvd  = new DvdReferenceImpl(DvdRepositoryReferenceImpl.DVD_TOPGUN_REFERENCE, "Topgun", "All action film");
	Dvd shrekDvd  = new DvdReferenceImpl(DvdRepositoryReferenceImpl.DVD_SHREK_REFERENCE, "Shrek", "Green monsters seem to be all " +
			"the rage these days, what with Hulk, Yoda, and that big ugly troll " +
			"thingy out of the first Harry Potter movie. But Shrek, the flatulent " +
			"swamp-dwelling ogre with a heart of gold (well, silver at least), " +
			"is more than capable of rivalling any of them.");
	
	protected static final String topgunSummary = "[DVD-TG423]Topgun - All action film";
	protected static final String shrekSummary = "[DVD-S765]Shrek - Green monsters seem to be all the rage these days...";

	@Before 
	public void init(){
	}
	

	@Test (expected=NullPointerException.class) 
	public void summaryWithNull(){
		nullDvd.getSummary();
	}
	
	@Test public void summaryLessWords(){
		assertEquals("[DVD-TG423]Topgun - All action film", topGunDvd.getSummary());
	}

	@Test public void shortenReviewExactWords(){
		assertEquals("[DVD-exact]exactDVD - one two three four five six seven eight nine ten", exactDvd.getSummary());		
	}

	@Test public void shortenReviewMoreWords(){
		assertEquals("[DVD-S765]Shrek - Green monsters seem to be all the rage these days...", shrekDvd.getSummary());

	}
}
