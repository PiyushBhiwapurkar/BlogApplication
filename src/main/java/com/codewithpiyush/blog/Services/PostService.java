package com.codewithpiyush.blog.Services;

import java.util.List;

import com.codewithpiyush.blog.Payloads.PostDto;
import com.codewithpiyush.blog.Payloads.PostResponse;

public interface PostService {

	//Create Post
	PostDto createPost(PostDto post,Integer userId, Integer CategoryId);
	
	//Delete Post
	void deletePost(Integer postId);
	
	//Update Post
	PostDto updatePost(PostDto post,Integer postId);
	
	//Get all Posts
	PostResponse getAllPosts(Integer pageNo, Integer pageSize, String sortBy, String sortDirection);
	
	//Get Post by Id
	PostDto getPostById(Integer postId);
	
	//Get Post By User
	List<PostDto> getAllPostsByUser(Integer userId);
	
	//Get Post by Category
	List<PostDto> getAllPostsByCategory(Integer categoryId);
}
