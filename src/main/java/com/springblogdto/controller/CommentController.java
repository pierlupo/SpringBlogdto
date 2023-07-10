package com.springblogdto.controller;


import com.springblogdto.entity.Comment;
import com.springblogdto.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v2")
public class CommentController {

    @Autowired
    private CommentService ICommentService;

    @PostMapping("/save")
    ResponseEntity<String> createComment(@Valid @RequestBody Comment comment) {
        ICommentService.createComment(comment);
        return ResponseEntity.ok("Your comment has been published");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Comment>> getAllComments() {
        return new ResponseEntity(ICommentService.getAllComments(), HttpStatus.OK);
    }

    @GetMapping("/comment/{id}")
    public ResponseEntity<Optional<Comment>> getCommentById(@PathVariable(name="id")Integer id) {
        return ResponseEntity.ok(ICommentService.getCommentbyId(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment, @PathVariable(name="id")Integer id) {
        Comment commentResponse = ICommentService.updateComment(comment, id);
        return new ResponseEntity<>(commentResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable(name="id") Integer id) {
        ICommentService.deleteCommentById(id);
        return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
    }

}
