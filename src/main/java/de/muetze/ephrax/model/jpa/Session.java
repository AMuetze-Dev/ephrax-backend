package de.muetze.ephrax.model.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
