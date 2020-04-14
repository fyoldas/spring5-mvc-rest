package guru.springfamework.service;

import java.util.List;

import guru.springfamework.domain.Category;

public interface CategoryService {

	List<Category> getAllCategories();
	Category getCategoryByName(String name);
}
