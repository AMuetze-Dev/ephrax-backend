package de.muetze.ephrax.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistryController {

	@PostMapping("/create-game")
	public boolean createGame(@RequestBody String code) {
		return true;
	}

	@PostMapping("/join-game")
	public boolean joinGame(@RequestBody String code) {
		return true;
	}
}
