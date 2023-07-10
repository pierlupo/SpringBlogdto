package com.springblogdto.service;

import com.springblogdto.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CommentService {

    Comment createComment(Comment comment);

    Comment updateComment(Comment comment, Integer id);

    Optional<Comment> getCommentbyId(Integer id);

    List<Comment> getAllComments();

    void deleteCommentById(Integer id);

}
