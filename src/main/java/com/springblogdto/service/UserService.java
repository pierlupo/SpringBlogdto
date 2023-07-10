package com.springblogdto.service;

import com.springblogdto.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto updateUser(UserDto userDto, Integer id);

    UserDto getUserById(Integer id);

    List<UserDto> getAllUsers();

    void deleteUserById(Integer id);
}
