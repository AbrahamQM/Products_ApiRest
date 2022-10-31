package com.bb2.Products_ApiRest.Services.Implementations;

import com.bb2.Products_ApiRest.DTOs.UserDTO;
import com.bb2.Products_ApiRest.Mappers.UserMapper;
import com.bb2.Products_ApiRest.Repositories.UserRepository;
import com.bb2.Products_ApiRest.Services.Interfaces.UserServices;
import com.bb2.Products_ApiRest.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
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
    public UserDTO getById(Long id) { //TODO hacer que devuelva UserDTO en lugar de user
        Optional<User> userOpt = userRepository.findById(id);
        User user = null;
        if (userOpt.isPresent()) {
            user = userOpt.get();
        }else{
            throw new RuntimeException("User not found for id " + id);
        }
        return null; //TODO***************************************************OJO
    }

    @Override
    public void deleteViaId(long id) { //TODO******** mal implementado, volver a implementar con comprobaciones mejores
        if (userRepository.findById(id) != null) {
            Optional user = userRepository.findById(id);
            //BORRAR si corresponde el usuario
        }else{
            throw new RuntimeException("User not found for id " + id);
        }
    }
}
