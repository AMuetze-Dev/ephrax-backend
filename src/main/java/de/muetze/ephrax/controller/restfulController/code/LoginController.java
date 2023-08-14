package de.muetze.ephrax.controller.restfulController.code;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginQuestion question) {

		return new LoginResponse("test123");
	}
}

class LoginQuestion {

	private String username;
	private String password;

	LoginQuestion() {
	}

	LoginQuestion(String username, String password) {
		this.username = username;
		this.password = password;
	}

	String getPassword() {
		return password;
	}

	String getUsername() {
		return username;
	}

	void setPassword(String password) {
		this.password = password;
	}

	void setUsername(String username) {
		this.username = username;
	}

}

class LoginResponse {

	private String answer;

	LoginResponse() {
	}

	LoginResponse(String answer) {
		this.answer = answer;
	}

	String getAnswer() {
		return answer;
	}

	void setAnswer(String answer) {
		this.answer = answer;
	}
}