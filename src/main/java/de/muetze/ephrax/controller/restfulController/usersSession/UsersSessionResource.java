package de.muetze.ephrax.controller.restfulController.usersSession;

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
import de.muetze.ephrax.model.jpa.UsersSession;

@RestController
@RequestMapping("/userssession")
public class UsersSessionResource {

	@Autowired
	private UsersSessionRepository usersSessionRepository;

	@PostMapping
	public UsersSession create(@RequestBody UsersSession usersSession) {
		return usersSessionRepository.save(usersSession);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		usersSessionRepository.deleteById(id);
	}

	@GetMapping
	public List<UsersSession> get() {
		return usersSessionRepository.findAll();
	}

	@GetMapping("/{id}")
	public UsersSession get(@PathVariable Long id) {
		return usersSessionRepository.findById(id).orElse(null);
	}

	@PutMapping("/{id}")
	public UsersSession update(@PathVariable Long id, @RequestBody UsersSession usersSession) {
		usersSession.setUser(new UserResource().get(id));
		return usersSessionRepository.save(usersSession);
	}
}
