package de.muetze.ephrax.model.user;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2730655170426222792L;

	public UserNotFoundException(String exception) {
		super(exception);
	}
}
