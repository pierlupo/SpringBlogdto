package com.springblogdto.controller;

import com.springblogdto.entity.User;
import com.springblogdto.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class UserController {

    @Autowired
    private UserService IUserService;

    @PostMapping("/save")
    ResponseEntity<String> createUser(@Valid @RequestBody User user) {

        IUserService.createUser(user);

        return ResponseEntity.ok("User successfully created");
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {

        return new ResponseEntity(IUserService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable(name = "id") int id){

        return ResponseEntity.ok(IUserService.getUserById(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<User> updateAuthor(@RequestBody User author, @PathVariable(name = "id") int id){

        User userResponse = IUserService.updateUser(author, id);

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") int id){

        IUserService.deleteUserById(id);

        return new ResponseEntity<>("User deleted successfully.", HttpStatus.OK);
    }

}
