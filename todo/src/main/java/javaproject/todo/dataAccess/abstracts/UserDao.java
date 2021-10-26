package javaproject.todo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javaproject.todo.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {

	User findUserByEmail(String email);

	User getById(int id);

}
