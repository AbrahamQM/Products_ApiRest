package com.bb2.Products_ApiRest.Mappers;

import com.bb2.Products_ApiRest.DTOs.UserDTO;
import com.bb2.Products_ApiRest.models.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface UserMapper {

    //assemblers
    User dtoToModel(UserDTO userDTO);
    UserDTO modelToDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModel(UserDTO userDto, @MappingTarget User user);
}
