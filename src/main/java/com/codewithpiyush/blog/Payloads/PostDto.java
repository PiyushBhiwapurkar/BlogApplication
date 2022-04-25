package com.codewithpiyush.blog.Payloads;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.codewithpiyush.blog.Entities.Category;
import com.codewithpiyush.blog.Entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

	@NotBlank
	@Size(max = 1000,min = 5)
	private String title;
	
	@NotBlank
	@Size(min=5,max = 10000)
	private String content;
	
	//Non Displaying Contents
	private String imageName;
	
	private Date addedDate;
	
	private CategoryDto category;
	
	private UserDto user;
	
}
