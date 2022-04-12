package com.codewithpiyush.blog.Services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithpiyush.blog.Entities.Category;
import com.codewithpiyush.blog.Exceptions.ResourseNotFoundException;
import com.codewithpiyush.blog.Payloads.CategoryDto;
import com.codewithpiyush.blog.Repositeries.categoryRepo;
import com.codewithpiyush.blog.Services.CategoryService;

@Service
public class categoryServiceImplementation implements CategoryService{

	private static final String Id = null;

	@Autowired
	categoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = this.modelmapper.map(categoryDto, Category.class);
		Category addedCategory = categoryRepo.save(category);
		return this.modelmapper.map(addedCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryDtoId) {
		Category foundCategory = this.categoryRepo.findById(categoryDtoId).orElseThrow(()-> new ResourseNotFoundException("Category","Id",categoryDtoId));
		this.categoryRepo.delete(foundCategory);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryDtoId) {
		Category foundCategory = this.categoryRepo.findById(categoryDtoId).orElseThrow(()->new ResourseNotFoundException("Category", Id, categoryDtoId));
		foundCategory.setCategoryTitle(categoryDto.getCategoryTitle());
		foundCategory.setCategoryDescription(categoryDto.getCategoryDescription());
		Category updateCategory = categoryRepo.save(foundCategory);
		return this.modelmapper.map(updateCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto getCategory(Integer categoryDtoId) {
		Category foundCategory = categoryRepo.findById(categoryDtoId).orElseThrow(()-> new ResourseNotFoundException("Category", "Id", categoryDtoId));
		return this.modelmapper.map(foundCategory, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		List<Category> findAllCategories = categoryRepo.findAll();
		List<CategoryDto> allCategories = findAllCategories.stream().map(dto->this.modelmapper.map(dto, CategoryDto.class)).collect(Collectors.toList());
		return allCategories;
	}

}
