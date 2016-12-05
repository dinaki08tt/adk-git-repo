package com.adk.excel;

public class Entry {
	
	private String name;
	private String playerCode;
	private Integer seeding;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlayerCode() {
		return playerCode;
	}
	public void setPlayerCode(String playerCode) {
		this.playerCode = playerCode;
	}
	public Integer getSeeding() {
		return seeding;
	}
	public void setSeeding(Integer seeding) {
		this.seeding = seeding;
	}
	@Override
	public String toString() {
		return "Entry [name=" + name + ", playerCode=" + playerCode + ", seeding=" + seeding + "]";
	}
	
}
