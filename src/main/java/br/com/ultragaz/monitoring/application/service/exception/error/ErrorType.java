package br.com.ultragaz.monitoring.application.service.exception.error;

import org.springframework.http.HttpStatus;

public enum ErrorType {

	NOT_FOUND(HttpStatus.NOT_FOUND),
	TECHNICAL(HttpStatus.INTERNAL_SERVER_ERROR);
	
	private HttpStatus httpStatus;

	private ErrorType(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public HttpStatus status() {
		return httpStatus;
	}

}
