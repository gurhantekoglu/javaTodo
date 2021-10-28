package javaproject.todo.business.abstracts;

import javaproject.todo.core.utilities.results.Result;
import javaproject.todo.entities.concretes.User;

public interface AuthService {

	Result registerUser(User user, String confirmPassword);

	Result login(User user);

}
