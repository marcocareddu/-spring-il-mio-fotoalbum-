package org.java.spring.photo.api;

import java.util.List;
import org.java.spring.photo.pojo.Photo;
import org.java.spring.photo.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1.0/photos")
public class PhotoRestController {

	@Autowired
	private PhotoService photoService;

	@GetMapping
	public ResponseEntity<List<Photo>> getIndex(@RequestParam(required = false) String searched) {

	    List<Photo> photos = searched == null ? photoService.findAllVisible() : photoService.findByTitleAndVisible(searched);

	    return new ResponseEntity<>(photos, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Photo> getPhoto(@PathVariable int id) {
		Photo photo = photoService.findById(id);
		if(photo == null) return new ResponseEntity<>(photo, HttpStatus.OK);
		return new ResponseEntity<>(photo, HttpStatus.OK);
	}
}