package com.codewithpiyush.blog.Repositeries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithpiyush.blog.Entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
