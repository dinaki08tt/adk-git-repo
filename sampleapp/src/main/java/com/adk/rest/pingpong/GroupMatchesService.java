package com.adk.rest.pingpong;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.adk.db.JDBCConnector;
import com.adk.db.Person;
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
	public GroupMatchesDetails populateMatches(@PathParam("id") String id){
		GroupMatchesDetailsHome dao = new GroupMatchesDetailsHome();
		return dao.findById(Integer.parseInt(id));
	}
	
	
}