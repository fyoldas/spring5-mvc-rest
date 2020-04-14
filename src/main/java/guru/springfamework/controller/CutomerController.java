package guru.springfamework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springfamework.domain.Customer;
import guru.springfamework.domain.Customers;
import guru.springfamework.service.CustomerService;

@Controller
@RequestMapping({ "/api/v1/customers", "/api/v1/customers/" })
public class CutomerController {

	private CustomerService customerService;

	public CutomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@GetMapping
	ResponseEntity<Customers> getAllCustomers() {
		Customers customers = new Customers();
		customers.setCustomers(customerService.getAllCustomers());
		return new ResponseEntity<Customers>(customers, HttpStatus.OK);
	}

	@GetMapping("firstname/{firstName}")
	ResponseEntity<Customer> getCustomerByFirstName(@PathVariable String firstName) {
		return new ResponseEntity<Customer>(customerService.getCustomerByFirstName(firstName), HttpStatus.OK);
	}

	@GetMapping("lastname/{lastName}")
	ResponseEntity<Customer> getCustomerByLastName(@PathVariable String lastName) {
		return new ResponseEntity<Customer>(customerService.getCustomerByLastName(lastName), HttpStatus.OK);
	}

	@PostMapping
	ResponseEntity<Customer> createNewCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.createNewCustomer(customer), HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.updateCustomer(id, customer), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
