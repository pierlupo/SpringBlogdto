package com.springblogdto.controller;

import com.springblogdto.dto.PostDto;
import com.springblogdto.entity.Post;
import com.springblogdto.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v3")
public class PostController {

    @Autowired
    private PostService IPostService;

    @PostMapping("/save")
    public  ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto) {
        IPostService.createPost(postDto);
        return new ResponseEntity<>( IPostService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        return new ResponseEntity(IPostService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<PostDto> getPostByIdV1(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(IPostService.getPostById(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable(name = "id") Integer id){

        PostDto postResponse = IPostService.updatePost(postDto, id);

        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name="id") Integer id) {
        IPostService.deletePostById(id);
        return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
    }
}
