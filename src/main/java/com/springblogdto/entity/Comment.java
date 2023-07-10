package com.springblogdto.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "The message should not be null or empty")
    @Size(max = 500, message = "The message should have a max of 500 characters")
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;


    @OneToMany(mappedBy = "comment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Like> likes;

    @OneToMany(mappedBy = "comment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Dislike> Dislikes;

}
