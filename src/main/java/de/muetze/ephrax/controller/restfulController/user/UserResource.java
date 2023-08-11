package de.muetze.ephrax.controller.restfulController.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.muetze.ephrax.model.user.User;

@RestController
@RequestMapping("/user")
public class UserResource {

	@Autowired
	private UserRepository userRepository;

	@PostMapping
	public User create(@RequestBody User user) {
		return userRepository.save(user);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		userRepository.deleteById(id);
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@PutMapping("/{id}")
	public User update(@PathVariable Long id, @RequestBody User user) {
		user.setId(id);
		return userRepository.save(user);
	}
}
