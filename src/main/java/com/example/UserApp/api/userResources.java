package com.example.UserApp.api;

import com.example.UserApp.model.Role;
import com.example.UserApp.Service.UserService;
import com.example.UserApp.model.Users;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class userResources {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<Users>> getUsers() {
        System.out.println("the users::::::::::" + userService.getUsers());

        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<Users> saveUsers(@RequestBody Users user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/role").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }


    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }


}
@Data
class RoleToUserForm{
    private String username;
    private String roleName;
}
//[
//    {
//        "id": 1,
//        "name": "dima",
//        "username": "dima",
//        "password": "123",
//        "roles": [
//            {
//                "id": 1,
//                "name": "Role_User"
//            },
//            {
//                "id": 2,
//                "name": "Role_Manager"
//            }
//        ]
//    },
//    {
//        "id": 2,
//        "name": "john",
//        "username": "john",
//        "password": "123",
//        "roles": [
//            {
//                "id": 1,
//                "name": "Role_User"
//            }
//        ]
//    }
//]