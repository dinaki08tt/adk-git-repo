package com.adk.excel;

import java.util.List;

public class Group {

	private List<Entry> entries;
	private String groupName;
	private Integer groupNumber;

	
	public List<Entry> getEntries() {
		return entries;
	}
	public void setEntries(List<Entry> entries) {
		this.entries = entries;
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
		return "Group [entries=" + entries + ", groupName=" + groupName + ", groupNumber=" + groupNumber + "]";
	}
	
}
