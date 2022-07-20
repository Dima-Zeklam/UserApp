package com.example.UserApp.repo;

import com.example.UserApp.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByUsername(String username);
}
