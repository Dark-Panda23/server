package org.example.controller;

import org.example.model.User;
import org.example.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthenticationController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/login")
    @CrossOrigin
    public ResponseEntity<?> createUser(@RequestBody User user) {
        if (!userService.createUser(user)) {
            user.setMessage("Bad_request");
            user.setStatus(400);
            return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
        }
        user.setMessage("OK");
        user.setStatus(200);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
