package com.wait.services.jpaservices;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.wait.domain.Customer;
import com.wait.services.CustomerService;

@Service
@Profile("jpadao")
public class CustomerServiceJpaDaoImpl extends AbstractJpaDaoService implements CustomerService{


	@Override
	public List<?> listAll() {
		EntityManager em = emf.createEntityManager();
		List<Customer> customers = em.createQuery("from Customer", Customer.class).getResultList();
		return customers;
	}

	@Override
	public Customer getById(Integer id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Customer.class, id);
	}

	@Override
	public Customer saveOrUpdate(Customer domainObject) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Customer customer = em.merge(domainObject);
		em.getTransaction().commit();
		return customer;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Customer.class, id));
		em.getTransaction().commit();
		
	}
	
}
