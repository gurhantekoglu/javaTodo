package javaproject.todo.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaproject.todo.business.abstracts.VerificationCodeService;
import javaproject.todo.core.utilities.results.Result;
import javaproject.todo.core.utilities.results.SuccessResult;
import javaproject.todo.dataAccess.abstracts.VerificationCodeDao;
import javaproject.todo.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService {

	private VerificationCodeDao verificationCodeDao;

	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
	}

	@Override
	public Result add(VerificationCode code) {
		this.verificationCodeDao.save(code);
		return new SuccessResult("Kod kayıt edildi!");
	}

}
