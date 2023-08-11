package de.muetze.ephrax.controller.restfulController.usersSession;

import org.springframework.data.jpa.repository.JpaRepository;

import de.muetze.ephrax.model.jpa.UsersSession;

public interface UsersSessionRepository extends JpaRepository<UsersSession, Long> {

}
