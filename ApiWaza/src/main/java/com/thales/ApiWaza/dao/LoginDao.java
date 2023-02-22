package com.thales.ApiWaza.dao;

import com.thales.ApiWaza.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface LoginDao extends JpaRepository<Login, String> {

    @Query("SELECT l FROM Login l WHERE l.mail=:searchedMail")
    Login findByMail(String searchedMail);

    @Transactional
    @Modifying
    @Query("DELETE FROM Login l WHERE l.mail=:searchedMail")
    void deleteByMail(@Param("searchedMail") String searchedMail);
}
