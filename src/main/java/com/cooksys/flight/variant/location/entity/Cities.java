package com.cooksys.flight.variant.location.entity;

public enum Cities {
	
	MEMPHIS("Memphis"), KNOXVILLE("Knoxville"), CHATTANOOGA("Chattanooga"), NASHVILLE("Nashville");
	
	private String name;
	
	private Cities(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
}
