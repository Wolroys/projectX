package com.wolroys.entitymodule.mapper;

import com.wolroys.entitymodule.dto.UserDto;
import com.wolroys.entitymodule.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserMapper {

    private final ModelMapper mapper;

    public <T, R> R mapToDtoOrEntity(T source, Class<R> destinationClass){
        return source == null ? null : mapper.map(source, destinationClass);
    }

    public User update(UserDto source, User destination){
        mapper.map(source, destination);
        return destination;
    }
}
