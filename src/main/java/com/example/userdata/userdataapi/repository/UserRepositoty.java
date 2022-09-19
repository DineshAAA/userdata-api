package com.example.userdata.userdataapi.repository;

import com.example.userdata.userdataapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoty extends JpaRepository<User,Integer> {
}
