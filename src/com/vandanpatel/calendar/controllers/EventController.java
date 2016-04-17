package com.vandanpatel.calendar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vandanpatel.calendar.model.Event;
import com.vandanpatel.calendar.service.EventsService;

@Controller
public class EventController {

	private EventsService eventsService;
	
	@Autowired
	public void setEventsService(EventsService eventsService) {
		this.eventsService = eventsService;
	}



	@RequestMapping("/events")
	public String showEvents(Model model)
	{
		List<Event> events = eventsService.getCurrent();
		
		model.addAttribute("events", events);
		
		return "events";
	}
}
