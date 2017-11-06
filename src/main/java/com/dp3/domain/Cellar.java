package com.dp3.domain;

public class Cellar {
	
	private String name;
	private String location;
	private String description;
	
	public Cellar(String name, String location, String description) {
		this.name = name;
		this.location = location;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public String getDescription() {
		return description;
	}
	
	

}
