package com.wait.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wait.domain.Product;
import com.wait.services.ProductService;

@RequestMapping("/product")
@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/products")
	public String listProducts(Model model) {
		model.addAttribute("products", productService.listAll());
		return "product/products";
	}
	
	
	@RequestMapping("/product/{id}")
	public String getProduct(@PathVariable("id") Integer id, Model model){
		model.addAttribute("product", productService.getById(id));
		return "product/product";	
	}
	@RequestMapping("product/edit/{id}")
	public String editProduct(@PathVariable("id") Integer id, Model model){
		model.addAttribute("product", productService.getById(id));
		return "product/productform";
	}
	
	@RequestMapping("/product/new")
	public String addProduct(Model model){
		model.addAttribute("product", new Product());
		return "product/productform";
	}
	
	@RequestMapping(value = "/product", method=RequestMethod.POST)
	public String saveOrUpdateProduct(Product product){
		Product saveProduct = productService.saveOrUpdate(product);
		return "redirect:/product/product/"+saveProduct.getId();
	}
	
	@RequestMapping(value="/product/delete/{id}")
	public String delete(@PathVariable("id") Integer id){
		productService.delete(id);
		return "redirect:/product/products";
	}
}
