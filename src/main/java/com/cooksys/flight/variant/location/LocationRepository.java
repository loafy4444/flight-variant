package com.cooksys.flight.variant.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.flight.variant.location.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

	Location findById(long id);
	
	Location findByCity(String cityName);
	
}
