package javaproject.todo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaproject.todo.business.abstracts.UserService;
import javaproject.todo.core.utilities.results.DataResult;
import javaproject.todo.core.utilities.results.Result;
import javaproject.todo.core.utilities.results.SuccessDataResult;
import javaproject.todo.core.utilities.results.SuccessResult;
import javaproject.todo.dataAccess.abstracts.UserDao;
import javaproject.todo.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(userDao.findAll());
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı eklendi!");
	}

	@Override
	public DataResult<User> getUserByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findUserByEmail(email));
	}

}
