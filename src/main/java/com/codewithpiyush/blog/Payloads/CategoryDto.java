package com.codewithpiyush.blog.Payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	private Integer categoryId;
	@NotBlank(message = "Category Title cannot be blank.")
	@Size(min=3,max = 100,message = "Title should be between 6-100 Characters.")
	private String categoryTitle;
	
	@NotBlank(message = "Category Description cannot be blank.")
	@Size(min=3,max = 1000,message = "Description should be more than 6 Characters.")
	private String categoryDescription;
}
