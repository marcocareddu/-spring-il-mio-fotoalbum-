package org.java.spring.photo.controller;

import java.util.List;
import org.java.spring.photo.pojo.Category;
import org.java.spring.photo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/index-categories")
	public String getIngredients(Model model) {
		
		List<Category> categories = categoryService.findAll();
		model.addAttribute("list", categories);
		
		return "IndexCategories";
	}
}