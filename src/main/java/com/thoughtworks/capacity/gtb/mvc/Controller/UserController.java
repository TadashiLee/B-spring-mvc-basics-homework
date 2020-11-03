package com.thoughtworks.capacity.gtb.mvc.Controller;

import com.thoughtworks.capacity.gtb.mvc.Dto.User;
import com.thoughtworks.capacity.gtb.mvc.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
//    @GetMapping("/login?username=foo&password=bar")
//    public ResponseEntity login(@Valid)
}
