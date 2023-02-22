package com.thales.ApiWaza.controller;

import com.thales.ApiWaza.dao.UserDao;
import com.thales.ApiWaza.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDao userDao;

    // Create a user in database when url is "/user/" ou "/user"
    @PostMapping({"/", ""})
    public User saveUser(@RequestBody User newUser) {
        User savedUser = userDao.save(newUser);
        return savedUser;
    }

    // Get all the user in database when url is "/user/" or "/user"
    @GetMapping({"/", ""})
    public List<User> getUsers(){
        return userDao.findAll();
    }

    // Get one user by his id when url is "/user/<his_id>/" or "/user/<his_id>"
    @GetMapping({"/{searchedId}/", "/{searchedId}"})
    public User getUserById(@PathVariable int searchedId) {
        return userDao.findById(searchedId).get();
    }

    // Delete one user by his id
    @DeleteMapping({"{id}/", "{id}"})
    public void deleteUserById(@PathVariable int id) {
        userDao.deleteById(id);
    }

    // Update a user with his id
    @PutMapping({"{id}/", "{id}"})
    public void updateUser(@PathVariable int id, @RequestBody User modifiedUser){
        User userToUpdate = userDao.findById(id).get();
        userToUpdate.setPseudo(modifiedUser.getPseudo());
        userToUpdate.setFirstName(modifiedUser.getFirstName());
        userToUpdate.setLastName(modifiedUser.getLastName());
        userToUpdate.setStatus(modifiedUser.getStatus());
        userToUpdate.setRole(modifiedUser.getRole());
        userDao.save(userToUpdate);
    }
}
