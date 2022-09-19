package com.example.userdata.userdataapi.service;

import com.example.userdata.userdataapi.entity.User;
import com.example.userdata.userdataapi.repository.UserRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepositoty userRepositoty;

    public UserServiceImpl(UserRepositoty userRepositoty) {
        this.userRepositoty = userRepositoty;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepositoty.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepositoty.save(user);
    }

    @Override
    public User getUserById(Integer id) {
         return userRepositoty.findById(id).get();
    }

    @Override
    public User updateUser(User user) {
        return userRepositoty.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepositoty.deleteById(id);
    }
}
