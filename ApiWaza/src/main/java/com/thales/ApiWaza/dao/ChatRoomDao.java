package com.thales.ApiWaza.dao;

import com.thales.ApiWaza.model.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomDao extends JpaRepository<ChatRoom, Integer> {
}
