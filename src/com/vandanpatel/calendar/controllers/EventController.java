package com.vandanpatel.calendar.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.vandanpatel.calendar.model.Event;
import com.vandanpatel.calendar.service.EventsService;

@Controller
public class EventController {

	private EventsService eventsService;
	


	@Autowired
	public void setEventsService(EventsService eventsService) {
		this.eventsService = eventsService;
	}



	@RequestMapping(value = {"/","/events"})
	public String showEvents(Model model)
	{
		List<Event> events = eventsService.getCurrent();
		
		model.addAttribute("events", events);
		
		return "events";
	}
	
	@RequestMapping("/createEvent")
	public String createEvent(Model model){
		
		model.addAttribute("event", new Event());
		
		return "createEvent";
	}
	
	@RequestMapping(value = "/docreate", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid Event event, BindingResult result){
		
		if(result.hasErrors()){
			
			return "createEvent";
		}
		
		eventsService.createEvent(event);
		return "eventCreated";
	}

}
