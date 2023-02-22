package com.thales.ApiWaza.controller;

import com.thales.ApiWaza.dao.ChatRoomDao;
import com.thales.ApiWaza.model.ChatRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chatrooms")
public class ChatRoomController {

    @Autowired
    ChatRoomDao chatRoomDao;

    @PostMapping({"/", ""})
    public ChatRoom saveChatRoom(@RequestBody ChatRoom newChatRoom){
        return chatRoomDao.save(newChatRoom);
    }

    @GetMapping({"/", ""})
    public List<ChatRoom> getChatRooms(){ return chatRoomDao.findAll();}

    @GetMapping({"/{id}/", "/{id}"})
    public ChatRoom getChatRoomById(@PathVariable int id) {
        return chatRoomDao.findById(id).get();
    }

    @DeleteMapping({"/{id}/", "/{id}"})
    public void deleteChatRoomById(@PathVariable int id){chatRoomDao.deleteById(id);}

    @PutMapping({"/{id}/", "/{id}"})
    public void updateChatRoom(@PathVariable int id, @RequestBody ChatRoom modifiedChatRoom){
        ChatRoom chatRoomToUpdate = chatRoomDao.findById(id).get();
        chatRoomToUpdate.setName(modifiedChatRoom.getName());
        chatRoomToUpdate.setUsers(modifiedChatRoom.getUsers());
        chatRoomDao.save(chatRoomToUpdate);
    }

}
