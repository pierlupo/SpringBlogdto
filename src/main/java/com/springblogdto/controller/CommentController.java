package com.springblogdto.controller;


import com.springblogdto.dto.CommentDto;
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
    ResponseEntity<CommentDto> createComment(@Valid @RequestBody CommentDto commentDto) {
        ICommentService.createComment(commentDto);
        return new ResponseEntity<>( ICommentService.createComment(commentDto), HttpStatus.CREATED);    }

    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> getAllComments() {
        return new ResponseEntity(ICommentService.getAllComments(), HttpStatus.OK);
    }

    @GetMapping("/comment/{id}")
    public ResponseEntity<CommentDto> getCommentByIdV2(@PathVariable(name="id")Integer id) {
        return ResponseEntity.ok(ICommentService.getCommentbyId(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto commentDto, @PathVariable(name="id")Integer id) {
        CommentDto commentResponse = ICommentService.updateComment(commentDto, id);
        return new ResponseEntity<>(commentResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable(name="id") Integer id) {
        ICommentService.deleteCommentById(id);
        return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
    }

}
