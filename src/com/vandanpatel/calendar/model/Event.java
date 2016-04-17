package com.vandanpatel.calendar.model;

import java.time.LocalDate;

public class Event {
	
	private int id;
	private String name;
	private String street;
	private String city;
	private String state;
	private LocalDate time;
	
	public Event(){
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public LocalDate getTime() {
		return time;
	}

	public void setTime(LocalDate time) {
		this.time = time;
	}

	public Event(String name, String street, String city, String state, LocalDate time) {
		super();
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.time = time;
	}

	public Event(int id, String name, String street, String city, String state, LocalDate time) {
		super();
		this.id = id;
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.time = time;
	}
}
