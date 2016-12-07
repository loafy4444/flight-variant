package com.cooksys.flight.variant.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.flight.variant.flight.FlightService;
import com.cooksys.flight.variant.flight.entity.DBFlight;
import com.cooksys.flight.variant.flight.entity.Flight;
import com.cooksys.flight.variant.flight.entity.model.FlightModel;

@RestController
@RequestMapping("flight")
@CrossOrigin
public class FlightController {
	
	private final FlightService service;
	
	@Autowired
	public FlightController(FlightService service){
		this.service = service;
	}
	
	@RequestMapping(value = "/gen")
	public List<Flight> getFlightList(){
		return service.getDailyFlightList();
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<FlightModel> index(){
		return this.service.index();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public FlightModel create(@PathVariable Long id, @RequestBody DBFlight flight){
		return this.service.create(id, flight);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public FlightModel read(@PathVariable Long id){
		return this.service.read(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public FlightModel delete(@PathVariable Long id){
		return this.service.delete(id);
	}
}
