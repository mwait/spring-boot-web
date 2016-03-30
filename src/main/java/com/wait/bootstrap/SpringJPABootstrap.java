package com.wait.bootstrap;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.wait.domain.Product;
import com.wait.services.ProductService;

@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private ProductService productService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {

		loadProducts();
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

}
