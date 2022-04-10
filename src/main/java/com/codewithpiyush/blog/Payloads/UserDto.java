package com.codewithpiyush.blog.Payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;	
	
	@NotBlank
	@Size(min=3,max=12,message = "Name should be between 3 - 12 characters.")
	private String name;	
	
	@NotBlank
	@Email
	private String email;	
	
	@NotBlank
	@Size(min=3,max=12,message = "Password should be between 3 - 12 characters.")
	private String password;	
	
	@NotBlank
	private String about;	
}
