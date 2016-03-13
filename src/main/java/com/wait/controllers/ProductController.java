package com.wait.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wait.services.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/products")
	public String listProducts(Model model) {
		model.addAttribute("products", productService.listAllProducts());
		return "products";
	}
	
	
	@RequestMapping("/product/{id}")
	public String getProduct(@PathVariable("id") Integer id, Model model){
		model.addAttribute("product", productService.getProductById(id));
		return "product";	
	}
}
