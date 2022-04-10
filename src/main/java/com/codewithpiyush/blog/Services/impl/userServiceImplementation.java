package com.codewithpiyush.blog.Services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.codewithpiyush.blog.Entities.User;
import com.codewithpiyush.blog.Payloads.UserDto;
import com.codewithpiyush.blog.Repositeries.UserRepo;
import com.codewithpiyush.blog.Services.UserService;
import com.codewithpiyush.blog.Exceptions.*;

public class userServiceImplementation implements UserService {

	@Autowired
	private UserRepo userRepo; 
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user = new User();
		user = dtoUserToUser(userDto);
		
		User savedUser = this.userRepo.save(user);
		return this.userToUserDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourseNotFoundException(userId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(user.getPassword());
		user.setAbout(userDto.getAbout());
		return this.userToUserDto(user);
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourseNotFoundException(userId));
		return this.userToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user -> userToUserDto(user)).collect(Collectors.toList());
		
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourseNotFoundException(userId));
		this.userRepo.delete(user);
	}
	
	private User dtoUserToUser(UserDto userDto)
	{
		User user = new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getPassword());
		return user;
	}

	private UserDto userToUserDto(User user)
	{
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getName());
		userDto.setPassword(user.getPassword());
		userDto.setAbout(user.getAbout());
		
		return userDto;
	}
	
}
