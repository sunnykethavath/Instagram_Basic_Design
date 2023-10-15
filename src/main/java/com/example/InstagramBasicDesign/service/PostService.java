package com.example.InstagramBasicDesign.service;

import com.example.InstagramBasicDesign.model.Post;
import com.example.InstagramBasicDesign.repo.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    IPostRepo postRepo;
    public String savePost(Post post) {
        postRepo.save(post);
        return "upload successful";
    }


    public Optional<Post> getPost(Integer id) {
        return postRepo.findById(id);
    }
}
