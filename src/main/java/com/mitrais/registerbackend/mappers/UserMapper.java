package com.mitrais.registerbackend.mappers;

import com.mitrais.registerbackend.dtos.UserDTO;
import com.mitrais.registerbackend.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper
{
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDto(User user);

    User userDtoToUser(UserDTO dto);
}
