package br.com.ultragaz.monitoring.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ultragaz.monitoring.domain.entity.Customer;
import br.com.ultragaz.monitoring.domain.exception.CustomerNotFoundException;
import br.com.ultragaz.monitoring.domain.service.CustomerBusinessService;
import br.com.ultragaz.monitoring.infrastructure.repository.CustomerRepository;

@Service
public class CustomerBusinessServiceImpl implements CustomerBusinessService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer create(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(Integer id) throws CustomerNotFoundException {
		return customerRepository.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException("Cliente não encontrado"));
	}

	@Override
	public void delete(Integer id) {
		customerRepository.deleteById(id);
	}

}
