package com.adk.excel;

import java.util.List;

public class Group {

	private List<Player> players;
	private String groupName;
	private Integer groupNumber;
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Integer getGroupNumber() {
		return groupNumber;
	}
	public void setGroupNumber(Integer groupNumber) {
		this.groupNumber = groupNumber;
	}
	@Override
	public String toString() {
		return "Group [players=" + players + ", groupName=" + groupName + ", groupNumber=" + groupNumber + "] \n";
	}

	
}
