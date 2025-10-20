package com.weatherapiproject.appweather.controller;
import com.weatherapiproject.appweather.model.User;
import com.weatherapiproject.appweather.service.UserService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> allUserList(){

        return userService.allUserList();
    }


    @PostMapping("/create")
    public void createUserC(@RequestBody User user){

        userService.createUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserC(@PathVariable Long id){

        userService.deleteUser(id);
    }

    @PutMapping("/update{id}")
    public void updateUserC(@RequestBody User user, @PathVariable Long id){

        userService.updateUser(id,user);
    }

}
