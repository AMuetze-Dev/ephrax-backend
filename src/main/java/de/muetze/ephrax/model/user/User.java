package de.muetze.ephrax.model.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String username;
	private int points;

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
