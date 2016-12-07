package com.cooksys.flight.variant.itinerary.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.flight.variant.customer.CustomerRepository;
import com.cooksys.flight.variant.itinerary.ItineraryRepository;
import com.cooksys.flight.variant.itinerary.ItineraryService;
import com.cooksys.flight.variant.itinerary.entity.Itinerary;
import com.cooksys.flight.variant.itinerary.entity.model.ItineraryBase;
import com.cooksys.flight.variant.itinerary.entity.model.ItineraryModel;

@Service
public class ItineraryServiceImpl implements ItineraryService{

	private final ItineraryRepository repo;
	private final CustomerRepository custRepo;
	@Autowired
	public ItineraryServiceImpl(ItineraryRepository repo, CustomerRepository custRepo){
		this.repo = repo;
		this.custRepo = custRepo;
	}

	@Override
	public List<ItineraryModel> index() {
		return ItineraryModel.list(this.repo.findAll());
	}

	@Override
	public ItineraryBase create(Long id) {
		Itinerary itinerary = new Itinerary();
		itinerary.setCustomer(this.custRepo.findById(id));
		this.repo.save(itinerary);
		return ItineraryBase.response(itinerary);
	}

	@Override
	public ItineraryModel read(Long id) {
		return ItineraryModel.response(this.repo.findById(id));
	}

	@Override
	public List<ItineraryModel> indexByCustomer(Long id) {
		return ItineraryModel.list(this.repo.findByCustomerId(id));
	}

	@Override
	public ItineraryModel delete(Long id) {
		Itinerary itinerary = this.repo.findById(id);
		this.repo.delete(id);
		return ItineraryModel.response(itinerary);
	}
}
