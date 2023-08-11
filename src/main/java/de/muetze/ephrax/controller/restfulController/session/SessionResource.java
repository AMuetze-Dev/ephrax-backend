package de.muetze.ephrax.controller.restfulController.session;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.muetze.ephrax.controller.restfulController.user.UserResource;
import de.muetze.ephrax.model.jpa.Session;

@RestController
@RequestMapping("/session")
public class SessionResource {

	@Autowired
	private SessionRepository sessionRepository;

	@PostMapping
	public Session create(@RequestBody Session session) {
		session.setLeader(new UserResource().get(session.getLeader().getId()));
		return sessionRepository.save(session);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		sessionRepository.deleteById(id);
	}

	@GetMapping
	public List<Session> get() {
		return sessionRepository.findAll();
	}

	@GetMapping("/{id}")
	public Session get(@PathVariable Long id) {
		return sessionRepository.findById(id).orElse(null);
	}

	@PutMapping("/{id}")
	public Session update(@PathVariable Long id, @RequestBody Session session) {
		session.setId(id);
		return sessionRepository.save(session);
	}
}
