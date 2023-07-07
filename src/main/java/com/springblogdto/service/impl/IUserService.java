package com.springblogdto.service.impl;

import com.springblogdto.entity.User;
import com.springblogdto.repository.UserRepo;
import com.springblogdto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IUserService implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(User user, Integer id) {
        Optional<User> user1 = userRepo.findById(id);

        if(user1.isPresent()){
            User user2 = user1.get();
            user2.setUserName(user.getUserName());
            user2.setPassword(user.getPassword());
            return userRepo.save(user2);
        }
        return null;
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepo.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepo.deleteById(id);
    }
}
