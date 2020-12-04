package com.academiavivere.semana3.controllers;

import com.academiavivere.semana3.models.Login;
import com.academiavivere.semana3.models.User;
import com.academiavivere.semana3.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable(value = "id") int userId)  {
        return ResponseEntity.ok().body(userService.getById(userId));
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) throws Exception {
        {
            return ResponseEntity.status(201).body(userService.createUser(user));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable(value = "id") int id, @RequestBody User user){
        return ResponseEntity.ok().body(userService.updateUser(user, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id")int id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<User>> findByFilter(@RequestParam(value = "name", required = false) String name,
                        @RequestParam(value = "email", required = false) String email) {
        if(name != null && email != null){
            return ResponseEntity.ok().body(userService.getByNameAndEmail(name,email));
        }else if(name != null){
            return ResponseEntity.ok().body(userService.getByName(name));
        }else if (email != null){
            return ResponseEntity.ok().body(userService.getByEmail(email));
        }else{
            return ResponseEntity.ok().body(userService.getAll());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String > logon(@RequestBody Login login){
        return ResponseEntity.ok().body(userService.getByLogin(login.getUser(), login.getPassword()));
    }
}
