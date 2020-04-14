package guru.springfamework.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springfamework.domain.Category;
import guru.springfamework.repositories.CategoryRepository;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

	@Mock
	CategoryRepository categoryRepository; 
	
	@InjectMocks
	CategoryServiceImpl categoryService; 


	@Test
	void testGetAllCategories() {
		List<Category> categories = categoryService.getAllCategories();
		System.out.println("size:" + categories.size());
	}

	@Test
	void testGetCategoryByName() {
		Category category = new Category();
		category.setName("test12313131");
		
	   when(categoryService.getCategoryByName(anyString())).thenReturn(category);
		
		Category category1 = categoryService.getCategoryByName("Fruits");
		System.out.println(category1.getName());
	}

}
