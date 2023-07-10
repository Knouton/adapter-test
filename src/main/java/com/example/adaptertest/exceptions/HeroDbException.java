package com.example.adaptertest.exceptions;

public class HeroDbException extends HeroException {

	private static final long serialVersionUID = 1;

	public static final String ERROR_CODE = "02";
	public static final String ERROR_DESCRIPTION = "db execution error";

	public HeroDbException(final String message, final Throwable cause) {
		super(ERROR_CODE, ERROR_DESCRIPTION, message, cause);
	}
}
