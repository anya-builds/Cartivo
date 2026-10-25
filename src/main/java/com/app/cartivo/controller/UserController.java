package com.app.cartivo.controller;

import com.app.cartivo.model.User;
import com.app.cartivo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
//    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers(){

        return new ResponseEntity<>(userService.fetchAllUsers(), HttpStatus
                .OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        return userService.fetchUser(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user){
        userService.addUser(user);
        return ResponseEntity.ok("User Added Successfully");
    }
@PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User updateUser){
        boolean updated = userService.updateUser(id, updateUser);
        if(updated)
            return ResponseEntity.ok("User updated successfully");
        return ResponseEntity.notFound().build();
}
}
