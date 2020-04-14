package guru.springfamework.service;

import java.util.List;

import guru.springfamework.domain.Customer;

public interface CustomerService {

	 List<Customer> getAllCustomers();
	 Customer getCustomerByFirstName(String name);
	 Customer getCustomerByLastName(String name);
	 Customer createNewCustomer(Customer customer);
	 Customer updateCustomer(Long id, Customer customer);
	 void deleteCustomer(Long id);
}
