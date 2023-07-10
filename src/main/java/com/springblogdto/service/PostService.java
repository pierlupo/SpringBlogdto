package com.springblogdto.service;

import com.springblogdto.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PostService {

    Post createPost(Post post);

    Post updatePost(Post post, Integer id);

    Optional<Post> getPostById(Integer id);

    List<Post> getAllPosts();

    void deletePostById(Integer id);
}
