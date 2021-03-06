package com.adk.rest.pingpong;

import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;

import org.hibernate.exception.ConstraintViolationException;

import com.adk.db.pingpong.Category;
import com.adk.db.pingpong.CategoryHome;
import com.adk.db.pingpong.Tournament;
import com.adk.db.pingpong.TournamentHome;
import com.adk.utils.Constants;

@Path("/tour")
public class TournamentService {


	@GET
	@Path("/get/{id}")
	@Produces({"application/xml", "application/json"})
	public Tournament getTourId(@PathParam("id") String id){
		TournamentHome tourDao = TournamentHome.getInstance();
		Tournament t = tourDao.findById(Integer.parseInt(id)); 
		return t;
	}
	
	
	@GET
	@Path("/create/{tourName}/{org}/{venue}/{date}")
	@Produces({"application/json"})
	public Tournament createTour(@PathParam("tourName") String tourName, @PathParam("org") String org, @PathParam("venue") String venue, @PathParam("date") String datee){
		TournamentHome tdao = TournamentHome.getInstance();
		Tournament t = null; 
		try{
			t= new Tournament();;
			t.setOrganizer(org);
			t.setTourName(tourName);
			t.setVenue(venue);
			Date date = Constants.getDate(datee);
			t.setTourDate(date);
			tdao.persist(t);
			
			t = tdao.findTourByName(tourName);
			
		}catch(ConstraintViolationException e){
			throw new WebApplicationException(e, Status.NOT_ACCEPTABLE);
		}
		return t;
	}
	
	
	@GET
	@Path("/category/getAll")
	@Produces({"application/json"})
	public List<Category> getAllCategory(){
		CategoryHome cdao = CategoryHome.getInstance();
		try{
			List<Category> all = cdao.findAll();
			return all;
		}catch(ConstraintViolationException e){
			throw new WebApplicationException(e, Status.NOT_ACCEPTABLE);
		}
	}
	
	@GET
	@Path("/getAll")
	@Produces({"application/json"})
	public List<Tournament> getAllTour(){
		TournamentHome tdao = TournamentHome.getInstance();
		try{
			List<Tournament> all = tdao.findAll();
			return all;
		}catch(ConstraintViolationException e){
			throw new WebApplicationException(e, Status.NOT_ACCEPTABLE);
		}

	}

	
	@GET
	@Path("/get/date/{day}")
	@Produces({"application/json"})
	public Tournament getTourByDate(@PathParam("day") String day){
		TournamentHome tdao = TournamentHome.getInstance();
		try{
			// Tournament t = tdao.findTourByDate();
			return null;
		}catch(ConstraintViolationException e){
			throw new WebApplicationException(e, Status.NOT_ACCEPTABLE);
		}
		
	}
	
	
}