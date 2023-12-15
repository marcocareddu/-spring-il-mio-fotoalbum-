package org.java.spring.photo.services;

import java.util.List;

import org.java.spring.photo.pojo.Category;
import org.java.spring.photo.pojo.Photo;
import org.java.spring.photo.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private PhotoService photoService;
    
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
	public Category findById(int id) {
		return categoryRepository.findById(id).get();
	}
	public void save(Category ingredient) {
		categoryRepository.save(ingredient);
	}

    public void deleteById(int id) {
    	Category category = categoryRepository.findById(id).get();

        if (category != null) {
            List<Photo> photos = category.getPhotos();

            if (photos != null) {
                for (Photo photo : photos) {
                	photo.getCategories().remove(category);
                	photoService.save(photo);
                }
            }
            categoryRepository.deleteById(id);
        }
    }
}
