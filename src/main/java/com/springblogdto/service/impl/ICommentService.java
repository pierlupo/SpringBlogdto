package com.springblogdto.service.impl;

import com.springblogdto.entity.Comment;
import com.springblogdto.repository.CommentRepo;
import com.springblogdto.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ICommentService implements CommentService {

    @Autowired
    private CommentRepo commentRepo;


    @Override
    public Comment createComment(Comment comment) {
            return commentRepo.save(comment);
    }

    @Override
    public Comment updateComment(Comment comment, Integer id) {
        Optional<Comment> comment1 = commentRepo.findById(id);
        if(comment1.isPresent()){
            Comment comment2 = comment1.get();
            comment2.setMessage(comment.getMessage());
            comment2.setPost(comment.getPost());
            comment2.setDislikes(comment.getDislikes());
            comment2.setLikes(comment.getLikes());
            return commentRepo.save(comment2);
        }
        return null;
    }

    @Override
    public Optional<Comment> getCommentbyId(Integer id) {
        return commentRepo.findById(id);
    }

    @Override
    public List<Comment> getAllComments() {
        return (List<Comment>) commentRepo.findAll();
    }

    @Override
    public void deleteCommentById(Integer id) {
        commentRepo.deleteById(id);
    }
}
