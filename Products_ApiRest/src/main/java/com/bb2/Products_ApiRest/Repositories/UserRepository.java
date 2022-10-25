package com.bb2.Products_ApiRest.Repositories;

import com.bb2.Products_ApiRest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
