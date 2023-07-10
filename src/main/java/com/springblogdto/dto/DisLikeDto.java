package com.springblogdto.dto;

import com.springblogdto.entity.Comment;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DisLikeDto {

    private List<Comment> comments;
}
