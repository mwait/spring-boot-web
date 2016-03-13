package com.wait.services;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wait.domain.DomainObject;
import com.wait.domain.Product;

@Service
public class ProductServiceImpl extends AbstractMapService implements ProductService{

	@Override
	public List<DomainObject> listAll() {
		return super.listAll();
	}

	@Override
	public Product getById(Integer id) {
		return (Product) super.getById(id);
	}
	
	@Override
	public void delete (Integer id) { super.delete(id); }

	@Override
	public Product saveOrUpdate(Product domainObject) {
	return (Product) super.saveOrUpdate(domainObject);
	}
	
	protected void loadDomainObjects(){
		domainMap = new HashMap<>();
		
		Product product1 = new Product();
		product1.setId(1);
		product1.setDescription("Product 1");
		product1.setImageUrl("http://onet.pl/obraz1");
		product1.setPrice(new BigDecimal("10.00"));
		domainMap.put(1, product1);
		
		Product product2 = new Product();
		product2.setId(2);
		product2.setDescription("Product 2");
		product2.setImageUrl("http://onet.pl/obraz2");
		product2.setPrice(new BigDecimal("11.00"));
		domainMap.put(2, product2);
		
		Product product3 = new Product();
		product3.setId(3);
		product3.setDescription("Product 3");
		product3.setImageUrl("http://onet.pl/obraz3");
		product3.setPrice(new BigDecimal("12.00"));
		domainMap.put(3, product3);
		
		Product product4 = new Product();
		product4.setId(4);
		product4.setDescription("Product 4");
		product4.setImageUrl("http://onet.pl/obraz4");
		product4.setPrice(new BigDecimal("13.00"));
		domainMap.put(4, product4);
		
	}

	
}
