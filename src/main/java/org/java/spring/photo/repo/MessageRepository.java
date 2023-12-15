package org.java.spring.photo.repo;

import java.util.List;
import org.java.spring.photo.message.pojo.Message;
import org.java.spring.photo.pojo.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer>{

	List<Photo> findByEmailContainingOrMessageContainingIgnoreCase(String email, String message);
}
