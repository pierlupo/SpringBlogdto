package com.springblogdto.dto;

import com.springblogdto.entity.Post;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CommentDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty(message = "The message should not be null or empty")
    @Size(max = 500, message = "The message should have a max of 500 characters")
    private String message;

    private Post post;
}
