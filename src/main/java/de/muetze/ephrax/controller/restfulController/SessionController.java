package de.muetze.ephrax.controller.restfulController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.muetze.ephrax.controller.templates.SessionTemplateImpl;

@RestController
@RequestMapping("/room")
public class SessionController extends SessionTemplateImpl {

}
