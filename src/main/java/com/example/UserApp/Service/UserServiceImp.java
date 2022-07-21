package com.example.UserApp.Service;

import com.example.UserApp.model.Role;
import com.example.UserApp.model.Users;
import com.example.UserApp.repo.RoleRepository;
import com.example.UserApp.repo.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImp implements UserService, UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);
        if(user == null){
            log.error("user not found in the database");
            throw new UsernameNotFoundException("user not found in the database");
        }else {
            log.info("user found in the database: {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }

    @Override
    public Users saveUser(Users user) {
       log.info("save user  {} into database",user);
       user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("save role  {} into database",role);
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String RoleName) {
        log.info("set role {] for the user  {} ",RoleName ,username);
       Users user= userRepository.findByUsername(username);
       Role role = roleRepository.findByName(RoleName);
       user.getRoles().add(role);
    }

    @Override
    public Users getUser(String username) {
        log.info("fetch user  {} from database",username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<Users> getUsers() {
        log.info("fetch all users ");
        return userRepository.findAll();
    }


}
