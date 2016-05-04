package com.vandanpatel.calendar.model;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Event {

	private int event_id;

	@NotNull
	@Size(min = 4, max = 20)
	private String event_name;

	@NotNull
	@Size(min = 4, max = 50)
	private String street;

	@NotNull
	@Size(min = 2, max = 20)
	private String city;

	@NotNull
	@Size(min = 2, max = 20)
	private String state;
	
	@NotNull
	@Size(min = 5, max = 10)
	private String zipcode;

	@NotNull
	@Future
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date date;
	
	private User user;

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

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
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
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUsername(){
		return user.getUsername();
	}
	



	public Event(User user ,String event_name, String street, String city, String state, String zipcode, Date date) {
		this.user = user;
		this.event_name = event_name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.date = date;
	}

	public Event(int event_id, User user, String event_name, String street, String city, String state, String zipcode, Date date) {
		this.event_id = event_id;
		this.user = user;
		this.event_name = event_name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Event [event_id=" + event_id + ", event_name=" + event_name + ", street=" + street + ", city=" + city
				+ ", state=" + state + ", zipcode=" + zipcode + ", date=" + date + ", user=" + user + "]";
	}

	public Event() {
		this.user = new User();
	}
}
