package com.codewithpiyush.blog.Repositeries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithpiyush.blog.Entities.Category;
import com.codewithpiyush.blog.Entities.Post;
import com.codewithpiyush.blog.Entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{

	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);
	
}
