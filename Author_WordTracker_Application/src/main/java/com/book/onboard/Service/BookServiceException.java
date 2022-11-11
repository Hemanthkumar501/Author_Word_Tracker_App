package com.book.onboard.Service;

import org.springframework.stereotype.Service;

@Service
public class BookServiceException extends Exception {
	private static final long serialVersionUID = -470180507998010368L;

	public  BookServiceException() {
		super();
	}

	public BookServiceException(final String message) {
		super(message);
	}
}