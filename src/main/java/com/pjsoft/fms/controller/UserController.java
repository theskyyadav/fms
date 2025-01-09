package com.pjsoft.fms.controller;

import com.pjsoft.fms.pojo.auth.dto.AuthRequest;
import com.pjsoft.fms.pojo.auth.dto.AuthResponse;
import com.pjsoft.fms.pojo.auth.dto.UserRequest;
import com.pjsoft.fms.pojo.auth.dto.UserResponse;
import com.pjsoft.fms.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/user")
public
class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {

        super();

        this.userService = userService;

    }

    @PostMapping("/register")

    public
    ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {

        logger.info("User creating");

        UserResponse userResponse = userService.createUser(userRequest);

        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);

    }
    @PostMapping(path = "/login")
    public
    ResponseEntity<AuthResponse> userLogin(@RequestBody AuthRequest authRequest) throws Exception {

        logger.info("User Sign in");

        AuthResponse authResponse = userService.userLogin(authRequest);

        return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);

    }

    @GetMapping(path = "/allusers")
    public  ResponseEntity<List<UserResponse>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }

}
