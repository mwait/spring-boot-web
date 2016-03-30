package com.wait.services;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wait.config.JpaIntegrationConfig;
import com.wait.domain.Customer;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(JpaIntegrationConfig.class)
@ActiveProfiles("jpadao")
public class CustomerServiceJpaDaoImplTest {
	
	@Autowired
	private CustomerService customerService;

	@Test
	public void testListAll() throws Exception {
		List<Customer> customers = (List<Customer>) customerService.listAll();
		assertEquals(customers.size(),3);
	}
}
