package com.springblogdto.service.impl;

import com.springblogdto.dto.UserDto;
import com.springblogdto.entity.User;
import com.springblogdto.exception.NotFoundException;
import com.springblogdto.repository.UserRepo;
import com.springblogdto.service.UserService;
import com.springblogdto.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IUserService implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private Mapper mapper;

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = mapper.mapToEntity(userDto);

        User newUser = userRepo.save(user);

        UserDto userResponse = mapper.mapToDto(newUser);

        return userResponse;
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer id) {

        User user = getUserByIdFromDatabase(id);

        user.setUserName(userDto.getUserName());

        User updateUser = userRepo.save(user);
        return mapper.mapToDto(updateUser);
    }

    @Override
    public UserDto getUserById(Integer id) {

        User user = getUserByIdFromDatabase(id);

        return mapper.mapToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = (List<User>) userRepo.findAll();
        List<UserDto> userDtoList = users.stream().map(user->mapper.mapToDto(user)).collect(Collectors.toList());
        return userDtoList;
    }

    @Override
    public void deleteUserById(Integer id) {

        User user = getUserByIdFromDatabase(id);

        userRepo.deleteById(id);
    }

    private User getUserByIdFromDatabase(Integer id) {

        return userRepo.findById(id).orElseThrow(() -> new NotFoundException("User", "id", id));
    }
}
