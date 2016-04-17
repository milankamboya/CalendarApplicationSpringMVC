package com.vandanpatel.calendar.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.vandanpatel.calendar.model.Account;
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
}
