package de.muetze.ephrax.model.test;

public class LoginQuestion {

	private String username;
	private String password;

	public LoginQuestion() {
	}

	public LoginQuestion(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
