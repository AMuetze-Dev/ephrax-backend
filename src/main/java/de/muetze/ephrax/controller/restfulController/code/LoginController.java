package de.muetze.ephrax.controller.restfulController.code;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.muetze.ephrax.model.test.LoginAnswer;
import de.muetze.ephrax.model.test.LoginQuestion;

@RestController
public class LoginController {

	@PostMapping("/login")
	public LoginAnswer login(@RequestBody LoginQuestion credentials) {
		final LoginAnswer answer = new LoginAnswer();
		answer.setToken("test123");
		return answer;
	}
}