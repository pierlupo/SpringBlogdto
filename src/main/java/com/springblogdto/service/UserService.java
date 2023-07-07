package com.springblogdto.service;

import com.springblogdto.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    User createUser(User user);

    User updateUser(User user, Integer id);

    Optional<User> getUserById(Integer id);

    List<User> getAllUsers();

    void deleteUserById(Integer id);
}
