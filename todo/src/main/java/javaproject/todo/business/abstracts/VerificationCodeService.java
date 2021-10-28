package javaproject.todo.business.abstracts;

import javaproject.todo.core.utilities.results.Result;
import javaproject.todo.entities.concretes.VerificationCode;

public interface VerificationCodeService {

	Result add(VerificationCode code);

}
