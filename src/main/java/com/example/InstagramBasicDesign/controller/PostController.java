package com.example.InstagramBasicDesign.controller;

import com.example.InstagramBasicDesign.model.Post;
import com.example.InstagramBasicDesign.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    PostService postService;
    @PostMapping("/post")
    public String post(@RequestBody Post post){
        return postService.savePost(post);
    }

    @GetMapping("/post/{id}")
    public Optional<Post> getPost(@PathVariable Integer id){
        return postService.getPost(id);
    }
}
