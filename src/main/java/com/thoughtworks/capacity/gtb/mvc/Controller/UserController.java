package com.thoughtworks.capacity.gtb.mvc.Controller;

import com.thoughtworks.capacity.gtb.mvc.Dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @PostMapping("/register")
    public ResponseEntity registerUser(@Valid @RequestBody User user){


        return  ResponseEntity.ok().build();
    }
//    @GetMapping("/login?username=foo&password=bar")
//    public ResponseEntity login(@Valid)
}
