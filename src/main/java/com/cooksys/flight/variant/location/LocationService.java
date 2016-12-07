package com.cooksys.flight.variant.location;

import java.util.List;

import com.cooksys.flight.variant.location.entity.Location;

public interface LocationService {

	public List<Location> getAll();

	public Location get(long id);
	
	public Location get(String name);
}
