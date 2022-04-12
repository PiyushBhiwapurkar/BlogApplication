package com.codewithpiyush.blog.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithpiyush.blog.Payloads.ApiResponse;
import com.codewithpiyush.blog.Payloads.CategoryDto;
import com.codewithpiyush.blog.Services.CategoryService;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;

	//create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto)
	{
		CategoryDto createCategory = categoryService.createCategory(categoryDto);
		return new ResponseEntity<>(createCategory,HttpStatus.CREATED);
	}
	
	//delete
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("categoryId") Integer categoryId)
	{
		this.categoryService.deleteCategory(categoryId);
		return new ResponseEntity(new ApiResponse("Category Deleted Successfully", true),HttpStatus.OK);
	}
	
	//update
	@PutMapping("/{categoryDtoId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable("categoryDtoId") Integer categoryDtoId)
	{
		CategoryDto updateCategory = this.categoryService.updateCategory(categoryDto, categoryDtoId);
		return new ResponseEntity<>(updateCategory,HttpStatus.OK);
	}
	
	//get 1 Category
	@GetMapping("/{categoryDtoId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable("categoryDtoId") Integer categoryDtoId)
	{
		CategoryDto getCategory = this.categoryService.getCategory(categoryDtoId);
		return new ResponseEntity<CategoryDto>(getCategory,HttpStatus.OK);
	}
	
	//get all categories
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategories()
	{
		List<CategoryDto> allCategories = this.categoryService.getCategories();
		return new ResponseEntity<List<CategoryDto>>(allCategories,HttpStatus.OK);
	}
}
