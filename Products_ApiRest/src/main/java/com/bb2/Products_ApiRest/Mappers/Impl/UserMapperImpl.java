package com.bb2.Products_ApiRest.Mappers.Impl;

import com.bb2.Products_ApiRest.DTOs.UserDTO;
import com.bb2.Products_ApiRest.Mappers.UserMapper;
import com.bb2.Products_ApiRest.models.User;

public class UserMapperImpl implements UserMapper {
    @Override
    public User dtoToModel(UserDTO userDTO) {
        if(userDTO == null){
            return null;
        }
        User user = new User();
        user.setIdUser (userDTO.getIdUser());
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        return user;
    }

    @Override
    public UserDTO modelToDto(User user) {
        if(user == null){
            return null;
        }
        UserDTO dto = new UserDTO();
        dto.setIdUser(user.getIdUser());
        dto.setUserName(user.getUserName());
        dto.setPassword(user.getPassword());
        dto.setRole(user.getRole());
        return dto;
    }

    @Override
    public void updateModel(UserDTO userDto, User user) {

    }
}
