package javaproject.todo.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaproject.todo.dataAccess.abstracts.UserDao;

@Service
public class UserManager {

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

}
