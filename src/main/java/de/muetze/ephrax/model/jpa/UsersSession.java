package de.muetze.ephrax.model.jpa;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class UsersSession {

	@EmbeddedId
	UsersSessionKey id;

	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@MapsId("sessionId")
	@JoinColumn(name = "session_id")
	private Session session;

	public Session getSession() {
		return session;
	}

	public User getUser() {
		return user;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public void setUser(User user) {
		this.user = user;
	}

}