package com.wait.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wait.domain.Customer;
import com.wait.domain.DomainObject;

@Service
public class CustomerServiceImpl extends AbstractMapService implements CustomerService {

	@Override
	public List<DomainObject> listAll() { return super.listAll();}
	
	@Override
	public Customer getById(Integer id) {
		return (Customer) super.getById(id);
	}

	@Override
	public Customer saveOrUpdate(Customer domainObject) {
		return (Customer) super.saveOrUpdate(domainObject);
	}
	
	@Override
	public void delete(Integer id) {super.delete(id);}
	
	
	@Override
	protected void loadDomainObjects() {
		domainMap=new HashMap<>();
		
		Customer customer1 = new Customer();
		customer1.setId(1);
		customer1.setFirstName("Marek1");
		customer1.setLastName("Wait1");
		customer1.setAddressLine1("Konstytucji 1");
		customer1.setAddressLine2("Konstytucji 11");
		customer1.setCity("Warszawa");
		customer1.setState("mazowieckie");
		customer1.setZipCode("1111");
		customer1.setEmail("marek1@wait.com");
		customer1.setPhoneNumber("111-111-111");
		domainMap.put(1, customer1);
		
		Customer customer2 = new Customer();
		customer2.setId(2);
		customer2.setFirstName("Marek2");
		customer2.setLastName("Wait2");
		customer2.setAddressLine1("Konstytucji 2");
		customer2.setAddressLine2("Konstytucji 22");
		customer2.setCity("Warszawa");
		customer2.setState("mazowieckie");
		customer2.setZipCode("2222");
		customer2.setEmail("marek2@wait.com");
		customer2.setPhoneNumber("222-222-222");
		domainMap.put(2, customer2);
		
		Customer customer3 = new Customer();
		customer3.setId(3);
		customer3.setFirstName("Marek3");
		customer3.setLastName("Wait3");
		customer3.setAddressLine1("Konstytucji 3");
		customer3.setAddressLine2("Konstytucji 33");
		customer3.setCity("Warszawa");
		customer3.setState("mazowieckie");
		customer3.setZipCode("3333");
		customer3.setEmail("marek3@wait.com");
		customer3.setPhoneNumber("333-333-333");
		domainMap.put(3, customer3);
		
		Customer customer4 = new Customer();
		customer4.setId(4);
		customer4.setFirstName("Marek4");
		customer4.setLastName("Wait4");
		customer4.setAddressLine1("Konstytucji 4");
		customer4.setAddressLine2("Konstytucji 44");
		customer4.setCity("Warszawa");
		customer4.setState("mazowieckie");
		customer4.setZipCode("4444");
		customer4.setEmail("marek4@wait.com");
		customer4.setPhoneNumber("444-444-444");
		domainMap.put(4, customer4);
		
		Customer customer5 = new Customer();
		customer5.setId(5);
		customer5.setFirstName("Marek5");
		customer5.setLastName("Wait5");
		customer5.setAddressLine1("Konstytucji 5");
		customer5.setAddressLine2("Konstytucji 55");
		customer5.setCity("Warszawa");
		customer5.setState("mazowieckie");
		customer5.setZipCode("5555");
		customer5.setEmail("marek5@wait.com");
		customer5.setPhoneNumber("555-555-555");
		domainMap.put(5, customer5);
	}



}
