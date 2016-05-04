package com.vandanpatel.calendar.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.vandanpatel.calendar.model.Event;
import com.vandanpatel.calendar.model.User;

@Component("userDAO")
public class UserDAO {

	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	@Transactional
	public boolean create(User user){
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		params.addValue("username", user.getUsername());
		params.addValue("password", passwordEncoder.encode(user.getPassword()));
		params.addValue("email", user.getEmail());
		params.addValue("enabled", user.isEnabled());
		params.addValue("authority", user.getAuthority());
		params.addValue("name", user.getName());
		
		return jdbc.update("insert into users (username, password, email, enabled, authority, name) values (:username, :password, :email, :enabled, :authority, :name)", params) == 1;
		
	}

	public boolean exists(String username) {
		
		return jdbc.queryForObject("select count(*) from users where username=:username", new MapSqlParameterSource("username",username), Integer.class) > 0;
	}

	public List<User> getAllUsers() {
		
		return jdbc.query("select * from users",  BeanPropertyRowMapper.newInstance(User.class));
	}
	
	public User getUser(int user_id) {
		
		MapSqlParameterSource params = new MapSqlParameterSource("user_id", user_id);
		
		return jdbc.queryForObject("select * from users where user_id=:user_id", params, BeanPropertyRowMapper.newInstance(User.class));
	}
	
	public boolean update(User user){
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		
		return jdbc.update("update users set username=:username, email=:email, name=:name where user_id=:user_id", params) == 1;
	}
	
	public boolean delete(int user_id){
		
		MapSqlParameterSource params = new MapSqlParameterSource("user_id", user_id);
		
		return jdbc.update("delete from users where user_id=:user_id", params) == 1;
		
	}
}
