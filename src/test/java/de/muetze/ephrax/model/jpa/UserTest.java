package de.muetze.ephrax.model.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {

	private User user;

	@BeforeEach
	public void setup() {
		user = new User();
	}

	@Test
	public void testSetAndGetPoints() {
		final int points = 100;
		user.setPoints(points);
		assertEquals(points, user.getPoints());
	}

	@Test
	public void testSetAndGetUsername() {
		final String username = "testUser";
		user.setUsername(username);
		assertEquals(username, user.getUsername());
	}
}
