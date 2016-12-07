package com.cooksys.flight.variant.itinerary;

import java.util.List;

import com.cooksys.flight.variant.itinerary.entity.model.ItineraryBase;
import com.cooksys.flight.variant.itinerary.entity.model.ItineraryModel;

public interface ItineraryService {

	List<ItineraryModel> index();

	ItineraryBase create(Long id);

	ItineraryModel read(Long id);

	List<ItineraryModel> indexByCustomer(Long id);

	ItineraryModel delete(Long id);

}
