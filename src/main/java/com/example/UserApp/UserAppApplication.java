package com.example.UserApp;

import com.example.UserApp.Service.UserService;
import com.example.UserApp.model.Role;
import com.example.UserApp.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@SpringBootApplication
public class UserAppApplication {


	public static void main(String[] args) {

		SpringApplication.run(UserAppApplication.class, args);



	}

//	@Bean
//	CommandLineRunner run(UserService userService){
//		return args -> {
//			userService.saveRole(new Role(null,"Role_User"));
//			userService.saveRole(new Role(null,"Role_Manager"));
//			userService.saveRole(new Role(null,"Role_Admin"));
//
//			userService.saveUser(new Users(null,"dima","dima","123",new ArrayList<>()));
//			userService.saveUser(new Users(null,"john","john","123",new ArrayList<>()));
//
//			userService.addRoleToUser("dima","Role_User");
//			userService.addRoleToUser("dima","Role_Manager");
//			userService.addRoleToUser("john","Role_User");
//		};
//	}



	@Component
	class DemoCommandLineRunner implements CommandLineRunner{
	@Autowired
	PasswordEncoder passwordEncoder;


		@Autowired
		UserService userService;
//
//
		@Override
		public void run(String... args) throws Exception {
//			String password = "123";
//			String encodedPassword = passwordEncoder.encode(password);
//			System.out.println();
//			System.out.println("Password is         : " + password);
//			System.out.println("Encoded Password is : " + encodedPassword);

//			userService.saveRole(new Role(null,"Role_User"));
//			userService.saveRole(new Role(null,"Role_Manager"));
//			userService.saveRole(new Role(null,"Role_Admin"));
//
//			userService.saveUser(new Users(null,"dima","dima","123",new ArrayList<>()));
//			userService.saveUser(new Users(null,"john","john","123",new ArrayList<>()));
////
//			userService.addRoleToUser("dima","Role_User");
//			userService.addRoleToUser("dima","Role_Manager");
//			userService.addRoleToUser("john","Role_User");
			System.out.println("the users::::::::::" + userService.getUsers());

		}
	}

}
