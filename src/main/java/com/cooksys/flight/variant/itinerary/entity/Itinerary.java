package com.cooksys.flight.variant.itinerary.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cooksys.flight.variant.customer.entity.Customer;
import com.cooksys.flight.variant.flight.entity.DBFlight;

@Entity
@Table
public class Itinerary {

	@Id
    @SequenceGenerator(name="itinerary_id_seq", sequenceName="itinerary_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="itinerary_id_seq")
	private Long id;
	
	@ManyToOne(optional=false)
	@JoinColumn
	private Customer customer;
	
	@OneToMany(mappedBy = "itinerary", cascade = CascadeType.ALL)
	private List<DBFlight> flights;

	public Itinerary () {
		
	}
	
	public Itinerary (Customer customer, List<DBFlight> flights) {
		super();
		this.customer = customer;
		this.flights = flights;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<DBFlight> getFlights() {
		return flights;
	}

	public void setFlights(List<DBFlight> flights) {
		this.flights = flights;
	}
}
