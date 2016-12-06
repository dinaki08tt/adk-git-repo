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
	@Produces({"application/xml", "application/json"})
	public PlayerDetails getPlayerById(@PathParam("id") String id){
		PlayerDetailsHome dao = new PlayerDetailsHome();
		return dao.findById(Integer.parseInt(id));
	}
	
	public static void main(String[] args){
		PlayerDetailsHome dao = new PlayerDetailsHome();
//		getPlayerById(dao);
		persistNewPlayer(dao);
		//persistNewPlayer(dao);
	}

	private static void getPlayerById(PlayerDetailsHome dao) {
		PlayerDetails pd = dao.findById(1);
		
		System.out.println(pd.toString());
	}

	private static void persistNewPlayer(PlayerDetailsHome dao) {
		PlayerDetails pojo = new PlayerDetails();
		pojo.setAddress("Krishna Nagar, Peelemedu, Coimbatore");
		pojo.setAge(9);
		Calendar cal = Calendar.getInstance();
		cal.set(1988, 03, 18);
		pojo.setDob(cal.getTime());
		cal.set(2016, 11, 30);
		pojo.setDateOfJoining(cal.getTime());
		pojo.setFatherName("Chetty");
		pojo.setIsParentPlayer(true);
		pojo.setIsParentRefere(true);
		pojo.setIsParentWillingToLearn(true);
		pojo.setMobileNumber("9176158249");
		pojo.setMotherName("Rajeswari");
		pojo.setOccupation("Software Engineer");
		pojo.setPlayerName("Krishna Kumar");
		dao.persist(pojo );
	}
	
}