package edu.unimagdalena.web.try1.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.unimagdalena.web.try1.dto.User;

@RestController
public class UserController {

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
    List<User> users = new ArrayList<>();
    Collections.addAll(users, new User(1,"David", 12), new User(2,"John", 39));
    return new ResponseEntity<>(users, HttpStatus.CREATED);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User usuario){
        usuario.setId(3);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    
}

