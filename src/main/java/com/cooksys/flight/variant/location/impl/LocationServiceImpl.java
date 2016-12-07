package com.cooksys.flight.variant.location.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.flight.variant.location.LocationRepository;
import com.cooksys.flight.variant.location.LocationService;
import com.cooksys.flight.variant.location.entity.Location;

@Service
public class LocationServiceImpl implements LocationService{

	private final LocationRepository repo;
	
	@Autowired
	public LocationServiceImpl(LocationRepository repo){
		this.repo = repo;
	}
	
	public List<Location> getAll(){
		return repo.findAll();
	}

	public Location get(long id){
		return repo.findById(id);
	}
	
	public Location get(String name){
		return repo.findByCity(name);
	}
}
