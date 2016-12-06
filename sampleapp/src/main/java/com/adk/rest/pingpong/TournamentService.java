package com.adk.rest.pingpong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.adk.db.pingpong.Tournament;
import com.adk.db.pingpong.TournamentHome;

@Path("/tour")
public class TournamentService {

	@GET
	@Path("/get/{id}")
	@Produces({"application/xml", "application/json"})
	public Tournament getTourId(@PathParam("id") String id){
		TournamentHome tourDao = new TournamentHome();
		Tournament t = tourDao.findById(Integer.parseInt(id)); 
		return t;
	}
	
	
}