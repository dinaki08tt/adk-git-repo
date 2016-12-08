package com.adk.utils;

import java.util.List;

import com.adk.db.pingpong.Category;
import com.adk.db.pingpong.CategoryHome;
import com.adk.db.pingpong.Event;
import com.adk.db.pingpong.EventHome;
import com.adk.db.pingpong.Tournament;
import com.adk.db.pingpong.TournamentHome;
import com.adk.excel.LeagueDesigner;
import com.adk.excel.ReadExcel;
import com.adk.msword.WriteWordFile;

public class MainRun {

	public static void main(String args[]){
		//create category
//		createCategory();
//		createAllCategory();
		//create tournament
//		createTournament();
//		createEvent();
//		createEvents();
		
		//populate Players to DB
		//ReadExcel.populatePlayersToDB();
		//get entry to tournament & design league
//		LeagueDesigner.createGroupMatchForEvent("mini cadet-singles-male-2-1");
		
//		List<Event> events = getAllEventsForTour();

		//print score sheet
//		System.out.println(WriteWordFile.printScoreSheet(events));

		//print a group sheet
		WriteWordFile.printGroupSheet(getAllEventsForTour());
	}
	
	private static List<Event> getAllEventsForTour() {
		TournamentHome tdao = new TournamentHome();
		Tournament t = tdao.findTourByName("Recreational Tournament");
		EventHome edao = new EventHome();
		List<Event> list = edao.findByTournament(t);
		return list;
	}

	private static void createEvent() {
		TournamentHome tdao = new TournamentHome();
		Tournament t = tdao.findTourByName("Recreational Tournament");
		EventHome edao = new EventHome();
		CategoryHome cdao = new CategoryHome();
		Event event = new Event();
		Category c = cdao.findCategory("mini cadet", "male", "singles");
		event.setCategory(c);
		event.setEventName(c.getCategoryName() +"-"+c.getMatchType() +"-"+c.getGender()+"-"+c.getCategoryId()+"-"+t.getTourId());
		event.setTournament(t);
		edao.persist(event);

	}
	
	

	private static void createEvents() {
		TournamentHome tdao = new TournamentHome();
		Tournament t = tdao.findTourByName("Recreational Tournament");
		EventHome edao = new EventHome();
		CategoryHome cdao = new CategoryHome();
		Event event = new Event();
		Category c = cdao.findCategory("mini cadet", "male", "singles");
		event.setCategory(c);
		event.setEventName(c.getCategoryName() +"-"+c.getMatchType() +"-"+c.getGender()+"-"+c.getCategoryId()+"-"+t.getTourId());
		event.setTournament(t);
		edao.persist(event);
		
		event = new Event();
		c = cdao.findCategory("mini cadet", "female", "singles");
		event.setCategory(c);
		//event.setEventName(c.getCategoryName() +"-"+c.getMatchType() +"-"+c.getGender());
		event.setEventName(c.getCategoryName() +"-"+c.getMatchType() +"-"+c.getGender()+"-"+c.getCategoryId()+"-"+t.getTourId());
		event.setTournament(t);
		edao.persist(event);
		
	}

	public static void createTournament() {
		TournamentHome tdao = new TournamentHome();
		Tournament t = new Tournament();
		t.setOrganizer("ADKTTA");
		t.setTourName("Recreational Tournament");
		t.setVenue("ADKTTA");
		tdao.persist(t);
	}
	
	private static void createCategory(){
		CategoryHome cdao = new CategoryHome();
		Category c = new Category();
		c.setCategoryName("Non Medalist");
		c.setGender("mixed");
		c.setMatchType("singles");
		cdao.persist(c);
	}
	

	private static void createAllCategory() {
		CategoryHome cdao = new CategoryHome();
		Category c = new Category();
		c.setCategoryName("mini cadet");
		c.setGender("male");
		c.setMatchType("singles");
		cdao.persist(c);
		
		c = new Category();
		c.setCategoryName("mini cadet");
		c.setGender("male");
		c.setMatchType("doubles");
		cdao.persist(c);
		
		c = new Category();
		c.setCategoryName("mini cadet");
		c.setMatchType("singles");
		c.setGender("female");
		cdao.persist(c);
		
		c = new Category();
		c.setCategoryName("mini cadet");
		c.setMatchType("doubles");
		c.setGender("female");
		cdao.persist(c);
		
		c = new Category();
		c.setCategoryName("cadet");
		c.setGender("male");
		c.setMatchType("singles");
		cdao.persist(c);
		
		c = new Category();
		c.setCategoryName("cadet");
		c.setGender("male");
		c.setMatchType("doubles");
		cdao.persist(c);
		
		c = new Category();
		c.setCategoryName("cadet");
		c.setGender("female");
		c.setMatchType("singles");
		cdao.persist(c);

		c = new Category();
		c.setCategoryName("cadet");
		c.setGender("female");
		c.setMatchType("doubles");
		cdao.persist(c);
		
		c = new Category();
		c.setCategoryName("Sub Juniors");
		c.setGender("male");
		c.setMatchType("singles");
		cdao.persist(c);
		
		c = new Category();
		c.setCategoryName("Sub Juniors");
		c.setGender("male");
		c.setMatchType("doubles");
		cdao.persist(c);
		
		
		c = new Category();
		c.setCategoryName("Sub Juniors");
		c.setGender("female");
		c.setMatchType("singles");
		cdao.persist(c);
		
		c = new Category();
		c.setCategoryName("Sub Juniors");
		c.setGender("female");
		c.setMatchType("doubles");
		cdao.persist(c);
		
		c = new Category();
		c.setCategoryName("Juniors");
		c.setGender("male");
		c.setMatchType("singles");
		cdao.persist(c);
		
		c = new Category();
		c.setCategoryName("Juniors");
		c.setGender("male");
		c.setMatchType("doubles");
		cdao.persist(c);
		

		c = new Category();
		c.setCategoryName("Juniors");
		c.setGender("female");
		c.setMatchType("singles");
		cdao.persist(c);
		
		c = new Category();
		c.setCategoryName("Juniors");
		c.setGender("female");
		c.setMatchType("doubles");
		cdao.persist(c);
		
		c = new Category();
		c.setCategoryName("Youth");
		c.setGender("male");
		c.setMatchType("singles");
		cdao.persist(c);
		
		c = new Category();
		c.setCategoryName("Youth");
		c.setGender("male");
		c.setMatchType("doubles");
		cdao.persist(c);
		
		c = new Category();
		c.setCategoryName("Youth");
		c.setGender("female");
		c.setMatchType("singles");
		cdao.persist(c);
		
		c = new Category();
		c.setCategoryName("Youth");
		c.setGender("female");
		c.setMatchType("doubles");
		cdao.persist(c);
		
		c = new Category();
		c.setCategoryName("Mens");
		c.setGender("male");
		c.setMatchType("singles");
		cdao.persist(c);
		
		c = new Category();
		c.setCategoryName("Mens");
		c.setGender("male");
		c.setMatchType("doubles");
		cdao.persist(c);
		
		c = new Category();
		c.setCategoryName("Womens");
		c.setGender("female");
		c.setMatchType("singles");
		cdao.persist(c);
		
		c = new Category();
		c.setCategoryName("Womens");
		c.setGender("female");
		c.setMatchType("doubles");
		cdao.persist(c);
		

		c = new Category();
		c.setCategoryName("Seniors");
		c.setGender("mixed");
		c.setMatchType("doubles");
		cdao.persist(c);
		
	}
	
}
