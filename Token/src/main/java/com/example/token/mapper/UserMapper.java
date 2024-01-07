package com.example.token.mapper;

import com.example.token.dto.UserDto;
import com.example.token.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Mapper(
        componentModel = "spring"
)
public abstract class UserMapper {
    @Autowired
    public BCryptPasswordEncoder encoder;

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "phoneNumber", source = "phoneNumber"),
            @Mapping(target = "role", defaultValue = "ROLE_USER"),
            @Mapping(target = "password", expression = "java(encodePassword(dto))")
    })
    public abstract UserEntity toEntity (UserDto dto);


    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "phoneNumber", source = "phoneNumber"),
            @Mapping(target = "role", source = "role"),
    })
    public abstract UserDto toDto (UserEntity entity);

    public String encodePassword(UserDto dto){
        return encoder.encode(dto.getPassword());
    }
}
