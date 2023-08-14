package de.muetze.ephrax.model.jpa;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sessions")
public class Session {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String code;

	@ManyToOne
	@JoinColumn(name = "leader")
	private User leader;

	@ManyToMany
	@JoinTable(name = "users_session", joinColumns = @JoinColumn(name = "session_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	public Set<User> users;

	public Session() {
	}

	public Session(User leader, String code) {
		this.code = code;
		this.leader = leader;
	}

	public String getCode() {
		return code;
	}

	public Long getId() {
		return id;
	}

	public User getLeader() {
		return leader;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLeader(User leader) {
		this.leader = leader;
	}
}
