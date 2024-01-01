package com.wolroys.entitymodule.mapper;

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
}
