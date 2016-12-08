package com.adk.rest.pingpong;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.adk.db.pingpong.Event;
import com.adk.db.pingpong.EventHome;
import com.adk.db.pingpong.Tournament;
import com.adk.db.pingpong.TournamentHome;

@Path("/event")
public class EventService {

	@GET
	@Path("/get/{id}")
	@Produces({"application/xml", "application/json"})
	public Event getEventId(@PathParam("id") String id){
		EventHome eDao = new EventHome();
		Event e = eDao.findById(Integer.parseInt(id));
		return e;
	}
	
//	@GET
//	@Path("/get/tour/{name}")
//	@Produces({"application/xml", "application/json"})
//	public List<Event> getEventByTourName(@PathParam("name") String name){
//		EventHome eDao = new EventHome();
//		List<Event> list = eDao.findByTournamentName(name);
//		return list;
//	}
	
}