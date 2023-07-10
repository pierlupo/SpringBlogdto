package com.springblogdto.controller;

import com.springblogdto.dto.UserDto;
import com.springblogdto.entity.User;
import com.springblogdto.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class UserController {

    @Autowired
    private UserService IUserService;

    @PostMapping("/save")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {

        IUserService.createUser(userDto);

        return new ResponseEntity<>(IUserService.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {

        return new ResponseEntity(IUserService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Integer id){

        return ResponseEntity.ok(IUserService.getUserById(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable(name = "id") Integer id){

        UserDto userResponse = IUserService.updateUser(userDto, id);

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") Integer id){

        IUserService.deleteUserById(id);

        return new ResponseEntity<>("User deleted successfully.", HttpStatus.OK);
    }

}
