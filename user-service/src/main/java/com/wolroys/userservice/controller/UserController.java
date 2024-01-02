package com.wolroys.userservice.controller;

import com.wolroys.entitymodule.dto.UserDto;
import com.wolroys.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/list")
    public List<UserDto> getUsers(){
        return userService.findAll();
    }

    @PostMapping("/profile")
    public UserDto getUser(@RequestBody Long id){
        return userService.findUser(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PatchMapping("/edit/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto userDto){
        return userService.updateUser(id, userDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@RequestBody Long id){
        if (!userService.deleteUser(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
