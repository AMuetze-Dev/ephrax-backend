package de.muetze.ephrax.model;

import java.util.ArrayList;
import java.util.List;

public class GameSession implements UpdateObjectable {

	private String gameCode;
	private final List<Player> players;
	private int gameID;

	public GameSession() {
		players = new ArrayList<>();
		gameCode = "";
		gameID = 0;
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	@Override
	public UpdateObject<?>[] convertToUpdateObjectArray() {
		final List<UpdateObject<?>> list = new ArrayList<>();
		list.add(new UpdateObject<>("code", gameCode));
		list.add(new UpdateObject<>("active_game", gameID));
		return list.toArray(new UpdateObject<?>[0]);
	}

	public int getAmountOfPlayers() {
		return players.size();
	}

	public String getGameCode() {
		return gameCode;
	}

	public int getGameID() {
		return gameID;
	}

	public Player getPlayer(int position) {
		return players.get(position - 1);
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void removePlayer(int position) {
		players.remove(position - 1);
	}

	public void setGameCode(String gameCode) {
		this.gameCode = gameCode;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

}
