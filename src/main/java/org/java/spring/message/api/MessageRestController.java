package org.java.spring.message.api;

import org.java.spring.photo.message.pojo.Message;
import org.java.spring.photo.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1.0/messages")
public class MessageRestController {

	@Autowired
	private MessageService messageService;
	
	@PostMapping
	public ResponseEntity<Message> create(@RequestBody Message message) {
		
		messageService.save(message);
		
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}