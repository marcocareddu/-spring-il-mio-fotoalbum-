package org.java.spring.photo.controller;

import org.java.spring.photo.pojo.Category;
import org.java.spring.photo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categories/create")
	public String create(Model model) {

		model.addAttribute("category", new Category());
		model.addAttribute("action", "create");
		return "categoryForm";
	}
	
	@PostMapping("/categories/create")
	public String store(Model model, @Valid @ModelAttribute Category category, BindingResult bindingResult) {

		System.out.println("Categoria " + category.getName() + " aggiunta");
		categoryService.save(category);
		return "redirect:/index-categories";
	}
	
	@PostMapping("/categories/delete/{id}")
	public String deleteCategory(@PathVariable int id) {
		categoryService.deleteById(id);
		return "redirect:/index-categories";
	}
	
	@GetMapping("/categories/edit/{id}")
	public String editCategory(Model model, @PathVariable int id) {
		
		Category category = categoryService.findById(id);
		model.addAttribute("category", category);
		model.addAttribute("action", "edit");
		
		return "categoryForm";
	}

	@PostMapping("/categories/edit/{id}")
	public String updateCategory(Model model, @Valid @ModelAttribute Category category, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			System.out.println("Errors: \n" + bindingResult);
			model.addAttribute("category", category);
			return "categoryForm";
		}

		System.out.println("Categoria " + category.getName() + " modificata");
		
		categoryService.save(category);
		return "redirect:/index-categories";
	}
	
	
}