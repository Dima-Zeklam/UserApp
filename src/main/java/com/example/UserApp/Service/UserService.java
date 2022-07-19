package com.example.UserApp.Service;

import com.example.UserApp.Role;
import com.example.UserApp.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String name);
    User getUser(String username);
    List<User> getUsers();

}
