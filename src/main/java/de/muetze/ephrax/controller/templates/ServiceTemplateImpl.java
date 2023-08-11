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

	protected static final String SCHEME = "ephrax";
	protected final String TABLE;
	protected Function<ResultSet, T> resultSet;

	public ServiceTemplateImpl() {
		this.TABLE = getTable();
		this.resultSet = setResultSetFunction();
	}

	public List<T> getAll() {
		List<T> ts = new ArrayList<>();
		try {
			ts = JDBCDriverConnection.executeQuery(String.format("SELECT * FROM %s.\"%s\";", SCHEME, TABLE), resultSet);
		} catch (final SQLException e) {
			e.printStackTrace();
			LoggerService.severe(Arrays.toString(e.getStackTrace()));
		}
		return ts;
	}

	public List<T> getAllWithCondition(String sqlConditions) {
		List<T> ts = new ArrayList<>();
		try {
			System.out.println(String.format("SELECT * FROM %s.\"%s\" WHERE %s;", SCHEME, TABLE, sqlConditions));
			ts = JDBCDriverConnection.executeQuery(
					String.format("SELECT * FROM %s.\"%s\" WHERE %s;", SCHEME, TABLE, sqlConditions), resultSet);
		} catch (final SQLException e) {
			e.printStackTrace();
			LoggerService.severe(Arrays.toString(e.getStackTrace()));
		}
		return ts;
	}

	protected abstract String getTable();

	protected abstract Function<ResultSet, T> setResultSetFunction();
}
