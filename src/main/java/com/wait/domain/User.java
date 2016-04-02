package com.wait.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.action.internal.OrphanRemovalAction;

@Entity
public class User implements DomainObject{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Version
	private Integer version;
	
	private String username;
	
	@Transient  //no persist to database
	private String password;
	
	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})  //usuniecie usera nie bedzie skutkowalo usunieciem Customera
	private Customer customer;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Cart cart;
	
	private String encryptedPassword;
	private Boolean enabled = true;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
		customer.setUser(this);   //kaźdy obiekt ma referencje do drugiego - bidirectional
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	

}
