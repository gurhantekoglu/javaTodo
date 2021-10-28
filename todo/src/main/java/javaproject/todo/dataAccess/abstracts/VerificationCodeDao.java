package javaproject.todo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javaproject.todo.entities.concretes.VerificationCode;

public interface VerificationCodeDao extends JpaRepository<VerificationCode, Integer> {

	VerificationCode getById(int id);

}
