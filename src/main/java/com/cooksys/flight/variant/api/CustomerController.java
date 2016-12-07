package com.cooksys.flight.variant.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.flight.variant.customer.CustomerService;
import com.cooksys.flight.variant.customer.entity.Customer;
import com.cooksys.flight.variant.customer.entity.model.CustomerBase;
import com.cooksys.flight.variant.customer.entity.model.CustomerModel;
import com.cooksys.flight.variant.itinerary.entity.model.ItineraryModel;

@RestController
@RequestMapping("customer")
@CrossOrigin
public class CustomerController {

	private final CustomerService service;
	
	@Autowired
	public CustomerController(CustomerService service){
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<CustomerModel> index(){
		return this.service.index();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public CustomerModel create(@RequestBody Customer customer){
		return this.service.create(customer);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public CustomerModel read(@PathVariable Long id){
		return this.service.readById(id);
	}
	
	@RequestMapping(value = "/username", method = RequestMethod.GET)
	public CustomerBase read(@RequestParam("username") String username){
		return this.service.readByUsername(username);
	}
	
	@RequestMapping(value = "/{id}/itineraries", method = RequestMethod.GET)
	public List<ItineraryModel> indexItineraries(@PathVariable Long id){
		return this.service.indexItineraries(id);
	}
	
	@RequestMapping(value = "/{id}/itinerary/{iid}", method = RequestMethod.DELETE)
	public List<ItineraryModel> deleteItinerary(@PathVariable Long id, @PathVariable Long iid){
		return this.service.deleteItinerary(id, iid);
	}
}
