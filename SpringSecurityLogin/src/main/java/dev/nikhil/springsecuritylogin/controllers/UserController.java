package dev.nikhil.springsecuritylogin.controllers;

import dev.nikhil.springsecuritylogin.models.Users;
import dev.nikhil.springsecuritylogin.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("hello")
    public String hello(){
        return "Hello, World!";
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrf(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("/users")
    public List<Users> getUsers(){
        return service.allUsers();
    }

    @PostMapping("/addUser")
    public Users addUser(@RequestBody Users user){
        return service.addUser(user);
    }
}
