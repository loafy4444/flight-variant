package com.cooksys.flight.variant.component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

import com.cooksys.flight.variant.flight.entity.Flight;
import com.cooksys.flight.variant.location.entity.Cities;

@Component
public class FlightGenerator {

	public List<Flight> generateNewFlightList() {
		
		List<Flight> result = new ArrayList<>();

		for (int i = 0; i < 25; i++) {

			int originIndex = ThreadLocalRandom.current().nextInt(0, 4);

			int destinationIndex = ThreadLocalRandom.current().nextInt(0, 4);

			while (destinationIndex == originIndex)
				destinationIndex = ThreadLocalRandom.current().nextInt(0, 4);

			String origin = Cities.values()[originIndex].getName();
			String destination = Cities.values()[destinationIndex].getName();
			int flightTime = ThreadLocalRandom.current().nextInt(1, 4);
			int offset = ThreadLocalRandom.current().nextInt(0, 10);

			Flight f = new Flight(origin, destination, flightTime, offset);

			result.add(f);
		}
		return result;
	}

}
