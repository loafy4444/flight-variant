package com.cooksys.flight.variant.customer.entity.model;

import java.util.ArrayList;
import java.util.List;

import com.cooksys.flight.variant.customer.entity.Customer;

public class CustomerBase {

	private Long id;
	private String username;
	private String password;
	
	public CustomerBase(Customer customer){
		this.id = customer.getId();
		this.username = customer.getUsername();
		this.password = customer.getPassword();
	}
	
	public static CustomerBase response(Customer customer){
		return new CustomerBase(customer);
	}
	
	public static List<CustomerBase> list(List<Customer> customers){
		List<CustomerBase> results = new ArrayList<>();
		for(Customer customer: customers){
			results.add(new CustomerBase(customer));
		}
		return results;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
}
