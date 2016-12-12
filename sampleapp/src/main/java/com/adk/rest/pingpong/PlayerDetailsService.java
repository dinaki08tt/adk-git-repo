package com.adk.rest.pingpong;

import java.util.Calendar;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.adk.db.pingpong.PlayerDetails;
import com.adk.db.pingpong.PlayerDetailsHome;

@Path("/player")
public class PlayerDetailsService {

	@GET
	@Path("/get/{id}")
	@Produces({"application/json"})
	public PlayerDetails getPlayerById(@PathParam("id") String id){
		PlayerDetailsHome dao = new PlayerDetailsHome();
		return dao.findById(Integer.parseInt(id));
	}
	
}