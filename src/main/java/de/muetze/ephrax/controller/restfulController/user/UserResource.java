package de.muetze.ephrax.controller.restfulController.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import de.muetze.ephrax.model.user.User;
import de.muetze.ephrax.model.user.UserNotFoundException;

@RestController
@RequestMapping("/user")
public class UserResource {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/create")
	public ResponseEntity<Object> create(@RequestBody User user) {
		final User savedUser = userRepository.save(user);
		final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		userRepository.deleteById(id);
	}

	@GetMapping("/get/{id}")
	public User read(@PathVariable long id) {
		final Optional<User> user = userRepository.findById(id);
		if (user.isEmpty())
			throw new UserNotFoundException("id - " + id);
		return user.get();
	}

	@GetMapping("/get/all")
	public List<User> readAll() {
		return userRepository.findAll();
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> update(@RequestBody User user, @PathVariable long id) {
		final Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isEmpty())
			return ResponseEntity.notFound().build();
		user.setId(id);
		userRepository.save(user);
		return ResponseEntity.noContent().build();
	}
}
