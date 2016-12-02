package com.adk.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeagueDesigner {
	
	//step1
		//1. There are list of players with seedings
		//2. Divide them into groups
		//3. group has 4 players
	public	static List<Group> designGroups(){
		List<Group> groups = new ArrayList<Group>();
		try {
			List<Player> all = ReadExcel.readPlayerList();
			 Collections.sort(all, new Comparator<Player>() {
					public int compare(Player o1, Player o2) {
						return (o1.getSeeding()).compareTo(o2.getSeeding());
					}
		        });
			
			//get even number group count
			int playerCount = all.size();
			int grpCnt = decideGroupCount(playerCount);
			
			//split the players into group
			
			int itr = 0;
			for(int i = 0; i< grpCnt; i++){
				Group g = new Group();
				g.setGroupName(String.valueOf(i));
				g.setGroupNumber(i);
				List<Player> players = new ArrayList<Player>();
				int itr2 = 0;
				while(itr2<4 && itr < all.size()){
					players.add(all.get(itr));
					itr++;itr2++;
				}
				g.setPlayers(players);
				groups.add(g);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return groups;
	}   


	
	public static void main(String... strings){
			
		System.out.println(designGroups());
		
	}



	private static int decideGroupCount(int playerCount) {
		int groupCount = 0;
		//1 group
		if(playerCount <= 4){
			groupCount = 1;
		}else if(playerCount > 4 && playerCount <= 8){
			groupCount = 2;
		}else if(playerCount > 8 && playerCount <= 16){
			groupCount = 2;
		}else if(playerCount >= 16){
			groupCount = 4;
		}
		
		return groupCount;
	}
}
