package com.cooksys.flight.variant.itinerary.entity.model;

import java.util.ArrayList;
import java.util.List;

import com.cooksys.flight.variant.flight.entity.DBFlight;
import com.cooksys.flight.variant.flight.entity.model.FlightModel;
import com.cooksys.flight.variant.itinerary.entity.Itinerary;

public class ItineraryModel {
	
	private Long id;
	private Long custId;
	private String custName;
	
	private String origin;
	private String destination;
	private long takeOff;
	private long totalFlightTime;
	private long arrivalTime;
	private long totalLayover;
	
	private List<FlightModel> flights;
	
	public ItineraryModel(Itinerary itinerary){
		this.id = itinerary.getId();
		this.custId = itinerary.getCustomer().getId();
		this.custName = itinerary.getCustomer().getUsername();
		this.flights = FlightModel.list(itinerary.getFlights());
		
		getFlightInfo(itinerary);
	}
	
	public static ItineraryModel response(Itinerary itinerary){
		return new ItineraryModel(itinerary);
	}
	
	public static List<ItineraryModel> list(List<Itinerary> itineraries){
		List<ItineraryModel> results = new ArrayList<>();
		for(Itinerary itinerary: itineraries){
			results.add(new ItineraryModel(itinerary));
		}
		return results;
	}
	
	public void getFlightInfo(Itinerary itinerary){
		DBFlight origin = new DBFlight();
		DBFlight dest = new DBFlight();
		long originFlightTime = 99;
		long destFlightTime = 0;
		long flightTime = 0;
		for(DBFlight flight: itinerary.getFlights()){
			if(flight.getFlightTime() < originFlightTime){
				originFlightTime = flight.getOffset();
				origin = flight;
			}
			if (flight.getFlightTime() > destFlightTime){
				destFlightTime = flight.getOffset();
				dest = flight;
			}
			flightTime += flight.getFlightTime();
		}
		
		this.origin = origin.getOrigin();
		this.takeOff = origin.getOffset();
		
		this.totalFlightTime = flightTime;
		
		
		this.destination = dest.getDestination();
		this.arrivalTime = dest.getFlightTime() + dest.getOffset();
		
		this.totalLayover = this.arrivalTime - this.takeOff - this.totalFlightTime;
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

	public List<FlightModel> getFlights() {
		return flights;
	}

	public void setFlights(List<DBFlight> flights) {
		this.flights = FlightModel.list(flights);
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
		return takeOff;
	}

	public void setTakeOff(long takeOff) {
		this.takeOff = takeOff;
	}

	public long getLayover() {
		return totalLayover;
	}

	public void setLayover(long totalLayover) {
		this.totalLayover = totalLayover;
	}

	public long getTotalFlightTime() {
		return totalFlightTime;
	}

	public void setTotalFlightTime(long totalFlightTime) {
		this.totalFlightTime = totalFlightTime;
	}

	public long getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(long arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

}
