package com.adk.rest.pingpong;

import java.util.Calendar;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.adk.db.pingpong.PlayerDetails;
import com.adk.db.pingpong.PlayerDetailsHome;

@Path("/player")
public class PlayerDetailsService {

	@GET
	@Path("/get/{id}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@Produces({"application/json"})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public PlayerDetails getPlayerById(@PathParam("id") String id){
		PlayerDetailsHome dao = PlayerDetailsHome.getInstance();
		return dao.findById(Integer.parseInt(id));
	}
	
}