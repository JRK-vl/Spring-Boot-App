package com.SpringBootApp.controller;

import com.SpringBootApp.dto.UserDTO;
import com.SpringBootApp.entity.User;
import com.SpringBootApp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> readAll() {
        return new ResponseEntity<>(userService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> readById(@PathVariable Long id){
        return new ResponseEntity<>(userService.readById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDTO dto){
        return new ResponseEntity<>(userService.create(dto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user){
        return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id){
        userService.delete(id);
        return HttpStatus.OK;
    }
}
