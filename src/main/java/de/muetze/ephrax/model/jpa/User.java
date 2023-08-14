package de.muetze.ephrax.model.jpa;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

	@ManyToMany
	@JoinTable(name = "users_session", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "session_id"))
	public Set<Session> sessions;

	public User() {
	}

	public User(String username) {
		this.username = username;
		points = 0;
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
