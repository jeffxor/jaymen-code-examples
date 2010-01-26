package com.jaymen.candidate.dao.exceptions;

public class DaoStoreException extends Exception {

	private static final long serialVersionUID = 1L;

	public DaoStoreException() {
	}

	public DaoStoreException(String message) {
		super(message);
	}

	public DaoStoreException(Throwable cause) {
		super(cause);
	}

	public DaoStoreException(String message, Throwable cause) {
		super(message, cause);
	}

}
