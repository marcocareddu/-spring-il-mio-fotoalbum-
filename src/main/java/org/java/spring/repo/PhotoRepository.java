package org.java.spring.repo;

import java.util.List;
import org.java.spring.photo.pojo.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Integer>{
	List<Photo> findByNameContainingOrDescriptionContainingIgnoreCase(String title, String description);
}
