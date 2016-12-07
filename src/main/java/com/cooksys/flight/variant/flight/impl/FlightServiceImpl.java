package com.cooksys.flight.variant.flight.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cooksys.flight.variant.component.FlightGenerator;
import com.cooksys.flight.variant.flight.FlightRepository;
import com.cooksys.flight.variant.flight.FlightService;
import com.cooksys.flight.variant.flight.entity.DBFlight;
import com.cooksys.flight.variant.flight.entity.Flight;
import com.cooksys.flight.variant.flight.entity.model.FlightModel;
import com.cooksys.flight.variant.itinerary.ItineraryRepository;

@Service
public class FlightServiceImpl implements FlightService {

	private final FlightGenerator generator;
	private final FlightRepository repo;
	private final ItineraryRepository itinRepo;
	
	@Autowired
	public FlightServiceImpl(FlightGenerator generator, FlightRepository repo,
			ItineraryRepository itinRepo){
		this.generator = generator;
		this.repo = repo;
		this.itinRepo = itinRepo;
	}

	private List<Flight> flightList = new ArrayList<>();
	
	public List<Flight> getDailyFlightList() {
		return flightList;
	}
	
	//The fixedDelay parameter determines how often a new day is generated as expressed in milliseconds
	@Scheduled(fixedDelay=25000)
	private void refreshFlights(){
		flightList = generator.generateNewFlightList();
	}

	@Override
	public List<FlightModel> index() {
		return FlightModel.list(this.repo.findAll());
	}

	@Override
	public FlightModel create(Long id, DBFlight flight) {
		DBFlight result = flight;
		result.setItinerary(this.itinRepo.findById(id));
		this.repo.save(result);
		return FlightModel.response(result);
	}

	@Override
	public FlightModel read(Long id) {
		return FlightModel.response(this.repo.findById(id));
	}

	@Override
	public FlightModel delete(Long id) {
		DBFlight flight = this.repo.findById(id);
		this.repo.delete(id);
		return FlightModel.response(flight);
	}	
}
