package com.tanmay.blog.services;

import java.util.List;

import com.tanmay.blog.entities.Post;
import com.tanmay.blog.payloads.PostDto;
import com.tanmay.blog.payloads.PostResponse;

public interface PostService {

	//create
	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	PostDto updatePost(PostDto postDto, Integer postId);
	
	void deletePost(Integer postId);
	
	PostResponse getAllPost(Integer pageNumber,Integer pageSizes, String sortBy, String sortDir);
	
	PostDto getPostById(Integer postId);
	
	List<PostDto> getPostByCategory(Integer categoryId);
	
	List<PostDto> getPostByUser(Integer userId);
	
	List<PostDto> searchPost(String keyword);
}
