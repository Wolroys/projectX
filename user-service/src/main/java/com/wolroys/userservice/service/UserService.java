package com.wolroys.userservice.service;

import com.wolroys.entitymodule.dto.UserDto;
import com.wolroys.entitymodule.mapper.UserMapper;
import com.wolroys.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> findAll(){
        return userRepository.findAll()
                .stream().map(user -> userMapper.mapToDtoOrEntity(user, UserDto.class))
                .toList();
    }

    public Optional<UserDto> findUser(Long id){
        return userRepository.findById(id)
                .map(user -> userMapper.mapToDtoOrEntity(user, UserDto.class));
    }

    @Transactional
    public Optional<UserDto> updateUser(Long id, UserDto updatedUser){
        return userRepository.findById(id)
                .map(user -> userMapper.update(updatedUser, user))
                .map(userRepository::saveAndFlush)
                .map(user -> userMapper.mapToDtoOrEntity(user, UserDto.class));
    }

    @Transactional
    public boolean deleteUser(Long id){
        return userRepository.findById(id)
                .map(user -> {
                    userRepository.delete(user);
                    userRepository.flush();
                    return true;
                }).orElse(false);
    }
}
