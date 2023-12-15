package org.java.spring.photo.services;

import java.util.List;
import org.java.spring.photo.message.pojo.Message;
import org.java.spring.photo.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository ;
	
	public List<Message> findAll() {
		return messageRepository.findAll();
	}
	public Message findById(int id) {
		return messageRepository.findById(id).get();
	}
	public void save(Message message) {
		messageRepository.save(message);
	}
	public void deleteById(int id) {
		messageRepository.deleteById(id);
	}
}
