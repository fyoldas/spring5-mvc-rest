package guru.springfamework.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;

@Component
public class BootStrap implements CommandLineRunner{
	
	private CategoryRepository categoryRepository;
	private CustomerRepository customerRepository;
	
	public BootStrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
		this.categoryRepository = categoryRepository;
		this.customerRepository = customerRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		loadCategories();
		loadCustomers();
		
		System.out.println("#### Data loaded:" + categoryRepository.findAll().size());
		
	}

	private void loadCustomers() {
		Customer customer1 = new Customer();
		customer1.setId(1L);
		customer1.setFirstName("fatih");
		customer1.setLastName("Yoldaş");
		customerRepository.save(customer1);
		
		Customer customer2 = new Customer();
		customer2.setId(2L);
		customer2.setFirstName("Ahmet");
		customer2.setLastName("Yüzgeç");
		customerRepository.save(customer2);
	}

	private void loadCategories() {
		Category fruits = new Category();
		fruits.setName("Fruits");
		
		Category dried = new Category();
		dried.setName("Dried");
		
		Category fresh = new Category();
		fresh.setName("Fresh");
		
		Category exotic = new Category();
		exotic.setName("Exotic");
		
		Category nuts = new Category();
		nuts.setName("Nuts");
		
		categoryRepository.save(fruits);
		categoryRepository.save(dried);
		categoryRepository.save(fresh);
		categoryRepository.save(exotic);
		categoryRepository.save(nuts);
	}

}
