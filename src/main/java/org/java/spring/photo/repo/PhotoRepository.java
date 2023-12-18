package org.java.spring.photo.repo;

import java.util.List;
import org.java.spring.photo.pojo.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Integer>{
	List<Photo> findByTitleContainingOrDescriptionContainingIgnoreCase(String title, String description);
	List<Photo> findByVisibleIsTrue();
}