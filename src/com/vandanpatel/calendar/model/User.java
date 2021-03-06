package com.vandanpatel.calendar.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class User {


	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", enabled=" + enabled + ", authority=" + authority
				+ "]";
	}

	@NotBlank
	@Size(min = 8, max = 15)
	@Pattern(regexp = "^\\w{8,}$")
	private String username;

	@NotBlank
	@Pattern(regexp = "^\\S+$")
	@Size(min = 8, max = 15)
	private String password;

	@NotBlank
	@Email
	private String email;
	private boolean enabled = false;
	
	@NotBlank
	@Size(min = 2, max = 50)
	@Pattern(regexp = "^[a-zA-Z\\s]+$")
	private String name;
	private int user_id;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String authority;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(String username, String password, String email, boolean enabled, String authority, String name) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.authority = authority;
		this.name = name;
	}
	
	public User(int user_id, String username, String password, String email, boolean enabled, String name,
			String authority) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.name = name;
		this.user_id = user_id;
		this.authority = authority;
	}



	public User() {

	}
}
