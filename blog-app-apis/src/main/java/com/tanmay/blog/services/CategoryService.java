package com.tanmay.blog.services;

import java.util.List;

import com.tanmay.blog.payloads.CategoryDto;

public interface CategoryService {
	
	//Create
	CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	//delete
	void deleteCategory(Integer categoryId);
	
	//get
	CategoryDto getCategory(Integer categoryId);
	
	//getAll
	List<CategoryDto> getCategories();
}
