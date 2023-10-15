package com.example.InstagramBasicDesign.controller;

import com.example.InstagramBasicDesign.model.User;
import com.example.InstagramBasicDesign.model.dto.AuthenticationInputDto;
import com.example.InstagramBasicDesign.model.dto.SignInInputDto;
import com.example.InstagramBasicDesign.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    //sign up
    @PostMapping("/user/signUp")
    public String userSignup(@Valid @RequestBody User user){
        return userService.SignUp(user);
    }

    //sign in
    @PostMapping("/user/signIn")
    public String userSignIn(@RequestBody SignInInputDto signInInputDto){
        return userService.SignIn(signInInputDto);
    }

    //sign out
    @DeleteMapping("/user/signOut")
    public String userSignOut(@RequestBody AuthenticationInputDto authInfo){
        return userService.signOut(authInfo);
    }

    @PutMapping("/user/set")
    public String updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
}
