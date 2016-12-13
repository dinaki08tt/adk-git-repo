package com.adk.rest.pingpong;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.adk.db.pingpong.CategoryHome;
import com.adk.db.pingpong.Event;
import com.adk.db.pingpong.EventHome;
import com.adk.db.pingpong.Tournament;
import com.adk.db.pingpong.TournamentHome;
import com.adk.utils.Constants;

@Path("/event")
public class EventService {

	@GET
	@Path("/get/{id}")
	@Produces({"application/json"})
	public Event getEventId(@PathParam("id") String id){
		EventHome eDao = EventHome.getInstance();
		Event e = eDao.findById(Integer.parseInt(id));
		return e;
	}
	
	
	@GET
	@Path("/create/{name}/{matchType}/{gender}/{venue}/{date}")
	@Produces({"application/json"})
	public Event createEvent(@PathParam("name") String name, @PathParam("matchType") String matchType, @PathParam("gender") String gender, @PathParam("venue") String venue, @PathParam("date") String date){
		EventHome eDao = EventHome.getInstance();
		TournamentHome tdao = TournamentHome.getInstance();
		Date datee = Constants.getDate(date);
		Tournament t = tdao.findByDate(datee);
		CategoryHome cdao = CategoryHome.getInstance(); 
		
		
		return null;
	}


	
	
	
	
	
}