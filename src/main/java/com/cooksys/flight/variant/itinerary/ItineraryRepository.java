package com.cooksys.flight.variant.itinerary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.flight.variant.itinerary.entity.Itinerary;

@Repository
public interface ItineraryRepository extends JpaRepository<Itinerary, Long>{

	Itinerary findById(Long id);
	
	List<Itinerary> findByCustomerId(Long id);
}
