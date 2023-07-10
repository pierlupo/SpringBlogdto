package com.springblogdto.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty(message = "The title should not be null or empty")
    @Size(min = 4, max = 15, message = "The title should have a min of 4 and a max of 15 characters")
    private String title;

    @NotEmpty(message = "The text should not be null or empty")
    @Size(max = 250, message = "The text should have a max of 250 characters")
    private String text;


}
