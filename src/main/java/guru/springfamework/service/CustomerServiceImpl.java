package guru.springfamework.service;

import java.util.List;

import org.springframework.stereotype.Service;

import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	private final CustomerRepository customerRepository;
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerByFirstName(String name) {
		return customerRepository.getCustomerByFirstName(name);
	}

	@Override
	public Customer getCustomerByLastName(String name) {
		return customerRepository.getCustomerByLastName(name);
	}

	@Override
	public Customer createNewCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Long id, Customer customer) {
		customer.setId(id);
		return customerRepository.save(customer);
	}

	@Override
	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}

	

}
