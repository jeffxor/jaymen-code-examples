package com.jaymen.test.dvdstore;

public class DvdServiceImpl implements DvdService{
	private DvdRepository dvdRepository = new DvdRepositoryReferenceImpl();

	public String getDvdSummary(String dvdReference)
			throws DvdNotFoundException {
		checkDvdReference(dvdReference);
		Dvd dvd = retrieveDvd(dvdReference);
		if(dvd != null){
			return dvd.getSummary();
		}
		return null;
	}

	public Dvd retrieveDvd(String dvdReference) throws DvdNotFoundException {
		checkDvdReference(dvdReference);
		return dvdRepository.retrieveDvd(dvdReference);
	}
	
	private void checkDvdReference(String dvdReference) throws DvdInvalidReferenceException {
		if(dvdReference == null) throw new DvdInvalidReferenceException();
		if(!(dvdReference.startsWith(DvdRepositoryReferenceImpl.DVD_REFERENCE_PREFIX))) throw new DvdInvalidReferenceException();
	}

}
