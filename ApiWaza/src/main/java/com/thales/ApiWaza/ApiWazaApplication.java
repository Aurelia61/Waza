package com.thales.ApiWaza;

import com.thales.ApiWaza.dao.ChatRoomDao;
import com.thales.ApiWaza.dao.LoginDao;
import com.thales.ApiWaza.dao.MessageDao;
import com.thales.ApiWaza.dao.UserDao;
import com.thales.ApiWaza.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class ApiWazaApplication implements CommandLineRunner {
	@Autowired
	UserDao userDao;

	@Autowired
	LoginDao loginDao;

	@Autowired
	MessageDao messageDao;
	@Autowired
	ChatRoomDao chatRoomDao;

	public static void main(String[] args) {
		SpringApplication.run(ApiWazaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Create several users
		User user1 = new User("Auré", "Aurélia", "Thomas", UserStatus.ACTIVE, UserRole.ADMIN);
		User user2 = new User("Alexandre");

		// Create several logins
		Login loginUser1 = new Login("a", "a");
		Login loginUser2 = new Login("admin2", "admin2");

		// Associate each user with his login
		loginUser1.setUser(user1);
		loginUser2.setUser(user2);

		// Create several messages
		Message mess1 = new Message(user1, new String("Bonjour message1").getBytes(StandardCharsets.UTF_8));
		Message mess2 = new Message(user1,new String("message2").getBytes(StandardCharsets.UTF_8));
		Message mess3 = new Message(user2, new String("message3").getBytes(StandardCharsets.UTF_8));

		// Associate each message to user who send it
		mess1.setFromUser(user1);
		mess2.setFromUser(user2);
		mess3.setFromUser(user1);

		// Create several chatrooms
		ChatRoom chatRoom1 = new ChatRoom("groupe 1");
		ChatRoom chatRoom2 = new ChatRoom("groupe 2");
		ChatRoom chatRoom3 = new ChatRoom("groupe 3");

		// Associate a message to the chatroom destination
		mess1.setToChatRoom(chatRoom1);
		mess2.setToChatRoom(chatRoom1);
		mess3.setToChatRoom(chatRoom1);

		// Save users in db
		userDao.save(user1);
		userDao.save(user2);

		// save logins in db
		loginDao.save(loginUser1);
		loginDao.save(loginUser2);

		// save chatrooms in db
		chatRoomDao.save(chatRoom1);
		chatRoomDao.save(chatRoom2);
		chatRoomDao.save(chatRoom3);

		// save messages in db
		messageDao.save(mess1);
		messageDao.save(mess2);
		messageDao.save(mess3);

	}
}
