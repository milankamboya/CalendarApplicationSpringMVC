package com.vandanpatel.calendar.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vandanpatel.calendar.model.Event;
import com.vandanpatel.calendar.service.EventsService;

@Controller
public class EventController {

	private EventsService eventsService;

	@Autowired
	public void setEventsService(EventsService eventsService) {
		this.eventsService = eventsService;
	}

	@RequestMapping(value = { "/", "/events" })
	public String showEvents(Model model) {
		List<Event> events = eventsService.getCurrent();

		model.addAttribute("events", events);

		return "events";
	}

	@RequestMapping("/createEvent")
	public String createEvent(Model model) {

		model.addAttribute("event", new Event());

		return "createEvent";
	}

	@RequestMapping("/yourevents")
	public String showYourEvents(Model model, Principal principal) {

		String username = principal.getName();

		List<Event> yourEvents = eventsService.yourEvents(username);
		
		if(yourEvents.size() == 0){
			return "noEvents";
		}

		model.addAttribute("yourEvents", yourEvents);

		return "yourevents";
	}

	@RequestMapping(value = "/edityourevent", method = RequestMethod.GET)
	public String updateYourEvent(Model model, @Valid Event event, BindingResult result,
			@RequestParam(value = "event_id", required = false) String event_id,
			@RequestParam(value = "delete_id", required = false) String delete_id) {

		if(event_id != null) {
			
			String id = event_id.trim();
	
			int sanitized_id = Integer.parseInt(id);
	
			Event editingEvent = eventsService.getEvent(sanitized_id);
	
			model.addAttribute("event", editingEvent);
	
			return "createEvent";
		}
		
		else
		{
			
			String id = delete_id.trim();
			
			int sanitized_id = Integer.parseInt(id);
			
			boolean isDeleted = eventsService.deleteYourEvent(sanitized_id);
			
			if(isDeleted){
				return "eventDeleted";
			}
			return "error";
		}
	}

	@RequestMapping(value = "/docreate", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid Event event, BindingResult result, Principal principal,
			@RequestParam(value = "update", required = false) String update) {

		if (result.hasErrors()) {

			return "createEvent";
		}

		String username = principal.getName();

		if (update == null) {
			
			event.getUser().setUsername(username);
			eventsService.createEvent(event);
			return "eventCreated";
			
		} else {
			
			System.out.println("Updated event is : " + event.toString());
			event.getUser().setUsername(username);
			boolean isUpdated = eventsService.updateYourEvent(event);

			if (isUpdated) {
				return "eventCreated";
			} else {
				return "error";
			}
		}
	}

}
