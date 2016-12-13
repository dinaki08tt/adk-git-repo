package com.adk.rest.pingpong;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import org.hibernate.exception.ConstraintViolationException;

import com.adk.db.pingpong.Category;
import com.adk.db.pingpong.CategoryHome;
import com.adk.db.pingpong.Event;
import com.adk.db.pingpong.EventHome;
import com.adk.db.pingpong.Tournament;
import com.adk.db.pingpong.TournamentHome;
import com.adk.utils.Constants;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Path("/event")
public class EventService {
	EventHome eDao = EventHome.getInstance();
	TournamentHome tdao = TournamentHome.getInstance();
	CategoryHome cdao = CategoryHome.getInstance(); 
	
	@GET
	@Path("/get/{id}")
	@Produces({"application/json"})
	public Event getEventId(@PathParam("id") String id){
		Event e = eDao.findById(Integer.parseInt(id));
		return e;
	}
	
	
	@GET
	@Path("/create/{name}/{matchType}/{gender}/{venue}/{date}")
	@Produces({"application/json"})
	public Event createEvent(@PathParam("name") String name, @PathParam("matchType") String matchType, @PathParam("gender") String gender, @PathParam("venue") String venue, @PathParam("date") String date){
		Date datee = Constants.getDate(date);
		String eventName = null;
		try{
		Tournament t = tdao.findByDate(datee);
		Category c = cdao.findCategory(name, gender, matchType);
		eventName = Constants.getEventName(name, matchType, gender, c.getCategoryId(), t.getTourId());
		Event e = new Event();
		e.setEventName(eventName);
		e.setCategory(c);
		e.setEventDate(datee);
		e.setTournament(t);
		eDao.persist(e);
			
		} catch(Exception e){
			if(e instanceof MySQLIntegrityConstraintViolationException || e instanceof ConstraintViolationException){
				throw new WebApplicationException(e,Status.NOT_ACCEPTABLE);	
			}
			throw new WebApplicationException(e,Status.INTERNAL_SERVER_ERROR);
		}
		
		return eDao.findByName(eventName);
	}


	
	
	
	
	
}