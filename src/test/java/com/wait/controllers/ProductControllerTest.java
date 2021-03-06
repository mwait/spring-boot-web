package com.wait.controllers;
import static org.hamcrest.CoreMatchers.*; //dla is

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;

//do hasSize
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.hasProperty;

//import do when
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.wait.domain.Product;
import com.wait.services.ProductService;


public class ProductControllerTest {

	@Mock //Mockito Mock object
	private ProductService productService;
	
	@InjectMocks //setup up controller, injects mock objects into it
	private ProductController productController;
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this); //initializes controller and mocks
		mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
		
	}
	
	@Test
	public void testList() throws Exception {
		List<Product> products = new ArrayList<>();
		products.add(new Product());
		products.add(new Product());
		
		//specific Mockito interaction, tell stub to return list of products
		when(productService.listAll()).thenReturn((List) products);
		mockMvc.perform(get("/product/products")).andExpect(status().isOk()).andExpect(view().name("product/products")).andExpect(model().attribute("products", hasSize(2)));
	}
	
	@Test
	public void testShow() throws Exception {
		Integer id=1;
		//tel mockito stub to return new product for ID1
		when(productService.getById(id)).thenReturn(new Product());
		mockMvc.perform(get("/product/product/1")).andExpect(status().isOk())
		.andExpect(view().name("product/product")).andExpect(model().attribute("product", instanceOf(Product.class)));
	}
	
	@Test
	public void testEdit() throws Exception {
		Integer id =1;
		//tell mockito stub to return new product for ID 1
		when(productService.getById(id)).thenReturn(new Product());
	
		mockMvc.perform(get("/product/product/edit/1")).andExpect(status().isOk()).andExpect(view().name("product/productform"))
		.andExpect(model().attribute("product", instanceOf(Product.class)));
	}
	
	@Test
	public void testNewProduct() throws Exception {
		Integer id=1;
		//should not call service
		verifyZeroInteractions(productService);
		
		mockMvc.perform(get("/product/product/new")).andExpect(status().isOk()).andExpect(view().name("product/productform"))
		.andExpect(model().attribute("product", instanceOf(Product.class)));
	}
	
	@Test
	public void testSaveOrUpdate() throws Exception {
		Integer id=1;
		String description="Test Description";
		BigDecimal price = new BigDecimal("12.00");
		String imageUrl="google.com";
		
		Product returnProduct = new Product();
		returnProduct.setId(1); 
		returnProduct.setDescription(description);
		returnProduct.setPrice(price);
		returnProduct.setImageUrl(imageUrl);
		
		when(productService.saveOrUpdate(Matchers.<Product>any())).thenReturn(returnProduct);
		
		mockMvc.perform(post("/product/product").param("id", "1").param("description", description).param("price", "12.00")
		.param("imageUrl", "google.com")).andExpect(status().is3xxRedirection()).andExpect(view().name("redirect:/product/product/1"))
		.andExpect(model().attribute("product", instanceOf(Product.class)))
		.andExpect(model().attribute("product", hasProperty("id", is(id))))
		.andExpect(model().attribute("product", hasProperty("description", is(description))))
		.andExpect(model().attribute("product", hasProperty("price", is(price))))
		.andExpect(model().attribute("product", hasProperty("imageUrl",is(imageUrl))));
		
		//verify properties of bound object
		ArgumentCaptor<Product> boundProduct = ArgumentCaptor.forClass(Product.class);
		verify(productService).saveOrUpdate(boundProduct.capture());
		
		
		assertEquals(id, boundProduct.getValue().getId());
		assertEquals(description, boundProduct.getValue().getDescription());
		assertEquals(price, boundProduct.getValue().getPrice());
		assertEquals(imageUrl,boundProduct.getValue().getImageUrl());
		
	}
	
	@Test
	public void testDelete() throws Exception {
		Integer id=1;
		mockMvc.perform(get("/product/product/delete/1"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/product/products"));
		
		verify(productService, times(1)).delete(id);
	}

}
