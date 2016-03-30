package com.wait.services;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
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
	
	@Test
	public void testGetById() throws Exception {
		Integer id = 1;
		Product product = productService.getById(id);
		assertNotNull(product);
	}
	
	@Test
	public void testSaveOrUpdate() throws Exception {
		Product product = new Product();
		product.setDescription("Test to delete");
		product.setImageUrl("http://test.pl");
		product.setPrice(new BigDecimal("11.00"));
		Product productSave = productService.saveOrUpdate(product);
		assertEquals(product.getPrice(), productSave.getPrice());
		assertEquals(product.getDescription(), productSave.getDescription());
	}
	
	@Test
	public void testDelete() throws Exception {
		Product product = new Product();
		product.setDescription("Test to delete");
		product.setImageUrl("http://test.pl");
		product.setPrice(new BigDecimal("11.00"));
		Product productSave = productService.saveOrUpdate(product);
		productService.delete(productSave.getId());
		assertNull(productService.getById(productSave.getId()));
	}
}
