package com.codewithpiyush.blog.Services;

import java.util.List;

import com.codewithpiyush.blog.Payloads.UserDto;

public interface UserService {

	//Create User
	UserDto createUser(UserDto userDto);
	
	//Update User
	UserDto updateUser(UserDto userDto, Integer userId);
	
	//Get User By Id
	UserDto getUserById(Integer id);
	
	//get All Users
	List<UserDto> getAllUsers();
	
	//Delete User using Id
	void deleteUser(Integer userId);
	
}
