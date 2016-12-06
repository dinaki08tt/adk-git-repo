package com.adk.db.pingpong;
// Generated Dec 5, 2016 10:30:31 AM by Hibernate Tools 4.3.1.Final

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * ScoreCard generated by hbm2java
 */
@XmlRootElement 
public class ScoreCard implements java.io.Serializable {

	private Integer scoreId;
	private GameScore gameScore;
	private PlayerDetails playerDetails;
	private Date matchDate;
	private int score;
	private int bonus;
	private int totalScore;

	public ScoreCard() {
	}

	public ScoreCard(GameScore gameScore, PlayerDetails playerDetails, Date matchDate, int score, int bonus,
			int totalScore) {
		this.gameScore = gameScore;
		this.playerDetails = playerDetails;
		this.matchDate = matchDate;
		this.score = score;
		this.bonus = bonus;
		this.totalScore = totalScore;
	}

	public Integer getScoreId() {
		return this.scoreId;
	}

	public void setScoreId(Integer scoreId) {
		this.scoreId = scoreId;
	}

	public GameScore getGameScore() {
		return this.gameScore;
	}

	public void setGameScore(GameScore gameScore) {
		this.gameScore = gameScore;
	}

	public PlayerDetails getPlayerDetails() {
		return this.playerDetails;
	}

	public void setPlayerDetails(PlayerDetails playerDetails) {
		this.playerDetails = playerDetails;
	}

	public Date getMatchDate() {
		return this.matchDate;
	}

	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getBonus() {
		return this.bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public int getTotalScore() {
		return this.totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

}