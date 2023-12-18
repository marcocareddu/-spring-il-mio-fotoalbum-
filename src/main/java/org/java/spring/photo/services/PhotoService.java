package org.java.spring.photo.services;

import java.util.List;
import org.java.spring.photo.pojo.Photo;
import org.java.spring.photo.repo.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {

	@Autowired
	private PhotoRepository photoRepository ;
	
	public List<Photo> findAll() {
		return photoRepository.findAll();
	}
	public List<Photo> findAllVisible() {
		return photoRepository.findByVisibleIsTrue();
	}
	public Photo findById(int id) {
		return photoRepository.findById(id).get();
	}
	public List<Photo> findByTitle(String searched) {
		return photoRepository.findByTitleContainingOrDescriptionContainingIgnoreCase(searched, searched);
	}
	public void save(Photo photo) {
		photoRepository.save(photo);
	}
	public void deleteById(int id) {
		photoRepository.deleteById(id);
	}
}