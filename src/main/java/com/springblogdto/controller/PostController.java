package com.springblogdto.controller;

import com.springblogdto.entity.Post;
import com.springblogdto.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v3")
public class PostController {

    @Autowired
    private PostService IPostService;

    @PostMapping("/save")
    ResponseEntity<String> createPost(@Valid @RequestBody Post post) {
        IPostService.createPost(post);
        return ResponseEntity.ok("Yo have published a post");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAllPosts() {
        return new ResponseEntity(IPostService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Optional <Post>> getPostById(@PathVariable(name="id")Integer id) {
        return ResponseEntity.ok(IPostService.getPostById(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Post> updatePost(@RequestBody Post post, @PathVariable(name="id")Integer id) {
        Post postResponse = IPostService.updatePost(post, id);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name="id") Integer id) {
        IPostService.deletePostById(id);
        return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
    }
}
