package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {

    private final UserDaoService service;
    public UserResource(UserDaoService service) {
        this.service = service;
    }

    //GET users
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveAUser(@PathVariable int id) {
        return service.find(id);
    }
}
