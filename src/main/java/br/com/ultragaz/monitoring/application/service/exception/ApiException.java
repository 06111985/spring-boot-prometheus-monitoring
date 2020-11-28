package br.com.ultragaz.monitoring.application.service.exception;

import br.com.ultragaz.monitoring.application.service.exception.error.ApiError;
import br.com.ultragaz.monitoring.application.service.exception.error.ErrorType;

public class ApiException extends Exception {

	private ApiError error;

	public ApiException(ErrorType errorType, String message) {
		super(message);
		this.error = new ApiError(errorType, message);
	}
	
	public ApiException(ErrorType errorType, String message, Throwable cause) {
		super(message, cause);
		this.error = new ApiError(errorType, message);
	}

	public ApiError getError() {
		return error;
	}

	public void setError(ApiError error) {
		this.error = error;
	}

}
