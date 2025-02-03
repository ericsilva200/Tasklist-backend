package br.com.tasklist.tasklist.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tasklist.tasklist.controller.request.LoginUser;
import br.com.tasklist.tasklist.entity.User;
import br.com.tasklist.tasklist.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping("/")
    public ResponseEntity<User> create(@RequestBody User user){
        userService.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginUser user){
        Boolean login = userService.login(user);

        Map<String, String> response = new HashMap<>();
        response.put("login", Boolean.toString(login) );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    
    }
}
