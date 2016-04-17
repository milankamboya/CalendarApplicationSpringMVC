package com.vandanpatel.calendar.model;

public class Account {

	private int id;
	private String name;
	private String password;
	private String email;

	public Account() {

	}

	public Account(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public Account(int id, String name, String password, String email) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + "]";
	}

}
