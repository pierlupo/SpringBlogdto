package com.springblogdto.service.impl;

import com.springblogdto.dto.PostDto;
import com.springblogdto.entity.Post;
import com.springblogdto.exception.NotFoundException;
import com.springblogdto.repository.PostRepo;
import com.springblogdto.service.PostService;
import com.springblogdto.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IPostService implements PostService {


    @Autowired
    private PostRepo postRepo;

    @Autowired
    private Mapper mapper;

    @Override
    public PostDto createPost(PostDto postDto) {

        Post post = mapper.mapToEntity(postDto);

        Post newPost = postRepo.save(post);

        PostDto postResponse = mapper.mapToDto(newPost);

        return postResponse;
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer id) {

        Post post = getPostByIdFromDatabase(id);

        post.setTitle(postDto.getTitle());
        post.setText(postDto.getText());

        Post updatePost = postRepo.save(post);
        return mapper.mapToDto(updatePost);
    }

    @Override
    public PostDto getPostById(Integer id) {

        Post post = getPostByIdFromDatabase(id);

        return mapper.mapToDto(post);
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = (List<Post>) postRepo.findAll();
        List<PostDto> postDtoList =  posts.stream().map(post->mapper.mapToDto(post)).collect(Collectors.toList());
        return postDtoList;
    }

    @Override
    public void deletePostById(Integer id) {

        Post post = getPostByIdFromDatabase(id);

        postRepo.deleteById(id);
    }

    private Post getPostByIdFromDatabase(Integer id) {

        return postRepo.findById(id).orElseThrow(() -> new NotFoundException("Post", "id", id));
    }

}
