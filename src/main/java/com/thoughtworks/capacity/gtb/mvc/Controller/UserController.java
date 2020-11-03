package com.thoughtworks.capacity.gtb.mvc.Controller;

import com.thoughtworks.capacity.gtb.mvc.Dto.User;
import com.thoughtworks.capacity.gtb.mvc.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password){
        return  ResponseEntity.ok(userService.login(username,password));
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody @Valid User user){
        userService.register(user);
        return ResponseEntity.ok().build();
    }
}
