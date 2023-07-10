package com.springblogdto.service;

import com.springblogdto.dto.CommentDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CommentService {

    CommentDto createComment(CommentDto commentDto);

    CommentDto updateComment(CommentDto commentDto, Integer id);

    CommentDto getCommentbyId(Integer id);

    List<CommentDto> getAllComments();

    void deleteCommentById(Integer id);

}
