package de.muetze.ephrax.controller.restfulController.code;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.muetze.ephrax.model.test.LoginQuestion;

@RestController
public class LoginController {

	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginQuestion question) {

		return new LoginResponse("test123");
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