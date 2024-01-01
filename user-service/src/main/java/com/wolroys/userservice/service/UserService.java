package com.wolroys.userservice.service;

import com.wolroys.entitymodule.dto.UserDto;
import com.wolroys.entitymodule.mapper.UserMapper;
import com.wolroys.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> findAll(){
        return userRepository.findAll()
                .stream().map(user -> userMapper.mapToDtoOrEntity(user, UserDto.class))
                .toList();
    }
}
