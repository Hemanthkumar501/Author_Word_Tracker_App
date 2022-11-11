package com.book.onboard.exceptionhandling;

public class ExceptionResponse {

	private String errorMessage;
	private String reqURI;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getReqURI() {
		return reqURI;
	}
	public void setReqURI(String reqURI) {
		this.reqURI = reqURI;
	}
}
