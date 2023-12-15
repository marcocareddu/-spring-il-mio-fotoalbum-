package org.java.spring.photo.controller;

import java.util.List;

import org.java.spring.photo.message.pojo.Message;
import org.java.spring.photo.pojo.Category;
import org.java.spring.photo.pojo.Photo;
import org.java.spring.photo.services.CategoryService;
import org.java.spring.photo.services.MessageService;
import org.java.spring.photo.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;

@Controller
public class PhotoController {

	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private MessageService messageService;
	
	@GetMapping
	public String getPhotos(Model model, @RequestParam(required = false) String searched) {
		List<Photo> photos = searched == null ? photoService.findAll() : photoService.findByName(searched);
		model.addAttribute("list", photos);
		model.addAttribute("searched", searched == null ? "" : searched);
		return "index";
	}

	@GetMapping("/detail/{id}")
	public String getPhoto(Model model, @PathVariable int id) {
		Photo photo = photoService.findById(id);
		model.addAttribute("list", photo);
		model.addAttribute("id", id);
		return "detail";
	}

	@GetMapping("/create")
	public String create(Model model) {
		List<Category> categories = categoryService.findAll();
		model.addAttribute("photo", new Photo());
		model.addAttribute("action", "create");
		model.addAttribute("categories", categories);
		
		return "form";
	}
	@PostMapping("/create")
	public String store(Model model, @Valid @ModelAttribute Photo photo, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			System.out.println("Errors: \n" + bindingResult);
			model.addAttribute("photo", photo);
			return "form";
		}

		System.out.println("Foto " + photo.getTitle() + " aggiunta");

		photoService.save(photo);
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String editPhoto(Model model, @PathVariable int id) {
		
		List<Category> categories = categoryService.findAll();
		Photo photo = photoService.findById(id);
		model.addAttribute("photo", photo);
		model.addAttribute("action", "edit");
		model.addAttribute("categories", categories);
		
		return "form";
	}

	@PostMapping("/edit/{id}")
	public String updatePhoto(Model model, @Valid @ModelAttribute Photo photo, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			System.out.println("Errors: \n" + bindingResult);
			model.addAttribute("photo", photo);
			return "form";
		}

		System.out.println("Photo " + photo.getTitle() + " modificata");
		
		photoService.save(photo);
		return "redirect:/";
	}

	@PostMapping("/delete/{id}")
	public String deletePhoto(@PathVariable int id) {
		photoService.deleteById(id);
		return "redirect:/";
	}
	
	@GetMapping("/index-categories")
	public String getIngredients(Model model) {
		
		List<Category> categories = categoryService.findAll();
		model.addAttribute("list", categories);
		
		return "IndexCategories";
	}
	
	@GetMapping("/index-messages")
	public String getMessages(Model model) {
		
		List<Message> messages = messageService.findAll();
		model.addAttribute("list", messages);

		return "IndexMessages";
	}
}