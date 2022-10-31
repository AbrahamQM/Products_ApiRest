package com.bb2.Products_ApiRest.Services.Implementations;

import com.bb2.Products_ApiRest.DTOs.UserDTO;
import com.bb2.Products_ApiRest.Exception.ResourceNotFoundException;
import com.bb2.Products_ApiRest.Mappers.UserMapper;
import com.bb2.Products_ApiRest.Repositories.UserRepository;
import com.bb2.Products_ApiRest.Services.Interfaces.UserServices;
import com.bb2.Products_ApiRest.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//TODO: Hay que hacer que devuelva objetos DTO para mantener "protegidos" los pojos

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> pojos= userRepository.findAll();
        List<UserDTO> dtos = new ArrayList<UserDTO>();
        for (User user : pojos) {
            dtos.add(userMapper.modelToDto(user));
        }
        return dtos;
    }

    @Override
    public void save(UserDTO userDTO) {
        //todo hacer comprobaciones de que los datos not null estan en el userDTO
        userRepository.save(userMapper.dtoToModel(userDTO));
    }

    @Override
    public UserDTO getById(Long id) {
        Optional<User> userOpt = userRepository.findById(id);

        if (userOpt.isPresent()) {
            return userMapper.modelToDto(userOpt.get());
        }
        throw new ResourceNotFoundException("User not found for id " + id);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        return userMapper.modelToDto(userRepository.save(userMapper.dtoToModel(userDTO)));
    }


    @Override
    public UserDTO deleteById(long id) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            userRepository.deleteById(id);
            return userMapper.modelToDto(userOpt.get());
        }
        throw new ResourceNotFoundException("User not found for id " + id);
    }
}
