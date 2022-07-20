package com.example.UserApp.Service;

import com.example.UserApp.Role;
import com.example.UserApp.Users;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
    Users saveUser(Users user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String name);
    Users getUser(String username);
   List<Users> getUsers();

}
