package de.muetze.ephrax.model;

public class Response {
	private final boolean status;
	private final String message;

	public Response(String message, boolean status) {
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public boolean isStatus() {
		return status;
	}

}