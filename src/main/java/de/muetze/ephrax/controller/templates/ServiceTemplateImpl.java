package de.muetze.ephrax.controller.templates;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import de.muetze.ephrax.controller.LoggerService;
import de.muetze.ephrax.model.UpdateObjectable;

public abstract class ServiceTemplateImpl<T extends UpdateObjectable> implements ServiceTemplate<T> {

	protected final String TABLE;
	protected Function<ResultSet, T> resultSet;

	public ServiceTemplateImpl() {
		this.TABLE = getTable();
		this.resultSet = setResultSetFunction();
	}

	private List<T> executeQuery(String query) {
		List<T> ts = new ArrayList<>();
		try {
			ts = JDBCDriverConnection.executeQuery(query, resultSet);
		} catch (final SQLException e) {
			e.printStackTrace();
			LoggerService.severe(Arrays.toString(e.getStackTrace()));
		}
		return ts;
	}

	public List<T> getAll() {
		return executeQuery(String.format("SELECT * FROM %s;", TABLE));
	}

	public List<T> getAllWithCondition(String sqlConditions) {
		return executeQuery(String.format("SELECT * FROM %s WHERE %s;", TABLE, sqlConditions));
	}

	protected abstract String getTable();

	protected abstract Function<ResultSet, T> setResultSetFunction();
}
