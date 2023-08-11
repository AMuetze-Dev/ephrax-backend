package de.muetze.ephrax.controller.restfulController;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.muetze.ephrax.controller.LoggerService;
import de.muetze.ephrax.controller.templates.SessionTemplateImpl;
import de.muetze.ephrax.controller.templates.JDBCDriverConnection;
import de.muetze.ephrax.model.Session;
import de.muetze.ephrax.model.Response;
import de.muetze.ephrax.model.UpdateObject;

@RestController
@RequestMapping("/code")
public class CodeController extends SessionTemplateImpl {

	@GetMapping("/create={code}")
	public Response createRoom(@PathVariable String code) {
		final Session session = new Session();
		session.setGameCode(code.toUpperCase());
		try {
			new JDBCDriverConnection(TABLE).executeAdd(session.convertToUpdateObjectArray());
			return new Response("Anlegen eines Spiel war erfolgreich", true);
		} catch (final SQLException e) {
			e.printStackTrace();
			LoggerService.severe(Arrays.toString(e.getStackTrace()));
			return new Response("Anlegen eines Spiels ist fehlgeschlagen", false);
		}
	}

	@GetMapping("/generate")
	public String generateCode() {
		final String code = new Random().ints(8, 0, 36)
				.mapToObj(i -> Character.toString(i < 10 ? '0' + i : 'A' + i - 10)).collect(Collectors.joining())
				.toUpperCase();
		return proofCode(code) ? generateCode() : code;
	}

	@GetMapping("/proof={code}")
	public boolean proofCode(@PathVariable String code) {
		try {
			return JDBCDriverConnection
					.executeQuery("SELECT * FROM sessions WHERE code = '" + code.toUpperCase() + "';", resultSet)
					.size() > 0;
		} catch (final SQLException e) {
			e.printStackTrace();
			LoggerService.severe(Arrays.toString(e.getStackTrace()));
			return false;
		}
	}

	@PostMapping("/register")
	public Response register(@RequestBody String username) {
		try {
			new JDBCDriverConnection("users").executeAdd(new UpdateObject<>("username", username));
			return new Response("Spieler wurde dem Spiel hinzugefügt", true);
		} catch (final SQLException e) {
			e.printStackTrace();
			LoggerService.severe(Arrays.toString(e.getStackTrace()));
			return new Response("Spieler konnte niceht hinzugefügt werden", false);
		}
	}

}
