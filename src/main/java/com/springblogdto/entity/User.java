package com.springblogdto.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "The username should not be null or empty")
    @Size(max = 15, message = "The username should have a max of 15 characters")
    private String userName;

    @NotEmpty(message="The password should not be null or empty")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]{2})(?=.*?[#?!@$%^&*-]).{0,8}$")/*At least one upper case (?=.*?[A-Z]), At least one lower case (?=.*?[a-z]), At least one digit (?=.*?[0-9]), At least one special character (?=.*?[#?!@$%^&*-]), Max eight in length .{8}*/
    private String password;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY)
    private Set<Post> posts = new HashSet<>();

}
