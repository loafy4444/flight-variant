package com.cooksys.flight.variant.flight.entity.model;

import java.util.ArrayList;
import java.util.List;

import com.cooksys.flight.variant.flight.entity.DBFlight;
import com.cooksys.flight.variant.itinerary.entity.Itinerary;

public class FlightModel {

	private Long itinerary;
	private Long id;
	private String origin;
	private String destination;
	private long flightTakeOff;
	private long flightTime;
	
	public FlightModel(DBFlight flight){
		this.itinerary = flight.getItinerary().getId();
		this.id = flight.getId();
		this.origin = flight.getOrigin();
		this.destination = flight.getDestination();
		this.flightTakeOff = flight.getOffset();
		this.flightTime = flight.getFlightTime();
	}
	
	public static FlightModel response(DBFlight flight){
		return new FlightModel(flight);
	}
	
	public static List<FlightModel> list(List<DBFlight> flights){
		List<FlightModel> results = new ArrayList<>();
		for(DBFlight flight: flights){
			results.add(new FlightModel(flight));
		}
		return results;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public long getTakeOff() {
		return flightTakeOff;
	}

	public void setTakeOff(long flightTakeOff) {
		this.flightTakeOff = flightTakeOff;
	}

	public long getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(long flightTime) {
		this.flightTime = flightTime;
	}

	public Long getItinerary() {
		return itinerary;
	}

	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary.getId();
	}
	
}
