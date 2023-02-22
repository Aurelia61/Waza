package com.thales.ApiWaza.dao;

import com.thales.ApiWaza.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}
