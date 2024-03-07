package com.esun.library.controller;

import com.esun.library.repository.entity.User;
import com.esun.library.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody User user) {
        try {
            boolean succeed = userService.register(user);
            if (succeed) {
                return new ResponseEntity<>("Register successfully", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Register failed", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody User user) {
        try {
            boolean succeed = userService.login(user);
            if (succeed) {
                return new ResponseEntity<>("Login successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Login failed", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
