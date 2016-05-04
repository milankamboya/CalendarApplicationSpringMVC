package com.vandanpatel.calendar.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;

import com.vandanpatel.calendar.model.Event;
import com.vandanpatel.calendar.model.User;

@Component("eventDAO")
public class EventDAO {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	
	public List<Event> getEvents() {
		
		return jdbc.query("select * from events, users where events.username = users.username and users.enabled = true", new RowMapper<Event>(){

			@Override
			public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				User user = new User();
				user.setAuthority(rs.getString("authority"));
				user.setEmail(rs.getString("email"));
				user.setEnabled(true);
				user.setUsername(rs.getString("username"));
				user.setName(rs.getString("name"));
				
				Event event = new Event();
				
				event.setEvent_id(rs.getInt("event_id"));
				event.setEvent_name(rs.getString("event_name"));
				event.setStreet(rs.getString("street"));
				event.setCity(rs.getString("city"));
				event.setState(rs.getString("state"));
				event.setZipcode(rs.getString("zipcode"));
				event.setDate(rs.getDate("date"));
				event.setUser(user); 
				return event;
			}
			
		});
	}
	
	public Event getEvent(int event_id){
		MapSqlParameterSource params = new MapSqlParameterSource("event_id",event_id);
		
		return jdbc.queryForObject("select * from events, users where events.username = users.username and users.enabled = true and events.event_id=:event_id", params, new RowMapper<Event>() {

			@Override
			public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				User user = new User();
				user.setAuthority(rs.getString("authority"));
				user.setEmail(rs.getString("email"));
				user.setEnabled(true);
				user.setUsername(rs.getString("username"));
				user.setName(rs.getString("name"));
				
				Event event = new Event();
				
				event.setEvent_id(rs.getInt("event_id"));
				event.setEvent_name(rs.getString("event_name"));
				event.setStreet(rs.getString("street"));
				event.setCity(rs.getString("city"));
				event.setState(rs.getString("state"));
				event.setZipcode(rs.getString("zipcode"));
				event.setDate(rs.getDate("date"));
				event.setUser(user); 
				return event;
			}
		});
	}
	
	public boolean delete(int event_id){
		
		MapSqlParameterSource params = new MapSqlParameterSource("event_id", event_id);
		
		return jdbc.update("delete from events where event_id=:event_id", params) == 1;
		
	}
	
	public boolean create(Event event){
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(event);
		
		return jdbc.update("insert into events (event_name, street, city, state, zipcode, date, username) values (:event_name, :street, :city, :state, :zipcode, :date, :username)", params) == 1;
	}
	
	public boolean update(Event event){
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(event);
		
		return jdbc.update("update events set event_name=:event_name, street=:street, city=:city, state=:state, zipcode=:zipcode, date=:date where event_id=:event_id", params) == 1;
	}
	
	
	public int[] create(List<Event> events){
		
		SqlParameterSource[] params =  SqlParameterSourceUtils.createBatch(events.toArray());
		
		return jdbc.batchUpdate("insert into events (event_name, street, city, state, zipcode, date, username) values (:event_name, :street, :city, :state, :zipcode, :date, :username)", params);
	}


	public List<Event> personalEvents(String username) {
		
		MapSqlParameterSource params = new MapSqlParameterSource("username", username);

		return jdbc.query("select * from events, users where events.username = users.username and users.enabled = true and events.username=:username", params, new RowMapper<Event>(){

			@Override
			public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				User user = new User();
				user.setAuthority(rs.getString("authority"));
				user.setEmail(rs.getString("email"));
				user.setEnabled(true);
				user.setUsername(rs.getString("username"));
				user.setName(rs.getString("name"));
				
				Event event = new Event();
				
				event.setEvent_id(rs.getInt("event_id"));
				event.setEvent_name(rs.getString("event_name"));
				event.setStreet(rs.getString("street"));
				event.setCity(rs.getString("city"));
				event.setState(rs.getString("state"));
				event.setZipcode(rs.getString("zipcode"));
				event.setDate(rs.getDate("date"));
				event.setUser(user); 
				return event;
			}
			
		});
	}
	
}
