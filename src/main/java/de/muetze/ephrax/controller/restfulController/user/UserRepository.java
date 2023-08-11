package de.muetze.ephrax.controller.restfulController.user;

import org.springframework.data.jpa.repository.JpaRepository;

import de.muetze.ephrax.model.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
