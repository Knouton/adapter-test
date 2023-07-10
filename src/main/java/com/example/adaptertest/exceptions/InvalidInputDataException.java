package com.example.adaptertest.exceptions;

public class InvalidInputDataException extends HeroException {

	private static final long serialVersionUID = 1;

	public static final String ERROR_CODE = "01";
	public static final String ERROR_DESCRIPTION = "invalid input data format";

	public InvalidInputDataException(final String message) {
		super(ERROR_CODE, ERROR_DESCRIPTION, message);
	}
}
