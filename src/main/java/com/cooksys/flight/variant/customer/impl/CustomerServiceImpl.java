package com.cooksys.flight.variant.customer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.flight.variant.customer.CustomerRepository;
import com.cooksys.flight.variant.customer.CustomerService;
import com.cooksys.flight.variant.customer.entity.Customer;
import com.cooksys.flight.variant.customer.entity.model.CustomerBase;
import com.cooksys.flight.variant.customer.entity.model.CustomerModel;
import com.cooksys.flight.variant.flight.FlightRepository;
import com.cooksys.flight.variant.flight.entity.DBFlight;
import com.cooksys.flight.variant.itinerary.ItineraryRepository;
import com.cooksys.flight.variant.itinerary.entity.model.ItineraryModel;

@Service	
public class CustomerServiceImpl implements CustomerService{
	
	private final CustomerRepository repo;
	private final FlightRepository flightRepo;
	private final ItineraryRepository itinRepo;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository repo, 
			FlightRepository flightRepo, ItineraryRepository itinRepo){
		this.repo = repo;
		this.flightRepo = flightRepo;
		this.itinRepo = itinRepo;
	}

	@Override
	public List<CustomerModel> index() {
		return CustomerModel.list(this.repo.findAll());
	}

	@Override
	public CustomerModel create(Customer customer) {
		Customer result = customer;
		this.repo.save(result);
		return CustomerModel.response(result);
	}

	@Override
	public CustomerModel readById(Long id) {
		return CustomerModel.response(this.repo.findById(id));
	}

	@Override
	public CustomerBase readByUsername(String username) {
		return CustomerBase.response(this.repo.findByUsername(username));
	}

	@Override
	public List<ItineraryModel> indexItineraries(Long id) {
		return ItineraryModel.list(this.repo.findById(id).getItineraries());
	}

	@Override
	public List<ItineraryModel> deleteItinerary(Long id, Long iid) {
		List<DBFlight> flights = this.flightRepo.findAll();
		for(DBFlight flight: flights){
			if(flight.getItinerary() == this.itinRepo.findById(iid)){
				this.flightRepo.delete(flight);
			}
		}
		this.repo.findById(id).getItineraries().remove(this.itinRepo.findById(iid));
		this.itinRepo.delete(iid);
		return ItineraryModel.list(this.repo.findById(id).getItineraries());
	}
}
