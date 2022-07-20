package com.example.UserApp.repo;

import com.example.UserApp.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
        Role findByName(String name);
}