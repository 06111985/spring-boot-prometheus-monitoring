package br.com.ultragaz.monitoring.application.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ultragaz.monitoring.application.service.CustomerService;
import br.com.ultragaz.monitoring.application.service.dto.CreateCustomerRequest;
import br.com.ultragaz.monitoring.application.service.dto.CreateCustomerResponse;
import br.com.ultragaz.monitoring.application.service.dto.GetAllCustomersResponse;
import br.com.ultragaz.monitoring.application.service.dto.GetAllCustomersResponseElement;
import br.com.ultragaz.monitoring.application.service.dto.GetCustomerDetailsResponse;
import br.com.ultragaz.monitoring.application.service.exception.ApiException;
import br.com.ultragaz.monitoring.application.service.exception.BusinessExceptionTranslator;
import br.com.ultragaz.monitoring.domain.entity.Customer;
import br.com.ultragaz.monitoring.domain.exception.CustomerNotFoundException;
import br.com.ultragaz.monitoring.domain.service.CustomerBusinessService;

@Service
public class CustomerWebService implements CustomerService {

	@Autowired
	private CustomerBusinessService customerBusinessService;

	@Autowired
	private ModelMapper mapper;

	@Override
	public CreateCustomerResponse handleCreateCustomer(CreateCustomerRequest request) {
		Customer createdCustomer = customerBusinessService.create(mapper.map(request, Customer.class));

		return mapper.map(createdCustomer, CreateCustomerResponse.class);
	}

	@Override
	public GetAllCustomersResponse handleGetAllCustomers() {
		GetAllCustomersResponse response = new GetAllCustomersResponse();
		customerBusinessService.findAll()
				.forEach(customer -> response.addElement(mapper.map(customer, GetAllCustomersResponseElement.class)));

		return response;
	}

	@Override
	public GetCustomerDetailsResponse handleGetCustomerDetails(Integer id) throws ApiException {
		try {
			return mapper.map(customerBusinessService.findById(id), GetCustomerDetailsResponse.class);
		} catch (CustomerNotFoundException e) {
			BusinessExceptionTranslator.translate(e);
		}

		return null;
	}

}
