package com.wait.services;

import java.util.List;

import com.wait.domain.Product;

public interface ProductService {

	List<Product> listAllProducts();

	Product getProductById(Integer id);
	Product saveOrUpdateProduct(Product product);
}
