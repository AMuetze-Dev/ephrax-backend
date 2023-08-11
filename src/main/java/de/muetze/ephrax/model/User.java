package de.muetze.ephrax.model;

public class User {

	private int id;
	private String username;
	private int points;

	public int getID() {
		return id;
	}

	public int getPoints() {
		return points;
	}

	public String getUsername() {
		return username;
	}

	public void setID(int id) {
		this.id = id;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
