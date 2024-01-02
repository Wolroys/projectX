package com.wolroys.userservice.controller;

import com.wolroys.entitymodule.dto.UserDto;
import com.wolroys.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/list")
    public List<UserDto> getUsers(){
        return userService.findAll();
    }
}
