package org.java.spring.photo.controller;

import org.java.spring.photo.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@PostMapping("/messages/delete/{id}")
	public String deleteMessage(@PathVariable int id) {
		messageService.deleteById(id);
		return "redirect:/index-messages";
	}
}