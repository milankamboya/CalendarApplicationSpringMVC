package com.vandanpatel.calendar.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vandanpatel.calendar.model.Event;
import com.vandanpatel.calendar.model.User;
import com.vandanpatel.calendar.service.EventsService;
import com.vandanpatel.calendar.service.UsersService;

@Controller
public class LoginController {

	private UsersService usersService;
	
	private EventsService eventsService;

	@Autowired
	public void setEventsService(EventsService eventsService) {
		this.eventsService = eventsService;
	}

	@Autowired
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("/denied")
	public String showDenied() {
		return "denied";
	}
	
	@RequestMapping("/logggedout")
	public String showLoggedOut() {
		return "loggedout";
	}

	@RequestMapping("/newAccount")
	public String showNewAccount(Model model) {

		model.addAttribute("user", new User());

		return "newAccount";
	}

	@RequestMapping(value = "/createAccount", method = RequestMethod.POST)
	public String createAccount(@Valid User user, BindingResult result) {

		if (result.hasErrors()) {
			return "newAccount";
		}

		user.setAuthority("ROLE_USER");
		user.setEnabled(true);
		
		if(usersService.exists(user.getUsername())){
			result.rejectValue("username", "DuplicateKey.user.username");
			return "newAccount";
		}

		try {
			usersService.create(user);
		} catch (DuplicateKeyException e) {
			result.rejectValue("username", "DuplicateKey.user.username");
			return "newAccount";
		}

		return "accountCreated";
	}
	
	@RequestMapping("/admin")
	public String showAdmin(Model model){
		
		List<User> users = usersService.getAllUsers();
		
		model.addAttribute("users", users);
		
		return "admin";
	}
	
	@RequestMapping(value = "/edituser", method = RequestMethod.GET)
	public String editUser(Model model, @Valid User user, BindingResult result,
			@RequestParam(value = "user_id", required = false) String user_id,
			@RequestParam(value = "delete_id", required = false) String delete_id,
			@RequestParam(value = "event_id", required = false) String event_id){
		
		if(event_id != null){
			
			
			String id = event_id.trim();
			
			int sanitized_id = Integer.parseInt(id);
			
			User user_events = usersService.getUser(sanitized_id);
			
			String username = user_events.getUsername();
			
			List<Event> yourEvents = eventsService.yourEvents(username);
			
			if(yourEvents.size() == 0){
				return "noEvents";
			}
			
			model.addAttribute("yourEvents", yourEvents);
			
			return "yourevents";
		}
		
		if(user_id != null) {
			
			
			String id = user_id.trim();
			
			int sanitized_id = Integer.parseInt(id);
			
			User returned_user = usersService.getUser(sanitized_id);
			
			model.addAttribute("user", returned_user);
			
			return "editUser";
		}
		else {
			
			String id = delete_id.trim();
			
			int sanitized_id = Integer.parseInt(id);
			
			boolean isDeleted = usersService.deleteUser(sanitized_id);
			
			if(isDeleted){
				
				List<User> users = usersService.getAllUsers();
				
				model.addAttribute("users", users);
				
				return "admin";
			}
			else {
				return "error";
			}
		}
	}
	
	@RequestMapping(value = "/doedit", method = RequestMethod.POST)
	public String doEditUser(Model model, @Valid User user, BindingResult result, Principal principal,
			@RequestParam(value = "user_id", required = false) String user_id){
	
		boolean isUpdated = usersService.update(user);
		
		if(isUpdated){
			
			List<User> users = usersService.getAllUsers();
			
			model.addAttribute("users", users);
			
			return "admin";
		}
		
		return "error";
	}
}
