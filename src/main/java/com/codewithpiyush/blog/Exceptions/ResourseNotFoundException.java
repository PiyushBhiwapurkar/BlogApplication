package com.codewithpiyush.blog.Exceptions;

public class ResourseNotFoundException extends RuntimeException{

	String client;
	String entity;
	long userId;

	public ResourseNotFoundException(String client,String entity,long userId) {
		super(String.format("%s not found with %s: %s",client,entity,userId));
		this.userId = userId;
	}
	
}
