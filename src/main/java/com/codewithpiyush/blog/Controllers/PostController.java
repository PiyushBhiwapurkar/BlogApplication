package com.codewithpiyush.blog.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codewithpiyush.blog.Payloads.ApiResponse;
import com.codewithpiyush.blog.Payloads.PostDto;
import com.codewithpiyush.blog.Services.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	PostService postService;

	//Create Post
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto, 
			@PathVariable Integer userId, 
			@PathVariable Integer categoryId)
	{
		System.out.println("Testing");
		PostDto createdPost = postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createdPost,HttpStatus.CREATED);
	}
	
	//Delete Post
	@DeleteMapping("/post/{postId}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable("postId") Integer postId)
	{
		this.postService.deletePost(postId);
		return new ResponseEntity<ApiResponse>( new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
	}
	
	//Update Post
	@PutMapping("/post/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable("postId") Integer postid)
	{
		PostDto updatePost = this.postService.updatePost(postDto, postid);
		return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
	}
	
	//Get All Posts
	@GetMapping("/post")
	public ResponseEntity<List<PostDto>> getAllPosts(
			@RequestParam(value="pageNumber",defaultValue = "0",required = false) Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue = "1",required = false) Integer pageSize)
	{
		List<PostDto> allPosts = this.postService.getAllPosts(pageNumber,pageSize);
		return new ResponseEntity<List<PostDto>>(allPosts,HttpStatus.OK);
	}
	
	//Get Post By Id
	@GetMapping("/post/{postId}/")
	public ResponseEntity<PostDto> getPostById(@PathVariable("postId") Integer postId)
	{
		PostDto postById = this.postService.getPostById(postId);
		return new ResponseEntity<PostDto>(postById,HttpStatus.OK);
	}
	
	//Get All Posts by User
	@GetMapping("/post/user/{userId}")
	public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable("userId") Integer userId)
	{
		List<PostDto> allPostsByUser = this.postService.getAllPostsByUser(userId);
		return new ResponseEntity<List<PostDto>>(allPostsByUser,HttpStatus.OK);
	}
	
	//Get All Posts By Category
	@GetMapping("/post/category/{categoryId}")
	public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable("categoryId") Integer categoryId)
	{
		List<PostDto> allPostsByCategory = this.postService.getAllPostsByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(allPostsByCategory,HttpStatus.OK);
	}
	
}
