package com.wait.bootstrap;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.wait.domain.Customer;
import com.wait.domain.Product;
import com.wait.services.CustomerService;
import com.wait.services.ProductService;

@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private ProductService productService;
	@Autowired
	private CustomerService customerService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {

		loadProducts();
		loadCustomers();
	}
	
	public void loadProducts() {
		Product product1= new Product();
		product1.setDescription("Product 1");
		product1.setPrice(new BigDecimal("12.99"));
		product1.setImageUrl("http://wait.com/product1");
		productService.saveOrUpdate(product1);
		
		Product product2= new Product();
		product2.setDescription("Product 2");
		product2.setPrice(new BigDecimal("22.99"));
		product2.setImageUrl("http://wait.com/product2");
		productService.saveOrUpdate(product2);
		
		Product product3= new Product();
		product3.setDescription("Product 3");
		product3.setPrice(new BigDecimal("32.99"));
		product3.setImageUrl("http://wait.com/product3");
		productService.saveOrUpdate(product3);
		
		Product product4= new Product();
		product4.setDescription("Product 4");
		product4.setPrice(new BigDecimal("42.99"));
		product4.setImageUrl("http://wait.com/product4");
		productService.saveOrUpdate(product4);
		
		Product product5= new Product();
		product5.setDescription("Product 5");
		product5.setPrice(new BigDecimal("52.99"));
		product5.setImageUrl("http://wait.com/product5");
		productService.saveOrUpdate(product5);
		
		Product product6= new Product();
		product6.setDescription("Product 6");
		product6.setPrice(new BigDecimal("62.99"));
		product6.setImageUrl("http://wait.com/product6");
		productService.saveOrUpdate(product6);
	}
	
	public void loadCustomers() {
		Customer customer = new Customer();
		customer.setAddressLine1("Spokojna 1");
		customer.setAddressLine2("Niemila 1");
		customer.setCity("Warszawa1");
		customer.setEmail("test1@test.pl");
		customer.setFirstName("Alojzy1");
		customer.setLastName("Ags");
		customer.setPhoneNumber("620111111");
		customer.setState("mazowieckie");
		customer.setZipCode("00-111");
		customerService.saveOrUpdate(customer);
		
		Customer customer2 = new Customer();
		customer2.setAddressLine1("Spokojna 2");
		customer2.setAddressLine2("Niemila 2");
		customer2.setCity("Warszawa2");
		customer2.setEmail("test2@test.pl");
		customer2.setFirstName("Alojzy2");
		customer2.setLastName("Ags");
		customer2.setPhoneNumber("620222222");
		customer2.setState("mazowieckie");
		customer2.setZipCode("00-222");
		customerService.saveOrUpdate(customer2);
		
		Customer customer3 = new Customer();
		customer3.setAddressLine1("Spokojna 3");
		customer3.setAddressLine2("Niemila 3");
		customer3.setCity("Warszawa3");
		customer3.setEmail("test3@test.pl");
		customer3.setFirstName("Alojzy3");
		customer3.setLastName("Ags");
		customer3.setPhoneNumber("630333333");
		customer3.setState("mazowieckie");
		customer3.setZipCode("00-333");
		customerService.saveOrUpdate(customer3);
	}

}
