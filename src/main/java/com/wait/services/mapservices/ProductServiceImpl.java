package com.wait.services.mapservices;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.wait.domain.DomainObject;
import com.wait.domain.Product;
import com.wait.services.ProductService;

@Service
@Profile("map")
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
	
	
}
