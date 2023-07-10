package com.springblogdto.util;

import com.springblogdto.dto.*;
import com.springblogdto.entity.*;
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

    public LikeDto mapToDto(Like like) {

        ModelMapper mapper = new ModelMapper();
        //map with modelMapper lib.
        LikeDto likeDto = mapper.map(like, LikeDto.class);
        return likeDto;

    }
    public Like mapToEntity( LikeDto likeDto) {
        ModelMapper mapper = new ModelMapper();
        //map with modelMapper lib.
        Like like = mapper.map(likeDto, Like.class);

        return like;
    }

    public DisLikeDto mapToDto(Dislike dislike) {

        ModelMapper mapper = new ModelMapper();
        //map with modelMapper lib.
        DisLikeDto dislikeDto = mapper.map(dislike, DisLikeDto.class);
        return dislikeDto;

    }
    public Dislike mapToEntity(DisLikeDto disLikeDto) {
        ModelMapper mapper = new ModelMapper();
        //map with modelMapper lib.
        Dislike dislike = mapper.map(disLikeDto, Dislike.class);

        return dislike;
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
