package com.codewithpiyush.blog.Services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.codewithpiyush.blog.Entities.Category;
import com.codewithpiyush.blog.Entities.Post;
import com.codewithpiyush.blog.Entities.User;
import com.codewithpiyush.blog.Exceptions.ResourseNotFoundException;
import com.codewithpiyush.blog.Payloads.PostDto;
import com.codewithpiyush.blog.Payloads.PostResponse;
import com.codewithpiyush.blog.Repositeries.UserRepo;
import com.codewithpiyush.blog.Repositeries.CategoryRepo;
import com.codewithpiyush.blog.Repositeries.PostRepo;
import com.codewithpiyush.blog.Services.PostService;

@Service
public class postServiceImplementation implements PostService {

	@Autowired	private PostRepo postService;
	
	@Autowired 	private UserRepo userRepo;
	
	@Autowired  private CategoryRepo categoryRepo;
	
	@Autowired	private ModelMapper modelmapper;
	
	@Override
	public PostDto createPost(PostDto post, Integer userId, Integer CategoryId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourseNotFoundException("User","user Id",userId));
		Category category = this.categoryRepo.findById(CategoryId).orElseThrow(()-> new ResourseNotFoundException("Category","Category Id",CategoryId));
		
		Post addedPost = this.modelmapper.map(post, Post.class);
		addedPost.setAddedDate(new Date());
		addedPost.setImageName("Default.png");
		addedPost.setUser(user);
		addedPost.setCategory(category);
		
		postService.save(addedPost);
		
		return this.modelmapper.map(addedPost, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		Post post = this.postService.findById(postId).orElseThrow(()->new ResourseNotFoundException("Post", "Post Id", postId));
		this.postService.delete(post);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post = this.postService.findById(postId).orElseThrow(()->new ResourseNotFoundException("Post","Post Id", postId));
		
		//post.setUser(postDto.getUser());
		post.setTitle(postDto.getTitle());
		post.setImageName(postDto.getImageName());
		post.setContent(postDto.getContent());
		//post.setCategory(postDto.getCategory());
		post.setAddedDate(new Date());
		
		Post updatedPost = this.postService.save(post);
		
		return this.modelmapper.map(updatedPost, PostDto.class);
	}

	@Override
	public PostResponse getAllPosts(Integer pageNo, Integer pageSize, String sortBy, String sortDirection) {
		
		Sort sort = (sortDirection.equalsIgnoreCase("asc")?(Sort.by(sortBy).ascending()):(Sort.by(sortBy).descending()));
		
		Pageable p = PageRequest.of(pageNo, pageSize, sort);
		Page<Post> pagePosts = this.postService.findAll(p);
		List<Post> allPosts = pagePosts.getContent();
		
		List<PostDto> getAllPostsDto = allPosts.stream().map(post-> this.modelmapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		PostResponse postResponse = new PostResponse();
		postResponse.setContents(getAllPostsDto);
		postResponse.setIsLastPage(pagePosts.isLast());
		postResponse.setPageNumber(pagePosts.getNumber());
		postResponse.setPageSize(pagePosts.getSize());
		postResponse.setTotalElements(pagePosts.getTotalElements());
		postResponse.setTotalPages(pagePosts.getTotalPages());
		
		return postResponse;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post = this.postService.findById(postId).orElseThrow(()->new ResourseNotFoundException("Post","Post Id", postId));
		PostDto postDto = this.modelmapper.map(post, PostDto.class);
		return postDto;
	}

	@Override
	public List<PostDto> getAllPostsByUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourseNotFoundException("User", "User Id", userId));
		List<Post> postByUser = this.postService.findByUser(user);
		List<PostDto> postDtoByUser = postByUser.stream().map((post)->this.modelmapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		return postDtoByUser;
	}

	@Override
	public List<PostDto> getAllPostsByCategory(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourseNotFoundException("Category","Category Id",categoryId));
		List<Post> allPostsByCategory = this.postService.findByCategory(category);
		List<PostDto> allPostsDtoByCategory = allPostsByCategory.stream().map(post->this.modelmapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		return allPostsDtoByCategory;
	}

}
