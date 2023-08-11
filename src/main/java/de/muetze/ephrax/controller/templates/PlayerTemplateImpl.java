package de.muetze.ephrax.controller.templates;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.function.Function;

import de.muetze.ephrax.controller.LoggerService;
import de.muetze.ephrax.model.Player;

public class PlayerTemplateImpl extends ServiceTemplateImpl<Player> {

	@Override
	protected String getTable() {
		return "players";
	}

	@Override
	protected Function<ResultSet, Player> setResultSetFunction() {
		return r -> {
			final Player player = new Player("");
			try {
				player.setID(r.getInt("id"));
				player.setName(r.getString("name"));
				player.setCode(r.getString("code"));
				player.setGamemaster(r.getBoolean("is_master"));
				player.setPoints(r.getInt("points"));
			} catch (final SQLException e) {
				LoggerService.severe(Arrays.toString(e.getStackTrace()));
			}
			return player;
		};
	}

}
