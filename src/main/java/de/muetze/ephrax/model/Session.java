package de.muetze.ephrax.model;

import java.util.Arrays;

public class Session {

	private int id;
	private String code;
	private User leader;
	private User[] users;

	public void addUser(User user) {
		users = Arrays.copyOf(users, users.length + 1);
		users[users.length - 1] = user;
	}

	public String getCode() {
		return code;
	}

	public int getID() {
		return id;
	}

	public User getLeader() {
		return leader;
	}

	public User[] getUsers() {
		return users;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setID(int id) {
		this.id = id;
	}

	public void setLeader(User leader) {
		this.leader = leader;
	}

	public void setUsers(User... users) {
		this.users = users;
	}
}
