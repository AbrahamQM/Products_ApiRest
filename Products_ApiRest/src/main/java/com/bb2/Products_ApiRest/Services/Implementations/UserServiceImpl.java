package com.bb2.Products_ApiRest.Services.Implementations;

import com.bb2.Products_ApiRest.Repositories.UserRepository;
import com.bb2.Products_ApiRest.Services.Interfaces.UserServices;
import com.bb2.Products_ApiRest.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        Optional<User> userOpt = userRepository.findById(id);
        User user = null;
        if (userOpt.isPresent()) {
            user = userOpt.get();
        }else{
            throw new RuntimeException("User not found for id " + id);
        }
        return user;
    }

    @Override
    public void deleteViaId(long id) {
        if (userRepository.findById(id) != null) {
            userRepository.findById(id);
        }else{
            throw new RuntimeException("User not found for id " + id);
        }
    }
}
