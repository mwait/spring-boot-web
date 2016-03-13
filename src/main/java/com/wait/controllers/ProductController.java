package com.wait.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wait.domain.Product;
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
	@RequestMapping("product/edit/{id}")
	public String editProduct(@PathVariable("id") Integer id, Model model){
		model.addAttribute("product", productService.getProductById(id));
		return "productform";
	}
	
	@RequestMapping("/product/new")
	public String addProduct(Model model){
		model.addAttribute("product", new Product());
		return "productform";
	}
	
	@RequestMapping(value = "/product", method=RequestMethod.POST)
	public String saveOrUpdateProduct(Product product){
		Product saveProduct = productService.saveOrUpdateProduct(product);
		return "redirect:/product/"+saveProduct.getId();
	}
	
	@RequestMapping(value="/product/delete/{id}")
	public String delete(@PathVariable("id") Integer id){
		productService.deleteProduct(id);
		return "redirect:/products";
	}
}
