package guru.springfamework.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springfamework.domain.Categories;
import guru.springfamework.domain.Category;
import guru.springfamework.service.CategoryService;

@Controller
@RequestMapping({"/api/v1/categories","/api/v1/categories/"})
public class CategoryController {
	
	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	
	@GetMapping
	public ResponseEntity<Categories> getAllCategories(){
		Categories categories = new Categories();
		categories.setCategories(categoryService.getAllCategories());
		return new ResponseEntity<Categories>(categories, HttpStatus.OK) ;
	}
	
	@GetMapping("{name}")
	public ResponseEntity<Category> getCategoryByName(@PathVariable String name) {
		return new ResponseEntity<Category>
		(categoryService.getCategoryByName(name), HttpStatus.OK);
	}

}
