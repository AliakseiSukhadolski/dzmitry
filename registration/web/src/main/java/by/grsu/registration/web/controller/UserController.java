package by.grsu.registration.web.controller;

import by.grsu.registration.dao.UserDao;
import by.grsu.registration.model.User;

public class UserController {
	
	private UserDao userDao;
	
	public UserController(){
		userDao = new UserDao();
	}
	
	public User getUser(String email, String password){
		return userDao.getUser(email, password);
	}

}
