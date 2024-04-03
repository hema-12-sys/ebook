package com.java.ebook.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.ebook.Model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{}