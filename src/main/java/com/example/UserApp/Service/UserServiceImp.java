package com.example.UserApp.Service;

import com.example.UserApp.Role;
import com.example.UserApp.User;
import com.example.UserApp.repo.RoleRepository;
import com.example.UserApp.repo.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImp implements UserService  {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public User saveUser(User user) {
       log.info("save user  {} into database",user);
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("save role  {} into database",role);
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String name) {
        log.info("set role {] for the user  {} ",name ,username);
       User user= userRepository.findByUsername(username);
       Role role = roleRepository.findByName(name);
       user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("fetch user  {} from database",username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("fetch all users ");
        return userRepository.findAll();
    }

}
