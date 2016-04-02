package com.wait.services.mapservices;

import java.util.List;

import com.wait.domain.DomainObject;
import com.wait.domain.User;
import com.wait.services.UserService;

public class UserServiceMapImpl extends AbstractMapService implements UserService {

	public List<DomainObject> listAll() {
		return super.listAll();
	}
	
	public User getById(Integer id) {
		return (User) super.getById(id);
	}
	
	public User saveOrUpdate(User domainObject) {
		return (User) super.saveOrUpdate(domainObject);
	}
	
	public void delete(Integer id) {
		super.delete(id);
	}
}
