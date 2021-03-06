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
import com.adk.freemarker.WriteFile;
import com.adk.msword.WriteWordFile;

public class MainRun {

	public static void main(String args[]){
	//create category
//		createCategory();
		CategoryHome.getInstance().createAllCategory();
		//create tournament
//		createTournament();
//		createEvent();
//		createEvents();
		
		//populate Players to DB
//		ReadExcel.populatePlayersToDB();
		//get entry to tournament & design league
//		LeagueDesigner.createGroupMatchForEvent("mini cadet-singles-male-1-1");
		
//		List<Event> events = getAllEventsForTour();

		//print score sheet
//		WriteFile.printScoreSheet(events);

		//print a group sheet
//		WriteFile.printGroupSheet(events);
	}
	
	private static List<Event> getAllEventsForTour() {
		TournamentHome tdao = TournamentHome.getInstance();
		Tournament t = tdao.findTourByName("Recreational Tournament");
		EventHome edao = EventHome.getInstance();
		List<Event> list = edao.findByTournament(t);
		return list;
	}

	private static void createEvent() {
		TournamentHome tdao = TournamentHome.getInstance();
		Tournament t = tdao.findTourByName("Recreational Tournament");
		EventHome edao = EventHome.getInstance();
		CategoryHome cdao = CategoryHome.getInstance();
		Event event = new Event();
		Category c = cdao.findCategory("mini cadet", "male", "singles");
		event.setCategory(c);
		event.setEventName(c.getCategoryName() +"-"+c.getMatchType() +"-"+c.getGender()+"-"+c.getCategoryId()+"-"+t.getTourId());
		event.setTournament(t);
		edao.persist(event);

	}
	
	

	private static void createEvents() {
		TournamentHome tdao = TournamentHome.getInstance();
		Tournament t = tdao.findTourByName("Recreational Tournament");
		EventHome edao = EventHome.getInstance();
		CategoryHome cdao = CategoryHome.getInstance();
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
		TournamentHome tdao = TournamentHome.getInstance();
		Tournament t = new Tournament();
		t.setOrganizer("ADKTTA");
		t.setTourName("Recreational Tournament");
		t.setVenue("ADKTTA");
		tdao.persist(t);
	}
	
	private static void createCategory(){
		CategoryHome cdao = CategoryHome.getInstance();
		Category c = new Category();
		c.setCategoryName("Non Medalist");
		c.setGender("mixed");
		c.setMatchType("singles");
		cdao.persist(c);
	}
	

	
	
}
