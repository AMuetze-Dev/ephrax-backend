package de.muetze.ephrax.model;

import java.util.Date;

public class ChatMessage {

	private String message;
	private Date date;
	private String author;

	public String getAuthor() {
		return author;
	}

	public Date getDate() {
		return date;
	}

	public String getMessage() {
		return message;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
