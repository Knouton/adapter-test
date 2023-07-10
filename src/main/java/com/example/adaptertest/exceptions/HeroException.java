package com.example.adaptertest.exceptions;

import lombok.Getter;

@Getter
public class HeroException extends RuntimeException {

	private static final long serialVersionUID = 1;

	protected final String errorCode;
	protected final String errorDescription;
	protected final String message;

	public HeroException(final String errorCode, final String errorDescription, final String message, final Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
		this.message = message;
	}

	public HeroException(final String errorCode, final String errorDescription, final String message) {
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
		this.message = message;
	}
}
