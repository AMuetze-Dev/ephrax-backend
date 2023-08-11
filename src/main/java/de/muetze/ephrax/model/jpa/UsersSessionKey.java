package de.muetze.ephrax.model.jpa;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UsersSessionKey implements Serializable {

	private static final long serialVersionUID = -4859552035333330747L;

	@Column(name = "user_id")
	Long userId;

	@Column(name = "session_id")
	Long sessionId;

	public Long getSessionId() {
		return sessionId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
