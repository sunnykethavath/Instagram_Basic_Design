package com.example.InstagramBasicDesign.repo;

import com.example.InstagramBasicDesign.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Integer> {

    User findFirstByEmail(String email);
}
