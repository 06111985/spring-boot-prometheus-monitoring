package br.com.ultragaz.monitoring.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ultragaz.monitoring.application.service.CustomerService;
import br.com.ultragaz.monitoring.application.service.dto.CreateCustomerRequest;
import br.com.ultragaz.monitoring.application.service.dto.GetAllCustomersResponse;
import br.com.ultragaz.monitoring.application.service.dto.GetCustomerDetailsResponse;
import br.com.ultragaz.monitoring.application.service.exception.ApiException;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping
	public ResponseEntity<Object> handleRequestOfCreateCustomer(@RequestBody CreateCustomerRequest request) {
		customerService.handleCreateCustomer(request);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping
	public ResponseEntity<Object> handleRequestOfGetAllCustomers() {
		GetAllCustomersResponse response = customerService.handleGetAllCustomers();

		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> handleRequestOfGetCustomerById(@PathVariable("id") Integer id) throws ApiException {
		GetCustomerDetailsResponse response = customerService.handleGetCustomerDetails(id);

		return ResponseEntity.ok(response);
	}

}
