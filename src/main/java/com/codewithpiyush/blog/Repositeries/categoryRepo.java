package com.codewithpiyush.blog.Repositeries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithpiyush.blog.Entities.Category;

public interface categoryRepo extends JpaRepository<Category, Integer>{

}
