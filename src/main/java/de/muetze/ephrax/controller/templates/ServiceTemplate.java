package de.muetze.ephrax.controller.templates;

import de.muetze.ephrax.model.UpdateObject;
import de.muetze.ephrax.model.UpdateObjectable;

public interface ServiceTemplate<T extends UpdateObjectable> {

	void add(UpdateObject<?>... updateObjects);

	void delete(int id);
}
