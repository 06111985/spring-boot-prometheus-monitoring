package br.com.ultragaz.monitoring.domain.service;

import java.util.List;

import br.com.ultragaz.monitoring.domain.entity.Customer;
import br.com.ultragaz.monitoring.domain.exception.CustomerNotFoundException;

public interface CustomerBusinessService {

	Customer create(Customer customer);

	List<Customer> findAll();

	Customer findById(Integer id) throws CustomerNotFoundException;

	void delete(Integer id);

}
