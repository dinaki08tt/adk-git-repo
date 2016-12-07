package com.adk.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.adk.db.Person;
import com.adk.db.PersonHome;

@Path("/hello")
public class HelloWorldService {

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
		String output = "Jersey say : " + msg;
		return Response.status(200).entity(output).build();
	}
	
	@GET
	@Path("/person")
	@Produces("application/json")
	public Person getPersonById(@PathParam("param") String msg){
		PersonHome dao = new PersonHome();
		Person p = dao.findById(1);
		calculateBusiness();
		return p;
	}
	
	@GET
	@Path("/age")
	@Produces("application/json")
	public Person getPersonByAge(@PathParam("param") String msg){
		PersonHome dao = new PersonHome();
		Person p = dao.findById(1);
//		calculateBusiness();
		return p;
	}

	private static final String str = new String("memoryleak1");

	public void calculateBusiness(){
		int i = 0;
		do{
			i++;
			if(i == 0){
//				System.out.println("i is 0");
			}
		}while(i<1000000000);
		int j = 0;
		do{
			j++;
			//String str = new String("memoryleak2");
			if(j == 0){
//				System.out.println("j is 0");
			}
		}while(j<100000000);
		int k = 0;
		do{
			k++;
			//String str = new String("memoryleak3");
			if(k == 0){
//				System.out.println("k is 0");
			}
		}while(k<100000000);
		int l = 0;
		do{
			l++;
			//String str = new String("memoryleak4");
			if(l == 0){
//				System.out.println("l is 0");
			}
		}while(l<100000000);
	}
	

}