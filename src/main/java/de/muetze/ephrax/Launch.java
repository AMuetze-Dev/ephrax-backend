package de.muetze.ephrax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import de.muetze.ephrax.controller.DatabaseController;
import de.muetze.ephrax.cors.CorsConfig;

@SpringBootApplication
@ComponentScan(basePackages = "de.muetze.ephrax.controller")
@Import(CorsConfig.class)
public class Launch {

	public static void main(String[] args) {
		SpringApplication.run(Launch.class, args);
		new Launch().run();
	}

	private void run() {
		new DatabaseController().deleteDatabase();
		new DatabaseController().createDatabase();
	}

}
