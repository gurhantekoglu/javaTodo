package javaproject.todo.business.concretes;

import org.springframework.stereotype.Service;

import javaproject.todo.business.abstracts.AuthService;
import javaproject.todo.business.abstracts.UserService;
import javaproject.todo.business.abstracts.VerificationCodeService;
import javaproject.todo.core.utilities.results.ErrorResult;
import javaproject.todo.core.utilities.results.Result;
import javaproject.todo.core.utilities.results.SuccessResult;
import javaproject.todo.core.verification.VerificationService;
import javaproject.todo.entities.concretes.User;
import javaproject.todo.entities.concretes.VerificationCode;

@Service
public class AuthManager implements AuthService {

	private UserService userService;
	private VerificationCodeService verificationCodeService;
	private VerificationService verificationService;

	public AuthManager(UserService userService, VerificationCodeService verificationCodeService,
			VerificationService verificationService) {
		super();
		this.userService = userService;
		this.verificationCodeService = verificationCodeService;
		this.verificationService = verificationService;
	}

	@Override
	public Result registerUser(User user, String confirmPassword) {
		if (!checkIfNullInfoForUser(user, confirmPassword)) {
			return new ErrorResult("Eksik bilgi girdiniz. Lütfen kontrol ediniz!");
		}

		if (!checkIfEmailExists(user.getEmail())) {
			return new ErrorResult(user.getEmail() + " zaten var!");
		}

		if (!checkIfEqualPasswordAndConfirmPassword(user.getPassword(), confirmPassword)) {
			return new ErrorResult("Parolalar uyuşmuyor!");
		}

		userService.add(user);
		String code = verificationService.sendCode();
		verificationCodeIsGenerated(code, user.getId(), user.getEmail());
		return new SuccessResult("Kayıt başarılı!");
	}

	private boolean checkIfNullInfoForUser(User user, String confirmPassword) {

		if (user.getEmail() != null && user.getPassword() != null && confirmPassword != null) {
			return true;
		}

		return false;
	}

	private boolean checkIfEmailExists(String email) {

		if (this.userService.getUserByEmail(email).getData() == null) {
			return true;
		}

		return false;
	}

	private boolean checkIfEqualPasswordAndConfirmPassword(String password, String confirmPassword) {

		if (!password.equals(confirmPassword)) {
			return false;
		}

		return true;
	}

	public void verificationCodeIsGenerated(String code, int id, String email) {

		VerificationCode verificationCode = new VerificationCode(id, id, null, false, false, code);
		this.verificationCodeService.add(verificationCode);
		System.out.println("Doğrulama kodu şu e-posta adresine gönderildi: " + email);

	}

	@Override
	public Result login(User user) {
		return new SuccessResult("Kullanıcı girişi başarılı.");
	}

}
