package br.com.ultragaz.monitoring.application.service;

import br.com.ultragaz.monitoring.application.service.dto.CreateCustomerRequest;
import br.com.ultragaz.monitoring.application.service.dto.CreateCustomerResponse;
import br.com.ultragaz.monitoring.application.service.dto.GetAllCustomersResponse;
import br.com.ultragaz.monitoring.application.service.dto.GetCustomerDetailsResponse;
import br.com.ultragaz.monitoring.application.service.exception.ApiException;

public interface CustomerService {
	
	CreateCustomerResponse handleCreateCustomer(CreateCustomerRequest request);
	
	GetAllCustomersResponse handleGetAllCustomers();
	
	GetCustomerDetailsResponse handleGetCustomerDetails(Integer id) throws ApiException;
	
}
