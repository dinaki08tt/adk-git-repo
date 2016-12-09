package com.adk.rest.pingpong;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.adk.db.pingpong.GameScore;
import com.adk.db.pingpong.GameScoreHome;
import com.adk.db.pingpong.GroupMatchesDetails;
import com.adk.db.pingpong.GroupMatchesDetailsHome;
import com.adk.db.pingpong.PlayerDetails;
import com.adk.db.pingpong.PlayerDetailsHome;

@Path("/group")
public class GroupMatchesService {

	@GET
	@Path("/get/{id}")
	@Produces({"application/xml", "application/json"})
	public GroupMatchesDetails getGroupMatchesId(@PathParam("id") String id){
		GroupMatchesDetailsHome dao = new GroupMatchesDetailsHome();
		GroupMatchesDetails gmd = dao.findById(Integer.parseInt(id)); 
		return gmd;
	}
	
	@GET
	@Path("/popluate/{id}")
	@Produces({"application/xml", "application/json"})
	public GroupMatchesDetails populateMatcheScore(@PathParam("id") String id){
		GroupMatchesDetailsHome dao = new GroupMatchesDetailsHome();
		GroupMatchesDetails match = dao.findMatchByMatchId("1",12);
		GameScoreHome gameDao = new GameScoreHome();
		 Set games = new HashSet();
		GameScore game = new GameScore();
		 game.setMatchId(12);
		 game.setGameId(1);
		 game.setPlayer1Score(11);
		 game.setPlayer2Score(3);
		 games.add(game);
		 game = new GameScore();
		 game.setMatchId(12);
		 game.setGameId(2);
		 game.setPlayer1Score(11);
		 game.setPlayer2Score(9);
		 games.add(game);
		 match.setGameScores(games);
		 game = new GameScore();
		 game.setMatchId(12);
		 game.setGameId(3);
		 game.setPlayer1Score(11);
		 game.setPlayer2Score(8);
		 games.add(game);
		 match.setGameScores(games);
		 return dao.update(match);
	}
	
	private static PlayerDetailsHome pdao = new PlayerDetailsHome();
	private static PlayerDetails getPlayer(Integer player1Id) {
		PlayerDetails p = pdao.findById(player1Id);
		return p;
	}
	
	public static void main(String args[]){
		
		GroupMatchesDetailsHome dao = new GroupMatchesDetailsHome();
		GroupMatchesDetails match = dao.findMatchByMatchId("1",7);
		GameScoreHome gameDao = new GameScoreHome();
		GameScore game = new GameScore();
		game.setGroupMatchesDetails(match); 
		game.setMatchId(12);
		 game.setGameId(1);
		 game.setPlayerDetailsByPlayer1Id(getPlayer(match.getPlayer1Id()));
		 game.setPlayerDetailsByPlayer2Id(getPlayer(match.getPlayer2Id()));
		 game.setPlayer1Score(11);
		 game.setPlayer2Score(3);
		 gameDao.persist(game);
		 game = new GameScore();
		 game.setPlayerDetailsByPlayer1Id(getPlayer(match.getPlayer1Id()));
		 game.setPlayerDetailsByPlayer2Id(getPlayer(match.getPlayer2Id()));
		 game.setMatchId(12);
		 game.setGameId(2);
		 game.setPlayer1Score(11);
		 game.setPlayer2Score(9);
		 game.setGroupMatchesDetails(match); 
		 gameDao.persist(game);
		 game = new GameScore();
		 game.setPlayerDetailsByPlayer1Id(getPlayer(match.getPlayer1Id()));
		 game.setPlayerDetailsByPlayer2Id(getPlayer(match.getPlayer2Id()));
		 game.setMatchId(12);
		 game.setGameId(3);
		 game.setPlayer1Score(11);
		 game.setPlayer2Score(8);
		 game.setGroupMatchesDetails(match); 
		 gameDao.persist(game);
		 
	//	 System.out.println(dao.update(match));
	}
	
}