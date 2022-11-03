package com.bb2.Products_ApiRest.Services.Interfaces;

import com.bb2.Products_ApiRest.DTOs.UserDTO;

import java.util.List;

public interface UserServices {
        List<UserDTO> getAllUsers();
        void save(UserDTO user);
        UserDTO getById(Long id);
        UserDTO deleteById(Long id);
        UserDTO createUser(UserDTO userDTO);
}

