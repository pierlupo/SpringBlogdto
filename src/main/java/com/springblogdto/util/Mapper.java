package com.springblogdto.util;

import com.springblogdto.dto.CommentDto;
import com.springblogdto.dto.PostDto;
import com.springblogdto.dto.UserDto;
import com.springblogdto.entity.Comment;
import com.springblogdto.entity.Post;
import com.springblogdto.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public UserDto mapToDto(User user) {

        ModelMapper mapper = new ModelMapper();
        //map with modelMapper lib.
        UserDto userDto = mapper.map(user, UserDto.class);
        return userDto;

    }
    public User mapToEntity(UserDto userDto) {
        ModelMapper mapper = new ModelMapper();
        //map with modelMapper lib.
        User user = mapper.map(userDto, User.class);

        return user;
    }
    public PostDto mapToDto(Post post) {

        ModelMapper mapper = new ModelMapper();
        //map with modelMapper lib.
        PostDto postDto = mapper.map(post, PostDto.class);
        return postDto;
    }
    public Post mapToEntity(PostDto postDto) {
        ModelMapper mapper = new ModelMapper();
        //map with modelMapper lib.
        Post post = mapper.map(postDto, Post.class);

        return post;
    }
    public CommentDto mapToDto(Comment comment) {

        ModelMapper mapper = new ModelMapper();
        CommentDto commentDto = mapper.map(comment, CommentDto.class);

        return commentDto;
    }
    public Comment mapToEntity(CommentDto commentDto) {

        ModelMapper mapper = new ModelMapper();
        Comment comment = mapper.map(commentDto, Comment.class);

        return  comment;
    }
}
