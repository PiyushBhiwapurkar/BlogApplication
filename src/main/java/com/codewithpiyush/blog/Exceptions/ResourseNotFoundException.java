package com.codewithpiyush.blog.Exceptions;

public class ResourseNotFoundException extends RuntimeException{

	long userId;

	public ResourseNotFoundException(long userId) {
		super(String.format("User not found with Id %l",userId));
		this.userId = userId;
	}
	
}
