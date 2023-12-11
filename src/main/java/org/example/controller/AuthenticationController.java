package org.example.controller;

import org.example.model.User;
import org.example.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;

@RestController
@CrossOrigin
public class AuthenticationController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/login")
    @ResponseBody
    @CrossOrigin
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        Map<String, Object> object = new HashMap<>();
        if (!userService.createUser(user)) {
            user.setMessage("Bad_request");
            user.setStatus(400);
            object.put("message", user.getMessage());
            object.put("status", user.getStatus());
            return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(object);
        }
        user.setMessage("OK");
        user.setStatus(200);
        object.put("message", user.getMessage());
        object.put("status", user.getStatus());
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(object);
    }

/*let response = await fetch('https://backend-web-service-ovks.onrender.com/login', {
            method: "POST", // *GET, POST, PUT, DELETE, etc.
            mode: "cors", // no-cors, *cors, same-origin
            cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
            credentials: "same-origin", // include, *same-origin, omit
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                username: login,
                password: password
            })
        })*/
}
