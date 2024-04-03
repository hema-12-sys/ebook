package com.java.ebook.Service;

import com.java.ebook.Model.User;
import com.java.ebook.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(int id) {
        Optional<User> optionalUser = userRepo.findById(id);
        return optionalUser.orElse(null);
    }

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public User updateUser(int id, User newUser) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setEmail(newUser.getEmail());
            existingUser.setName(newUser.getName());
            existingUser.setAge(newUser.getAge());
            return userRepo.save(existingUser);
        } else {
            return null;
        }
    }

    public boolean deleteUser(int id) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            userRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
