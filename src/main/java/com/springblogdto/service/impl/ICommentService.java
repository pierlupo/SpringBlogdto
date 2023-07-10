package com.springblogdto.service.impl;

import com.springblogdto.dto.CommentDto;
import com.springblogdto.dto.PostDto;
import com.springblogdto.entity.Comment;
import com.springblogdto.entity.Post;
import com.springblogdto.exception.NotFoundException;
import com.springblogdto.repository.CommentRepo;
import com.springblogdto.service.CommentService;
import com.springblogdto.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ICommentService implements CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private Mapper mapper;

    @Override
    public CommentDto createComment(CommentDto commentDto) {

        Comment comment = mapper.mapToEntity(commentDto);

        Comment newComment = commentRepo.save(comment);

        CommentDto commentResponse = mapper.mapToDto(newComment);

        return commentResponse;
    }

    @Override
    public CommentDto updateComment(CommentDto commentDto, Integer id) {

        Comment comment = getCommentByIdFromDatabase(id);

        comment.setPost(commentDto.getPost());
        comment.setMessage(commentDto.getMessage());

        Comment updateComment = commentRepo.save(comment);
        return mapper.mapToDto(updateComment);
    }

    @Override
    public CommentDto getCommentbyId(Integer id) {
        Comment comment = getCommentByIdFromDatabase(id);

        return mapper.mapToDto(comment);
    }


    @Override
    public List<CommentDto> getAllComments() {
        List<Comment> comments = (List<Comment>) commentRepo.findAll();
        List<CommentDto> commentDtoList =  comments.stream().map(comment->mapper.mapToDto(comment)).collect(Collectors.toList());


        return commentDtoList;
    }


    @Override
    public void deleteCommentById(Integer id) {

        Comment comment = getCommentByIdFromDatabase(id);

        commentRepo.deleteById(id);
    }

    private Comment getCommentByIdFromDatabase(Integer id) {

        return commentRepo.findById(id).orElseThrow(() -> new NotFoundException("Comment", "id", id));
    }
}
