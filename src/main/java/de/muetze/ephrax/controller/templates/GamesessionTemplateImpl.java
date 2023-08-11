package de.muetze.ephrax.controller.templates;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.function.Function;

import de.muetze.ephrax.controller.LoggerService;
import de.muetze.ephrax.model.GameSession;

public class GamesessionTemplateImpl extends ServiceTemplateImpl<GameSession> {

	@Override
	protected String getTable() {
		return "game_sessions";
	}

	@Override
	protected Function<ResultSet, GameSession> setResultSetFunction() {
		return r -> {
			final GameSession session = new GameSession();
			try {
				session.setGameCode(r.getString("code"));
				session.setGameID(r.getInt("active_game"));
			} catch (final SQLException e) {
				LoggerService.severe(Arrays.toString(e.getStackTrace()));
			}
			return session;
		};
	}
}
