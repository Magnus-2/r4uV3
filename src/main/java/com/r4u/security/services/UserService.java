package com.r4u.security.services;

import com.r4u.security.models.User;
import com.r4u.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * The User Service specialise the functions
 * which you can use to get Data for example
 */
@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    //Get All Users
    public List<User> findAll() {
        return userRepository.findAll();
    }

    //Get User By Id
    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }


    //Delete User
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    //Update User
    public void save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }

}
