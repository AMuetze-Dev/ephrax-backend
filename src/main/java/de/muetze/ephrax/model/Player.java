package de.muetze.ephrax.model;

import java.util.ArrayList;
import java.util.List;

public class Player implements UpdateObjectable {

	private int id;
	private String name;
	private String code;
	private boolean isCaptain;
	private boolean isGamemaster;
	private int points;

	public Player(String name) {
		this.name = name;
		isCaptain = false;
		isGamemaster = false;
	}

	@Override
	public UpdateObject<?>[] convertToUpdateObjectArray() {
		final List<UpdateObject<?>> list = new ArrayList<>();
		list.add(new UpdateObject<>("id", id));
		list.add(new UpdateObject<>("name", name));
		list.add(new UpdateObject<>("code", code));
		list.add(new UpdateObject<>("is_master", isGamemaster));
		list.add(new UpdateObject<>("points", points));
		return list.toArray(new UpdateObject<?>[0]);
	}

	public String getCode() {
		return code;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPoints() {
		return points;
	}

	public boolean isCaptain() {
		return isCaptain;
	}

	public boolean isGamemaster() {
		return isGamemaster;
	}

	public void setCaptain(boolean isCaptain) {
		this.isCaptain = isCaptain;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setGamemaster(boolean isGameMaster) {
		isGamemaster = isGameMaster;
	}

	public void setID(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}
