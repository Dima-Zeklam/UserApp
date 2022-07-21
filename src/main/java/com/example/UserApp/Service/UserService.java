package com.example.UserApp.Service;

import com.example.UserApp.model.Role;
import com.example.UserApp.model.Users;

import java.util.List;

public interface UserService {
    Users saveUser(Users user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String name);
    Users getUser(String username);
   List<Users> getUsers();

}
