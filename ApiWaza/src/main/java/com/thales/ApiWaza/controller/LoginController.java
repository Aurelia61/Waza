package com.thales.ApiWaza.controller;

import com.thales.ApiWaza.dao.LoginDao;
import com.thales.ApiWaza.dao.UserDao;
import com.thales.ApiWaza.model.Login;
import com.thales.ApiWaza.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logins")
public class LoginController {

    @Autowired
    private LoginDao loginDao;

    @PostMapping({"/", ""})
    public Login saveLogin(@RequestBody Login newLogin) {
        return loginDao.save(newLogin);
    }

    @GetMapping({"/", ""})
    public List<Login> getLogins(){
        return loginDao.findAll();
    }

    @GetMapping({"conn/{searchedMail}/", "/conn/{searchedMail}"})
    public Login getLoginByMail(@PathVariable String searchedMail) {
        return loginDao.findByMail(searchedMail);
    }

    @DeleteMapping({"/{searchedMail}/", "/{searchedMail}"})
    public void deleteUserByMail(@PathVariable String searchedMail) {
        loginDao.deleteByMail(searchedMail);
    }

    @PutMapping({"/{searchedMail}/", "/{searchedMail}"})
    public void updateLogin(@PathVariable String searchedMail, @RequestBody Login modifiedLogin){
        Login loginToUpdate = loginDao.findByMail(searchedMail);
        loginToUpdate.setMail(modifiedLogin.getMail());
        loginToUpdate.setPassword(modifiedLogin.getPassword());
        loginDao.save(loginToUpdate);
    }

}
