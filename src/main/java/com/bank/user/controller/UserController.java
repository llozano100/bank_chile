package com.bank.user.controller;

import com.bank.user.dto.request.UserDto;
import com.bank.user.dto.response.UserResponse;
import com.bank.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "This method is used to create a new user")
    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto){

        UserResponse userResponse = userService.saveUser(userDto);
        HttpStatus httpStatus = null;
        if(Optional.ofNullable(userResponse.getMessage()).isEmpty()){
            httpStatus = HttpStatus.OK;

        }else{
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return ResponseEntity.status(httpStatus).body(userResponse);
    }
}
