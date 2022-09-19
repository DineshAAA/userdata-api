package com.example.userdata.userdataapi.service;

import com.example.userdata.userdataapi.entity.User;
import com.example.userdata.userdataapi.repository.UserRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


public interface UserService {
    List<User> getAllUsers();

    User saveUser(User user);

    User getUserById(Integer id);

    User updateUser(User user);

    void deleteUser(Integer id);

}
