package javaproject.todo.core.verification;

public interface VerificationService {

	void sendLink(String email);

	String sendCode();

}
