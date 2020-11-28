package br.com.ultragaz.monitoring.presentation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.ultragaz.monitoring.application.service.exception.ApiException;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ ApiException.class })
	public ResponseEntity<Object> handleApiException(ApiException e) {
		return ResponseEntity.status(e.getError().getStatusCode()).body(e.getError());
	}

}
