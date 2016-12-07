package com.cooksys.flight.variant.flight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.flight.variant.flight.entity.DBFlight;

@Repository
public interface FlightRepository extends JpaRepository<DBFlight, Long>{

	DBFlight findById(Long id);
	
	DBFlight findByItinerary(Long id);
}
