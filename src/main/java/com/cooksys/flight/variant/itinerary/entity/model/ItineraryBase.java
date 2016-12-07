package com.cooksys.flight.variant.itinerary.entity.model;

import java.util.ArrayList;
import java.util.List;

import com.cooksys.flight.variant.itinerary.entity.Itinerary;

public class ItineraryBase {

	private Long id;
	private Long custId;
	private String custName;
	
	private ItineraryBase(Itinerary itinerary){
		this.id = itinerary.getId();
		this.custId = itinerary.getCustomer().getId();
		this.custName = itinerary.getCustomer().getUsername();
	}
	
	public static ItineraryBase response(Itinerary itinerary){
		return new ItineraryBase(itinerary);
	}
	
	public static List<ItineraryBase> list(List<Itinerary> itineraries){
		List<ItineraryBase> results = new ArrayList<>();
		for(Itinerary itinerary: itineraries){
			results.add(new ItineraryBase(itinerary));
		}
		return results;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}
}
