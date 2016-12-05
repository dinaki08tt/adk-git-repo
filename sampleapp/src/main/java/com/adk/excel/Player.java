package com.adk.excel;

import java.util.Date;

public 
class Player{

private String playerCode;
private String name;
private Double age;
private String fatherName;
private String motherName;
private String occupation;
private Date DOB;
private Date DOJ;
private Integer mobileNo;
private String address;
private Boolean isParentPlayer;
private Boolean isParentWillingLearn;
private Boolean isPlayerReferee;




public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}


public Double getAge() {
	return age;
}
public void setAge(Double age) {
	this.age = age;
}
public String getPlayerCode() {
	return playerCode;
}

public void setPlayerCode(String playerCode) {
	this.playerCode = playerCode;
}
public String getFatherName() {
	return fatherName;
}
public void setFatherName(String fatherName) {
	this.fatherName = fatherName;
}
public String getMotherName() {
	return motherName;
}
public void setMotherName(String motherName) {
	this.motherName = motherName;
}
public String getOccupation() {
	return occupation;
}
public void setOccupation(String occupation) {
	this.occupation = occupation;
}
public Date getDOB() {
	return DOB;
}
public void setDOB(Date dOB) {
	DOB = dOB;
}
public Date getDOJ() {
	return DOJ;
}
public void setDOJ(Date dOJ) {
	DOJ = dOJ;
}
public Integer getMobileNo() {
	return mobileNo;
}
public void setMobileNo(Integer mobileNo) {
	this.mobileNo = mobileNo;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Boolean getIsParentPlayer() {
	return isParentPlayer;
}
public void setIsParentPlayer(Boolean isParentPlayer) {
	this.isParentPlayer = isParentPlayer;
}
public Boolean getIsParentWillingLearn() {
	return isParentWillingLearn;
}
public void setIsParentWillingLearn(Boolean isParentWillingLearn) {
	this.isParentWillingLearn = isParentWillingLearn;
}
public Boolean getIsPlayerReferee() {
	return isPlayerReferee;
}
public void setIsPlayerReferee(Boolean isPlayerReferee) {
	this.isPlayerReferee = isPlayerReferee;
}
@Override
public String toString() {
	return "Player [playerCode=" + playerCode + ", name=" + name + ", age=" + age + ", fatherName=" + fatherName
			+ ", motherName=" + motherName + ", occupation=" + occupation + ", DOB=" + DOB + ", DOJ=" + DOJ
			+ ", mobileNo=" + mobileNo + ", address=" + address + ", isParentPlayer=" + isParentPlayer
			+ ", isParentWillingLearn=" + isParentWillingLearn + ", isPlayerReferee=" + isPlayerReferee + "]";
}

}
