package com.thales.ApiWaza.controller;

import com.thales.ApiWaza.dao.MessageDao;
import com.thales.ApiWaza.model.Message;
import com.thales.ApiWaza.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageDao messageDao;

    @PutMapping({"", "/"})
    public Message saveMessage(@RequestBody Message newMessage){
        Message savedMessage = messageDao.save(newMessage);
        return savedMessage;
    }

    @GetMapping({"","/"})
    public List<Message> getMessages(){return messageDao.findAll();    }

    @GetMapping({"/{searchedId}/", "/{searchedId}"})
    public Message getMessageById(@PathVariable int searchedId){return messageDao.findById(searchedId).get();}

    @DeleteMapping({"/{searchedId}/", "/{searchedId}"})
    void deleteMessageById(@PathVariable int searchedId){
        messageDao.deleteById(searchedId);
    }

    //todo edit and modify a message => not needed for now
//    @PutMapping({"/{searchedId}/", "/{searchedId}"})
//    public void updateMessage(@PathVariable int searchedId, @RequestBody Message modifiedMessage){
//        Message messageToUpdate = messageDao.findById(searchedId).get();
//        messageToUpdate.setContent(modifiedMessage.getContent());
//        messageDao.save(messageToUpdate);
//    }

}
