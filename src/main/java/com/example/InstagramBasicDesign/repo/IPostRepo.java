package com.example.InstagramBasicDesign.repo;

import com.example.InstagramBasicDesign.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface IPostRepo extends JpaRepository<Post,Integer> {
}
