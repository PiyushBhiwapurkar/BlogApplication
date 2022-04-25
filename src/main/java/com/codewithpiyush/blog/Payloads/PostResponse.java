package com.codewithpiyush.blog.Payloads;

import java.util.List;

public class PostResponse {

	private List<PostDto> contents;
	private Integer pageSize;
	private Integer pageNumber;
	private Integer totalElements;
	private Integer totalPages;
	private Boolean lastPage;
	
}
