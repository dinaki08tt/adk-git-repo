package com.adk.db.pingpong;
// Generated Dec 5, 2016 10:30:31 AM by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * GameScore generated by hbm2java
 */
@XmlRootElement 
public class GameScore implements java.io.Serializable {

	private Integer matchId;
	private GroupMatchesDetails groupMatchesDetails;
	private PlayerDetails playerDetailsByPlayer2Id;
	private PlayerDetails playerDetailsByPlayer1Id;
	private Integer gameId;
	private Integer player1Score;
	private Integer player2Score;
	private Set scoreCards = new HashSet(0);

	public GameScore() {
	}

	public GameScore(GroupMatchesDetails groupMatchesDetails, PlayerDetails playerDetailsByPlayer2Id,
			PlayerDetails playerDetailsByPlayer1Id) {
		this.groupMatchesDetails = groupMatchesDetails;
		this.playerDetailsByPlayer2Id = playerDetailsByPlayer2Id;
		this.playerDetailsByPlayer1Id = playerDetailsByPlayer1Id;
	}

	public GameScore(GroupMatchesDetails groupMatchesDetails, PlayerDetails playerDetailsByPlayer2Id,
			PlayerDetails playerDetailsByPlayer1Id, Integer gameId, Integer player1Score, Integer player2Score,
			Set scoreCards) {
		this.groupMatchesDetails = groupMatchesDetails;
		this.playerDetailsByPlayer2Id = playerDetailsByPlayer2Id;
		this.playerDetailsByPlayer1Id = playerDetailsByPlayer1Id;
		this.gameId = gameId;
		this.player1Score = player1Score;
		this.player2Score = player2Score;
		this.scoreCards = scoreCards;
	}

	public Integer getMatchId() {
		return this.matchId;
	}

	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}

	public GroupMatchesDetails getGroupMatchesDetails() {
		return this.groupMatchesDetails;
	}

	public void setGroupMatchesDetails(GroupMatchesDetails groupMatchesDetails) {
		this.groupMatchesDetails = groupMatchesDetails;
	}

	public PlayerDetails getPlayerDetailsByPlayer2Id() {
		return this.playerDetailsByPlayer2Id;
	}

	public void setPlayerDetailsByPlayer2Id(PlayerDetails playerDetailsByPlayer2Id) {
		this.playerDetailsByPlayer2Id = playerDetailsByPlayer2Id;
	}

	public PlayerDetails getPlayerDetailsByPlayer1Id() {
		return this.playerDetailsByPlayer1Id;
	}

	public void setPlayerDetailsByPlayer1Id(PlayerDetails playerDetailsByPlayer1Id) {
		this.playerDetailsByPlayer1Id = playerDetailsByPlayer1Id;
	}

	public Integer getGameId() {
		return this.gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public Integer getPlayer1Score() {
		return this.player1Score;
	}

	public void setPlayer1Score(Integer player1Score) {
		this.player1Score = player1Score;
	}

	public Integer getPlayer2Score() {
		return this.player2Score;
	}

	public void setPlayer2Score(Integer player2Score) {
		this.player2Score = player2Score;
	}

	public Set getScoreCards() {
		return this.scoreCards;
	}

	public void setScoreCards(Set scoreCards) {
		this.scoreCards = scoreCards;
	}

}