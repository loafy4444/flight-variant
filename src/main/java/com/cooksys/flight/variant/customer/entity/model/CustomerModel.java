package com.cooksys.flight.variant.customer.entity.model;


import java.util.ArrayList;
import java.util.List;

import com.cooksys.flight.variant.customer.entity.Customer;
import com.cooksys.flight.variant.itinerary.entity.Itinerary;
import com.cooksys.flight.variant.itinerary.entity.model.ItineraryModel;


public class CustomerModel {
	
	private Long id;
	private String username;
	private String email;
	private List<ItineraryModel> itineraries;
	
	public CustomerModel(Customer customer){
		this.id = customer.getId();
		this.username = customer.getUsername();
		this.email = customer.getEmail();
		this.itineraries = ItineraryModel.list(customer.getItineraries());
	}
	
	public static CustomerModel response(Customer customer){
		return new CustomerModel(customer);
	}
	
	public static List<CustomerModel> list(List<Customer> customers){
		List<CustomerModel> results = new ArrayList<>();
		for(Customer customer: customers){
			results.add(new CustomerModel(customer));
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ItineraryModel> getItineraries() {
		return itineraries;
	}

	public void setItineraries(List<Itinerary> itineraries) {
		this.itineraries = ItineraryModel.list(itineraries);
	}
}
