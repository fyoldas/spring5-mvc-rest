package guru.springfamework.service;

import java.util.List;

import org.springframework.stereotype.Service;

import guru.springfamework.domain.Category;
import guru.springfamework.repositories.CategoryRepository;


@Service("FyCategory")
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategoryByName(String name) {
		return categoryRepository.findByName(name);
	}

}
