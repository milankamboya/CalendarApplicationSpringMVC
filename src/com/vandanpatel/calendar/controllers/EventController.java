package com.vandanpatel.calendar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventController {

	@RequestMapping("/")
	public String hello(){
		
		return "index";
	}
}
