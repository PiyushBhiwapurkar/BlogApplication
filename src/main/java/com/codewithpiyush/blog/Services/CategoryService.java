package com.codewithpiyush.blog.Services;

import java.util.List;

import com.codewithpiyush.blog.Payloads.CategoryDto;

public interface CategoryService {

	//Create Category
	CategoryDto createCategory(CategoryDto categoryDto);
	
	//Delete Category
	void deleteCategory(Integer categoryDtoId);
	
	//update Category
	CategoryDto updateCategory(CategoryDto categoryDto,Integer Id);
	
	//Get 1 Category
	CategoryDto getCategory(Integer categoryDtoId);
	
	//Get all Category
	List<CategoryDto> getCategories();
	
}
