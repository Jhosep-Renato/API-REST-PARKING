package com.japrova.appparking.dao;

import com.japrova.appparking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
}
