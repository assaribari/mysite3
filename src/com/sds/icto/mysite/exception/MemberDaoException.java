package com.sds.icto.mysite.exception;

public class MemberDaoException extends RuntimeException {
	private static final long serialversionUID = 1L;
	
	public MemberDaoException() {
		super( " Member Dao Exception" );
	}
	
	public MemberDaoException( String msg ) {
		super( msg );
	}
}
