package com.springblogdto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "_dislike")
public class Dislike {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Temporal(TemporalType.DATE)
    private LocalDate Date;

    @ManyToOne
    private Comment comment;

}
