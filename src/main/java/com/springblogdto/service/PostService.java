package com.springblogdto.service;

import com.springblogdto.dto.PostDto;
import com.springblogdto.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PostService {

    PostDto createPost(PostDto postDto);

    PostDto updatePost(PostDto postDto, Integer id);

    PostDto getPostById(Integer id);

    List<PostDto> getAllPosts();

    void deletePostById(Integer id);
}
