package com.adk.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.adk.db.pingpong.Category;
import com.adk.db.pingpong.CategoryHome;
import com.adk.db.pingpong.GroupMatchesDetails;
import com.adk.db.pingpong.GroupMatchesDetailsHome;
import com.adk.db.pingpong.PlayerDetails;
import com.adk.db.pingpong.PlayerDetailsHome;
import com.adk.db.pingpong.Tournament;
import com.adk.db.pingpong.TournamentHome;

public class LeagueDesigner {
	
	//step1
		//1. There are list of players with seedings
		//2. Divide them into groups
		//3. group has 4 players
	public	static List<Group> designGroups(){
		List<Group> groups = new ArrayList<Group>();
		try {
			List<Entry> all = ReadExcel.readEntryList();
//			 Collections.sort(all, new Comparator<Player>() {
//					public int compare(Player o1, Player o2) {
//						return (o1.getSeeding()).compareTo(o2.getSeeding());
//					}
//		        });
			
			//get even number group count
			int playerCount = all.size();
			int grpCnt = decideGroupCount(playerCount);
			System.out.println(grpCnt);
			//split the players into group
			
			int itr = 0;
			for(int i = 0; i< grpCnt; i++){
				Group g = new Group();
				g.setGroupName(String.valueOf(i));
				g.setGroupNumber(i);
				List<Entry> players = new ArrayList<Entry>();
				int itr2 = 0;
				while(itr2<4 && itr < all.size()){
					players.add(all.get(itr));
					itr++;itr2++;
				}
				g.setEntries(players);
				groups.add(g);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return groups;
	}  
	
	
	public static void main(String... strings){
		createTouranment();		
	}

	
	public static void main1(String... strings){

		Date matchdate = new Date();
		List<Group> grps = designGroups();
		PlayerDetailsHome pDao = new PlayerDetailsHome();
		TournamentHome tourDao = new TournamentHome();
		Tournament t = tourDao.findById(1); 
		GroupMatchesDetailsHome grpDao = new GroupMatchesDetailsHome();

		Iterator<Group> itrGrp = grps.iterator();
		int matchId = 0;
		while (itrGrp.hasNext()) {
			Group group = (Group) itrGrp.next();
			List<Entry> pls = group.getEntries();
			Iterator<Entry> itpls = pls.iterator();
			Entry[] parr = new Entry[4];
			int i = 0;
			while (itpls.hasNext()) {
				Entry player = (Entry) itpls.next();
				parr[i] = player;
				i++;
			}
			
			Entry p1 = parr[0];
			Entry p2 = parr[1];
			Entry p3 = parr[2];
			Entry p4 = parr[3];
			PlayerDetails pd = null;
			GroupMatchesDetails gmd = null;
			//p1 vs p2
			gmd = new GroupMatchesDetails();
			gmd.setTournament(t);
			gmd.setGroupName(group.getGroupName());
			gmd.setMatchId(++matchId);
			pd = pDao.findByPlayerCode(p1.getPlayerCode());
			gmd.setPlayer1Id(pd.getPlayerId());
			pd = pDao.findByPlayerCode(p2.getPlayerCode());
			gmd.setPlayer2Id(pd.getPlayerId());
			gmd.setMatchDate(matchdate);
			grpDao.persist(gmd);
			//p1 vs p3
			gmd = new GroupMatchesDetails();
			pd = pDao.findByPlayerCode(p1.getPlayerCode());
			gmd.setTournament(t);
			gmd.setGroupName(group.getGroupName());
			gmd.setMatchId(++matchId);
			pd = pDao.findByPlayerCode(p1.getPlayerCode());
			gmd.setPlayer1Id(pd.getPlayerId());
			pd = pDao.findByPlayerCode(p3.getPlayerCode());
			gmd.setPlayer2Id(pd.getPlayerId());
			gmd.setMatchDate(matchdate);
			grpDao.persist(gmd);
			//p1 vs p4
			gmd = new GroupMatchesDetails();
			pd = pDao.findByPlayerCode(p1.getPlayerCode());
			gmd.setTournament(t);
			gmd.setGroupName(group.getGroupName());
			gmd.setMatchId(++matchId);
			pd = pDao.findByPlayerCode(p1.getPlayerCode());
			gmd.setPlayer1Id(pd.getPlayerId());
			pd = pDao.findByPlayerCode(p4.getPlayerCode());
			gmd.setPlayer2Id(pd.getPlayerId());
			gmd.setMatchDate(matchdate);
			grpDao.persist(gmd);
			//p2 vs p3
			gmd = new GroupMatchesDetails();
			pd = pDao.findByPlayerCode(p1.getPlayerCode());
			gmd.setTournament(t);
			gmd.setGroupName(group.getGroupName());
			gmd.setMatchId(++matchId);
			pd = pDao.findByPlayerCode(p2.getPlayerCode());
			gmd.setPlayer1Id(pd.getPlayerId());
			pd = pDao.findByPlayerCode(p3.getPlayerCode());
			gmd.setPlayer2Id(pd.getPlayerId());
			gmd.setMatchDate(matchdate);
			grpDao.persist(gmd);
			//p2 vs p4
			gmd = new GroupMatchesDetails();
			pd = pDao.findByPlayerCode(p1.getPlayerCode());
			gmd.setTournament(t);
			gmd.setGroupName(group.getGroupName());
			gmd.setMatchId(++matchId);
			pd = pDao.findByPlayerCode(p2.getPlayerCode());
			gmd.setPlayer1Id(pd.getPlayerId());
			pd = pDao.findByPlayerCode(p4.getPlayerCode());
			gmd.setPlayer2Id(pd.getPlayerId());
			gmd.setMatchDate(matchdate);
			grpDao.persist(gmd);
			//p3 vs p4
			gmd = new GroupMatchesDetails();
			pd = pDao.findByPlayerCode(p1.getPlayerCode());
			gmd.setTournament(t);
			gmd.setGroupName(group.getGroupName());
			gmd.setMatchId(++matchId);
			pd = pDao.findByPlayerCode(p3.getPlayerCode());
			gmd.setPlayer1Id(pd.getPlayerId());
			pd = pDao.findByPlayerCode(p4.getPlayerCode());
			gmd.setPlayer2Id(pd.getPlayerId());
			gmd.setMatchDate(matchdate);
			grpDao.persist(gmd);
				
		}
	
	}



	public static void createTouranment() {
		Category c = new Category();
		c.setCategoryName("Sub-Juniors");
		CategoryHome dao = new CategoryHome();
		dao.persist(c);
		TournamentHome dao2 = new TournamentHome();
		Tournament t = new Tournament();
		t.setOrganizer("ADkTTA");
		t.setTourName("Recreational Tour");
		t.setVenue("ADKTTA");
		Category cc = dao.findById(1);
		t.setCategory(cc);
		dao2.persist(t);
	}



	private static int decideGroupCount(int playerCount) {
		
		int groupCount = 0;
		
		System.out.println(groupCount);
		//1 group
		if(playerCount <= 4){
			groupCount = 1;
		}else if(playerCount > 4 && playerCount <= 8){
			groupCount = 2;
		}else if(playerCount > 8 && playerCount < 16){
			groupCount = 2;
		}else if(playerCount >= 16){
			groupCount = 4;
		}
		
		return groupCount;
	}
}
