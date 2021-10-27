package javaproject.todo.business.abstracts;

import java.util.List;

import javaproject.todo.core.utilities.results.DataResult;
import javaproject.todo.core.utilities.results.Result;
import javaproject.todo.entities.concretes.User;

public interface UserService {

	DataResult<List<User>> getAll();

	Result add(User user);

	DataResult<User> getUserByEmail(String email);

}
