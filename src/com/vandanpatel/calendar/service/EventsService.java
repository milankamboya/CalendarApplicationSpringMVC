package com.vandanpatel.calendar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.vandanpatel.calendar.dao.EventDAO;
import com.vandanpatel.calendar.model.Event;

@Service("eventsService")
public class EventsService {

	private EventDAO eventsDAO;

	@Autowired
	public void setEventsDAO(EventDAO eventsDAO) {
		this.eventsDAO = eventsDAO;
	}
	
	public List<Event> getCurrent(){
		return eventsDAO.getEvents();
	}
	
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	public boolean createEvent(Event event){
		return eventsDAO.create(event);
	}

	public List<Event> yourEvents(String username) {
		
		if(username == null){
			return null;
		}
		
		return eventsDAO.personalEvents(username);
	}

	public Event getEvent(int event_id) {
		
		return eventsDAO.getEvent(event_id);
	}

	public boolean updateYourEvent(Event event) {
		
		return eventsDAO.update(event);
	}

	public boolean deleteYourEvent(int sanitized_id) {
		return eventsDAO.delete(sanitized_id);
	}
	
}
