package de.muetze.ephrax.controller.restfulController.user;

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

import de.muetze.ephrax.model.jpa.User;

@RestController
@RequestMapping("/user")
public class UserResource {

	@Autowired
	private UserRepository userRepository;

	@PostMapping
	public Long create(@RequestBody String username) {
		final User user = new User(username);
		return userRepository.save(user).getId();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		userRepository.deleteById(id);
	}

	@GetMapping
	public List<User> get() {
		return userRepository.findAll();
	}

	@GetMapping("/{id}")
	public User get(@PathVariable Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@PutMapping("/{id}")
	public User update(@PathVariable Long id, @RequestBody User user) {
		user.setId(id);
		return userRepository.save(user);
	}
}
