package com.cooksys.flight.variant.flight;

import java.util.List;

import com.cooksys.flight.variant.flight.entity.DBFlight;
import com.cooksys.flight.variant.flight.entity.Flight;
import com.cooksys.flight.variant.flight.entity.model.FlightModel;

public interface FlightService {

	List<Flight> getDailyFlightList();

	List<FlightModel> index();

	FlightModel create(Long id, DBFlight flight);

	FlightModel read(Long id);

	FlightModel delete(Long id);

}
