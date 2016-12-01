package com.adk.rest.pingpong;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.adk.db.JDBCConnector;
import com.adk.db.Person;
import com.adk.db.pingpong.PlayerDetails;
import com.adk.db.pingpong.PlayerDetailsHome;

@Path("/foo")
public class PlayerDetailsService {

	@GET
	@Path("/person")
	@Produces("application/json")
	public Person getPersonId(){
		JDBCConnector jdbc = new JDBCConnector();
		Person p = jdbc.getPerson();
//		Person p = dao.findById(1);

		return p;
	}
	
	public static void main(String[] args){
		PlayerDetailsHome dao = new PlayerDetailsHome();
//		PlayerDetails search = new PlayerDetails();
////		search.setPlayerName("Dinesh Krishnan");
//		search.setAge(29);
//		List result = dao.findByExample(search);
//		Iterator itr = result.iterator();
//		
//		while (itr.hasNext()) {
//			Object object = (Object) itr.next();
//			System.out.println(object.toString());
//		}
		
		PlayerDetails pd = dao.findById(1);
		
		System.out.println(pd.toString());
		
		//persistNewPlayer(dao);
		
	}

	private static void persistNewPlayer(PlayerDetailsHome dao) {
		PlayerDetails pojo = new PlayerDetails();
		pojo.setAddress("25, Krishna Nagar, Peelemedu, Coimbatore");
		pojo.setAge(29);
		Calendar cal = Calendar.getInstance();
		cal.set(1988, 03, 18);
		pojo.setDob(cal.getTime());
		cal.set(2016, 11, 30);
		pojo.setDateOfJoining(cal.getTime());
		pojo.setFatherName("Arumugam");
		pojo.setIsParentPlayer((byte) 0);
		pojo.setIsParentRefere((byte) 0);
		pojo.setIsParentWillingToLearn((byte) 1);
		pojo.setMobileNumber("9176158249");
		pojo.setMotherName("Rajeswari");
		pojo.setOccupation("Software Engineer");
		pojo.setPlayerName("Dinesh Krishnan");
//		pojo.setPlayerScoreDetailses(playerScoreDetailses);
		
		dao.persist(pojo );
	}
}