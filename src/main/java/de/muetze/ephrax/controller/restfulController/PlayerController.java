package de.muetze.ephrax.controller.restfulController;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.muetze.ephrax.controller.LoggerService;
import de.muetze.ephrax.controller.templates.JDBCDriverConnection;
import de.muetze.ephrax.controller.templates.PlayerTemplateImpl;
import de.muetze.ephrax.model.Player;
import de.muetze.ephrax.model.Response;
import de.muetze.ephrax.model.UpdateObject;

@RestController
@RequestMapping("/player")
public class PlayerController extends PlayerTemplateImpl {

	@GetMapping("/list={code}")
	public List<Player> getPlayerList(@PathVariable String code) {
		return getAllWithCondition("code = '" + code.toUpperCase() + "'");
	}

	@GetMapping("/kick={id}")
	public Response kickPlayer(@PathVariable int id) {
		try {
			new JDBCDriverConnection(SCHEME, TABLE).executeDelete(id);
			return new Response("Entfernen des Spielers war erfolgreich", true);
		} catch (final SQLException e) {
			e.printStackTrace();
			LoggerService.severe(Arrays.toString(e.getStackTrace()));
			return new Response("Entfernen des Spielers fehlgeschlagen", false);
		}
	}

	@PostMapping("/register")
	public Response registerOld(@RequestBody Map<String, String> playerInfo) {
		try {
			final UpdateObject<?>[] updateObjects = new UpdateObject[3];
			updateObjects[0] = new UpdateObject<>("code", playerInfo.get("code"));
			updateObjects[1] = new UpdateObject<>("name", playerInfo.get("name"));
			updateObjects[2] = new UpdateObject<>("is_master",
					playerInfo.get("gamemaster").equalsIgnoreCase("GameMaster"));
			new JDBCDriverConnection(SCHEME, TABLE).executeAdd(updateObjects);
			return new Response("Spieler wurde dem Spiel hinzugefügt", true);
		} catch (final SQLException e) {
			e.printStackTrace();
			LoggerService.severe(Arrays.toString(e.getStackTrace()));
			return new Response("Spieler konnte nicht hinzugefügt werden", false);
		}
	}
}
