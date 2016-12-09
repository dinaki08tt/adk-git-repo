package com.adk.freemarker;

public class ScoreSheetVO {
	String category;
	String type;
	String round;
	String tableNo;
	String groupName;
	String matchId;
	String player1;
	String player2;
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getRound() {
		return round;
	}
	
	public void setRound(String round) {
		this.round = round;
	}
	
	public String getTableNo() {
		return tableNo;
	}
	
	public void setTableNo(String tableNo) {
		this.tableNo = tableNo;
	}
	
	public String getGroupName() {
		return groupName;
	}
	
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public String getMatchId() {
		return matchId;
	}
	
	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}

	public String getPlayer1() {
		return player1;
	}

	public void setPlayer1(String player1) {
		this.player1 = player1;
	}

	public String getPlayer2() {
		return player2;
	}

	public void setPlayer2(String player2) {
		this.player2 = player2;
	}

	@Override
	public String toString() {
		return "ScoreSheetVO [category=" + category + ", type=" + type + ", round=" + round + ", tableNo=" + tableNo
				+ ", groupName=" + groupName + ", matchId=" + matchId + ", player1=" + player1 + ", player2=" + player2
				+ "]";
	}
	
	
}
