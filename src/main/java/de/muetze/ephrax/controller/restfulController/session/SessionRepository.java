package de.muetze.ephrax.controller.restfulController.session;

import org.springframework.data.jpa.repository.JpaRepository;

import de.muetze.ephrax.model.jpa.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
