package com.thoughtworks.capacity.gtb.mvc.Controller;

import com.thoughtworks.capacity.gtb.mvc.Dto.User;
import com.thoughtworks.capacity.gtb.mvc.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RestController
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestParam(name = "username") @Pattern(regexp = "[0-9A-Za-z_]{3,10}", message = "用户名不合法") String username, @RequestParam(name = "password") @Size(min = 5, max = 12) String password){
        return  ResponseEntity.ok(userService.login(username,password));
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody @Valid User user){
        userService.register(user);
        return ResponseEntity.ok().build();
    }
}
