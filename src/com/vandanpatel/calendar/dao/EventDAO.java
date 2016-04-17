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

@Component("eventDAO")
public class EventDAO {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	
	public List<Event> getEvents() {
		
		return jdbc.query("select * from events", new RowMapper<Event>(){

			@Override
			public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
				Event event = new Event();
				
				event.setId(rs.getInt("id"));
				event.setName(rs.getString("name"));
				event.setStreet(rs.getString("street"));
				event.setCity(rs.getString("city"));
				event.setState(rs.getString("state"));
				event.setTime(rs.getDate("time").toLocalDate());
				return event;
			}
			
		});
	}
	
	public Event getEvent(int id){
		MapSqlParameterSource params = new MapSqlParameterSource("id",id);
		
		return jdbc.queryForObject("select * from events where id=:id", params, new RowMapper<Event>() {

			@Override
			public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
				Event event = new Event();
				
				event.setId(rs.getInt("id"));
				event.setName(rs.getString("name"));
				event.setStreet(rs.getString("street"));
				event.setCity(rs.getString("city"));
				event.setState(rs.getString("state"));
				event.setTime(rs.getDate("time").toLocalDate());
				return event;
			}
		});
	}
	
	public boolean delete(int id){
		
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		
		return jdbc.update("delete from events where id=:id", params) == 1;
		
	}
	
	public boolean create(Event event){
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(event);
		
		return jdbc.update("insert into events (name, street, city, state, time) values (:name, :street, :city, :state, :time)", params) == 1;
	}
	
	public boolean update(Event event){
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(event);
		
		return jdbc.update("update events set name=:name, street=:street, city=:city, state=:state, time=:time where id=:id", params) == 1;
	}
	
	public int[] create(List<Event> events){
		
		SqlParameterSource[] params =  SqlParameterSourceUtils.createBatch(events.toArray());
		
		return jdbc.batchUpdate("insert into events (name, street, city, state, time) values (:name, :street, :city, :state, :time)", params);
	}
	
}
