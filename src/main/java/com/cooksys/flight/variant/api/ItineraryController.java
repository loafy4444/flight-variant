package com.cooksys.flight.variant.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.flight.variant.itinerary.ItineraryService;
import com.cooksys.flight.variant.itinerary.entity.model.ItineraryBase;
import com.cooksys.flight.variant.itinerary.entity.model.ItineraryModel;

@RestController
@RequestMapping("itinerary")
@CrossOrigin
public class ItineraryController {

	private final ItineraryService service;
	
	@Autowired
	public ItineraryController(ItineraryService service){
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ItineraryModel> index(){
		return this.service.index();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ItineraryBase create(@PathVariable Long id){
		return this.service.create(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ItineraryModel read(@PathVariable Long id){
		return this.service.read(id);
	}
	
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	public List<ItineraryModel> indexByCustomer(@PathVariable Long id){
		return this.service.indexByCustomer(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ItineraryModel delete(@PathVariable Long id){
		return this.service.delete(id);
	}
}
