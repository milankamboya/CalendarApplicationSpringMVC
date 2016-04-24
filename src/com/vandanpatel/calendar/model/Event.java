package com.vandanpatel.calendar.model;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Event {

	private int event_id;

	@NotNull
	@Size(min = 4, max = 20, message = "Name must be between 4 and 20 characters")
	private String name;

	@NotNull
	@Size(min = 4, max = 50, message = "Street must be between 4 and 50 characters")
	private String street;

	@NotNull
	@Size(min = 2, max = 20, message = "City must be between 2 and 20 characters")
	private String city;

	@NotNull
	@Size(min = 2, max = 20, message = "State must be between 2 and 20 characters")
	private String state;
	
	@NotNull
	@Size(min = 5, max = 10, message = "Zip Code must be between 5 and 10 characters")
	private String zipcode;

	@NotNull(message = "Date can not be empty")
	@Future(message = "Date must be in future")
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm aa")
	private Date date;

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Event(String name, String street, String city, String state, String zipcode, Date date) {
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.date = date;
	}

	public Event(int event_id, String name, String street, String city, String state, String zipcode, Date date) {
		this.event_id = event_id;
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.date = date;
	}

	public Event() {

	}
}
