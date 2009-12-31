package com.jaymen.test.dvdstore;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class DvdServiceImplTest {
	
	private static final String INVALID_TEXT = "INVALID-TEXT";
	private static final String DVD_999 = "DVD-999";
	Dvd topGunDvd  = new DvdReferenceImpl(DvdRepositoryReferenceImpl.DVD_TOPGUN_REFERENCE, "Topgun", "All action film");

	private DvdService dvdService;
	
	@Before 
	public void initialize() {
		dvdService = new DvdServiceImpl();
	}
	
	@After 
	public void cleanUp() {
		dvdService = null;
	}
	
	@Test(expected = DvdInvalidReferenceException.class) 
	public void retrieveDvdInvalidText() throws DvdNotFoundException, DvdInvalidReferenceException{
		dvdService.retrieveDvd(INVALID_TEXT);
	}

	@Test(expected = DvdNotFoundException.class) 
	public void retrieveDvdDVD999() throws DvdNotFoundException{
		dvdService.retrieveDvd(DVD_999);
	}
	
	@Test
	public void retrieveDvdDVDTG423() throws DvdNotFoundException{
		Dvd dvdRetrieved = dvdService.retrieveDvd(DvdRepositoryReferenceImpl.DVD_TOPGUN_REFERENCE);
		
		assertEquals(topGunDvd.getReference(), dvdRetrieved.getReference());
		assertEquals(topGunDvd.getTitle(), dvdRetrieved.getTitle());
		assertEquals(topGunDvd.getReview(), dvdRetrieved.getReview());
		
	}
	
	@Test (expected=DvdNotFoundException.class) 
	public void getDvdSummaryInvalidText() throws DvdNotFoundException{
		dvdService.getDvdSummary(INVALID_TEXT);
	}
	
	@Test (expected=DvdNotFoundException.class) 
	public void getDvdSummaryDVD999() throws DvdNotFoundException{
		dvdService.getDvdSummary(DVD_999);
	}
	
	@Test 
	public void getDvdSummaryDVDTG423() throws DvdNotFoundException{
		assertEquals(DvdReferenceImplTest.topgunSummary, dvdService.getDvdSummary(DvdRepositoryReferenceImpl.DVD_TOPGUN_REFERENCE));	
	}
	
	@Test 
	public void getDvdSummaryDVDTS765() throws DvdNotFoundException{
		assertEquals(DvdReferenceImplTest.shrekSummary, dvdService.getDvdSummary(DvdRepositoryReferenceImpl.DVD_SHREK_REFERENCE));			
	}
}
