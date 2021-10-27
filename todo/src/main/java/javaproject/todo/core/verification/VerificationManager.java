package javaproject.todo.core.verification;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class VerificationManager implements VerificationService {

	@Override
	public void sendLink(String email) {
		UUID uuId = UUID.randomUUID();
		String verificationLink = "https://javatodoverificationemail/" + uuId.toString();
		System.out.println("Doğrulama bağlantısı şu adrese gönderildi: " + email);
		System.out.println("Hesabınızı doğrulamak için bağlantıya tıklayın: " + verificationLink);
	}

	@Override
	public String sendCode() {
		UUID uuId = UUID.randomUUID();
		String verificationCode = uuId.toString();
		System.out.println("Aktivasyon kodunuz: " + verificationCode);
		return verificationCode;
	}

}
