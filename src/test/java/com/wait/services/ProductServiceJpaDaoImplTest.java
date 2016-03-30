package com.wait.services;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wait.config.JpaIntegrationConfig;
import com.wait.domain.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(JpaIntegrationConfig.class)
@ActiveProfiles("jpadao")
public class ProductServiceJpaDaoImplTest {
	
	@Autowired
	private ProductService productService;
	
	@Test
	public void testListMethod() throws Exception {
		List<Product> products = (List<Product>) productService.listAll();
		assert products.size() == 6;
	}
	

}
