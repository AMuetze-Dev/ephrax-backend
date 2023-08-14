package de.muetze.ephrax.controller.restfulController.code;

import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.muetze.ephrax.controller.restfulController.session.SessionRepository;

@RestController
@RequestMapping("/code")
public class CodeResource {

	@Autowired
	private SessionRepository sessionRepository;

	@GetMapping("/generate")
	public String generate() {
		final String code = new Random().ints(8, 0, 36)
				.mapToObj(i -> Character.toString(i < 10 ? '0' + i : 'A' + i - 10)).collect(Collectors.joining())
				.toUpperCase();
		return proof(code) ? generate() : code;
	}

	@GetMapping("/proof/{code}")
	public boolean proof(@PathVariable String code) {
		return sessionRepository.findByCode(code) != null;
	}
}
