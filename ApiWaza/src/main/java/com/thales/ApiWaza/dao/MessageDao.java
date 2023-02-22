package com.thales.ApiWaza.dao;

import com.thales.ApiWaza.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageDao extends JpaRepository<Message, Integer> {
}
