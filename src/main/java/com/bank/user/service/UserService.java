package com.bank.user.service;

import com.bank.user.dto.request.UserDto;
import com.bank.user.dto.response.UserResponse;

public interface UserService {
    UserResponse saveUser(UserDto userDto);
}
