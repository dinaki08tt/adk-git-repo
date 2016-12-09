package com.adk.freemarker;

public class GroupSheetVO {
	String player1;
	String player2;
	String player3;
	String player4;
	String category;
	String type;
	String round;
	String groupName;
	String tableNo;
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
	public String getPlayer3() {
		return player3;
	}
	public void setPlayer3(String player3) {
		this.player3 = player3;
	}
	public String getPlayer4() {
		return player4;
	}
	public void setPlayer4(String player4) {
		this.player4 = player4;
	}
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
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getTableNo() {
		return tableNo;
	}
	public void setTableNo(String tableNo) {
		this.tableNo = tableNo;
	}
	@Override
	public String toString() {
		return "GroupSheetVO [player1=" + player1 + ", player2=" + player2 + ", player3=" + player3 + ", player4="
				+ player4 + ", category=" + category + ", type=" + type + ", round=" + round + ", groupName="
				+ groupName + ", tableNo=" + tableNo + "]";
	}
	
}
