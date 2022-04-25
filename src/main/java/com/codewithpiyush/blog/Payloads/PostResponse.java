package com.codewithpiyush.blog.Payloads;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostResponse {

	private List<PostDto> contents;
	private Integer pageSize;
	private Integer pageNumber;
	private Long totalElements;
	private Integer totalPages;
	private Boolean isLastPage;
	
}
