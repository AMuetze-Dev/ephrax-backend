package de.muetze.ephrax.model.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private int points;

	public User() {
	}

	public User(Long id, String username, int points) {
		this.id = id;
		this.username = username;
		this.points = points;
	}

	public Long getId() {
		return id;
	}

	public int getPoints() {
		return points;
	}

	public String getUsername() {
		return username;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
