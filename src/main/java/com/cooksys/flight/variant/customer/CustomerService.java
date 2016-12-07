package com.cooksys.flight.variant.customer;

import java.util.List;

import com.cooksys.flight.variant.customer.entity.Customer;
import com.cooksys.flight.variant.customer.entity.model.CustomerBase;
import com.cooksys.flight.variant.customer.entity.model.CustomerModel;
import com.cooksys.flight.variant.itinerary.entity.model.ItineraryModel;

public interface CustomerService {

	List<CustomerModel> index();

	CustomerModel create(Customer customer);

	CustomerModel readById(Long id);

	CustomerBase readByUsername(String username);

	List<ItineraryModel> indexItineraries(Long id);

	List<ItineraryModel> deleteItinerary(Long id, Long iid);

}
