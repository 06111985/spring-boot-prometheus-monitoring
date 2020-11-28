package br.com.ultragaz.monitoring.application.service.exception;

import br.com.ultragaz.monitoring.application.service.exception.error.ErrorType;
import br.com.ultragaz.monitoring.domain.exception.BusinessException;
import br.com.ultragaz.monitoring.domain.exception.CustomerNotFoundException;

public class BusinessExceptionTranslator {

	public static void translate(BusinessException e) throws ApiException {
		if (e instanceof CustomerNotFoundException) {
			throw new ApiException(ErrorType.NOT_FOUND, e.getMessage(), e);
		} else {
			throw new ApiException(ErrorType.TECHNICAL, "Erro desconhecido", e);
		}
	}

}
