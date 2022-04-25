package com.codewithpiyush.blog.Repositeries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithpiyush.blog.Entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
