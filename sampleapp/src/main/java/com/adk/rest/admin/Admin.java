package com.adk.rest.admin;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.adk.db.pingpong.Users;
import com.adk.db.pingpong.UsersHome;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/admin")
public class Admin {
	
	@POST
	@Path("/login/{u}")
	@Produces({"application/json"})
	public Response login(@PathParam("u") String u){
		
	UsersHome userDao = UsersHome.getInstance();
	Users user = userDao.findByName(u);
	String json = null;

	if(user!=null){
		json ="Successfull";
	}else{
		json ="failure";
	}
	
	
//	try {
//	ObjectMapper mapper = new ObjectMapper();
//		json = mapper.writeValueAsString(user);//convert entity to json
//	} catch (JsonProcessingException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}; 
	return Response.ok(json, MediaType.APPLICATION_JSON).build();
	
	}
	
	
	
	
	
	
}