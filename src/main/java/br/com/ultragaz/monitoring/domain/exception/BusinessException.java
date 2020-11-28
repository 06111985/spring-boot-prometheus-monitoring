package br.com.ultragaz.monitoring.domain.exception;

import java.util.Date;

public abstract class BusinessException extends Exception {

	private Date timestamp;

	public BusinessException(String message) {
		super(message);
		this.timestamp = new Date();
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
