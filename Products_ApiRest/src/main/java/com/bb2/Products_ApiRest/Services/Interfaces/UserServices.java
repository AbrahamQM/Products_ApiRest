package com.bb2.Products_ApiRest.Services.Interfaces;

import com.bb2.Products_ApiRest.models.User;

import java.util.List;

public interface UserServices {
        List<User> getAllUsers();
        void save(User user);
        User getById(Long id);
        void deleteViaId(long id);
}

