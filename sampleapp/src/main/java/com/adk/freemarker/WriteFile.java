package com.adk.freemarker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.adk.db.pingpong.Event;
import com.adk.db.pingpong.GroupMatchesDetails;
import com.adk.db.pingpong.GroupMatchesDetailsHome;
import com.adk.db.pingpong.PlayerDetails;
import com.adk.db.pingpong.PlayerDetailsHome;
import com.adk.utils.Constants;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

public class WriteFile {
	
	
	public static void main(String args[]){
		List<ScoreSheetVO> sett = new ArrayList<ScoreSheetVO>();
		ScoreSheetVO score = new ScoreSheetVO();
		score.setCategory("Mens");
		score.setMatchId("123");
		score.setPlayer1("Dinesh");
		score.setPlayer2("Ramesh");
		score.setGroupName("Groupname");
		score.setTableNo("1");
		score.setType("Singles");
		score.setRound("1");
		
		sett.add(score);
		score = new ScoreSheetVO();
		score.setCategory("Mens");
		score.setMatchId("123");
		score.setPlayer1("Dinesh");
		score.setPlayer2("Ramesh");
		score.setGroupName("Groupname");
		score.setTableNo("1");
		score.setType("Singles");
		score.setRound("1");
		sett.add(score);
		score = new ScoreSheetVO();
		score.setCategory("Mens");
		score.setMatchId("123");
		score.setPlayer1("Dinesh");
		score.setPlayer2("Ramesh");
		score.setGroupName("Groupname");
		score.setTableNo("1");
		score.setType("Singles");
		score.setRound("1");
		sett.add(score);
        scoreSheetWriter(sett,"1");
	}

	private static void scoreSheetWriter(List<ScoreSheetVO> sett, String fileName) {
		Writer fileWriter = null;
		try {
		 // 1. Configure FreeMarker
        //
        // You should do this ONLY ONCE, when your application starts,
        // then reuse the same Configuration object elsewhere.

        Configuration cfg = new Configuration();

        // Where do we load the templates from:
//        cfg.setClassForTemplateLoading(WriteFile.class, "");
        File templateLocation = new File(Constants.OUTPUT_DIR, "freemarker");
        cfg.setDirectoryForTemplateLoading(templateLocation);
        // Some other recommended settings:
        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        // 2. Proccess template(s)
        //
        // You will do this for several times in typical applications.

        // 2.1. Prepare the template input:

        Map<String, Object> input = new HashMap<String, Object>();
        
        input.put("objs", sett);
        
        // 2.2. Get the template
      
        Template template = cfg.getTemplate("score_sheet_template.ftl");

        // 2.3. Generate the output

        // Write output to the console
       // Writer consoleWriter = new OutputStreamWriter(System.out);
       // template.process(input, consoleWriter);

        // For the sake of example, also write output into a file:
        File print = new File(Constants.OUTPUT_DIR,"printouts/scoresheets/scoresheet_"+fileName+".html");
        fileWriter = new FileWriter(print);
        template.process(input, fileWriter);
        
        } catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
                try {
                	if(fileWriter!=null)
					fileWriter.close();
				} catch (IOException e) {
					fileWriter = null;
				}
        }
	}
	
	private static void groupSheetWriter(List<GroupSheetVO> sett, String fileName) {
		Writer fileWriter = null;
		try {
		 // 1. Configure FreeMarker
        //
        // You should do this ONLY ONCE, when your application starts,
        // then reuse the same Configuration object elsewhere.

        Configuration cfg = new Configuration();

        // Where do we load the templates from:
//        cfg.setClassForTemplateLoading(WriteFile.class, "");
        File templateLocation = new File(Constants.OUTPUT_DIR, "freemarker");
        cfg.setDirectoryForTemplateLoading(templateLocation);
        // Some other recommended settings:
        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        // 2. Proccess template(s)
        // You will do this for several times in typical applications.
        // 2.1. Prepare the template input:
        Map<String, Object> input = new HashMap<String, Object>();
        input.put("objs", sett);
        // 2.2. Get the template
        Template template = cfg.getTemplate("group_sheet_template.ftl");
        // 2.3. Generate the output
        // Write output to the console
       // Writer consoleWriter = new OutputStreamWriter(System.out);
       // template.process(input, consoleWriter);
        // For the sake of example, also write output into a file:
        File print = new File(Constants.OUTPUT_DIR,"printouts/groupsheets/groupsheet_"+fileName+".html");
        fileWriter = new FileWriter(print);
        template.process(input, fileWriter);
        
        } catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
                try {
                	if(fileWriter!=null)
					fileWriter.close();
				} catch (IOException e) {
					fileWriter = null;
				}
        }
	}
	
	@SuppressWarnings("unchecked")
	public static void printScoreSheet(List<Event> events){
		
		Iterator<Event> itEvent = events.iterator();
		while (itEvent.hasNext()) {
			Event event = (Event) itEvent.next();
			Set matches = event.getGroupMatchesDetailses();
			List matchesList = new ArrayList(matches);
			
			Collections.sort(matchesList, new Comparator<GroupMatchesDetails>() {

				public int compare(GroupMatchesDetails o1, GroupMatchesDetails o2) {
					return o1.getGroupId() - o2.getGroupId();
				}
			});
			
			List<ScoreSheetVO> sheets = new ArrayList<ScoreSheetVO>();

			Iterator itrMatch = matchesList.iterator();
			while (itrMatch.hasNext()) {
				GroupMatchesDetails match = (GroupMatchesDetails) itrMatch.next();
				ScoreSheetVO sheet = new ScoreSheetVO();
				sheet.setCategory(event.getCategory().getCategoryName());
				sheet.setGroupName(match.getGroupName());
				sheet.setMatchId(String.valueOf(match.getMatchId()));
				sheet.setPlayer1(getPlayerName(match.getPlayer1Id()));
				sheet.setPlayer2(getPlayerName(match.getPlayer2Id()));
				sheet.setRound("1");
				sheet.setType(event.getCategory().getMatchType());
				sheet.setTableNo("1");
				sheets.add(sheet);
			}
			

			List<List<ScoreSheetVO>> writeList = new ArrayList<List<ScoreSheetVO>>();
			Iterator<ScoreSheetVO> itrSheets = sheets.iterator();
			
			while (itrSheets.hasNext()) {
				List<ScoreSheetVO> list = new ArrayList<ScoreSheetVO>();
					int i = 0; 
					while(itrSheets.hasNext() && i < 3){
						ScoreSheetVO scoreSheetVO = (ScoreSheetVO) itrSheets.next();
						list.add(scoreSheetVO);
						i++;
					}
					writeList.add(list);
				}
			
			Iterator<List<ScoreSheetVO>> ii = writeList.iterator();
			int j = 0;
			while (ii.hasNext()) {
				List<ScoreSheetVO> list = (List<ScoreSheetVO>) ii.next();
				scoreSheetWriter(list, String.valueOf(j++));
			}
			
			
		}
	
		
	}
	

	public static void printGroupSheet(List<Event> events) {
		
		try {
			Iterator<Event> itr = events.iterator();
			List<GroupSheetVO> groupsheets = new ArrayList<GroupSheetVO>();
				while (itr.hasNext()) {
					Event event = (Event) itr.next();
					//4 groups
					List<String> list = listDistinctGroupsByEvent(event); // unique group Names By Eventid
					Iterator<String> it = list.iterator();
					//per event
					while (it.hasNext()) {
						Set<Integer> pId = new HashSet<Integer>(); // four players from a group
						String groupName = it.next();
						//6 matches
						List<GroupMatchesDetails> groups = findAllGroupsByGroupName(groupName, event);
						Iterator<GroupMatchesDetails> itrgrp = groups.iterator();
						while (itrgrp.hasNext()) {
							GroupMatchesDetails match = (GroupMatchesDetails) itrgrp.next();
							pId.add(match.getPlayer1Id());
							pId.add(match.getPlayer2Id());
						}
						Object[] arrI = null;
						arrI = pId.toArray();
						GroupSheetVO vo = new GroupSheetVO();
						vo.setCategory(event.getCategory().getCategoryName());
						vo.setType(event.getCategory().getMatchType());
						vo.setGroupName(groupName);
						vo.setRound("1");
						vo.setTableNo("1");
						//four players
						String player = getPlayerName((Integer) arrI[0]);
						vo.setPlayer1(player);
						player = getPlayerName((Integer) arrI[1]);
						vo.setPlayer2(player);
						player = getPlayerName((Integer) arrI[2]);
						vo.setPlayer3(player);
						player = getPlayerName((Integer) arrI[3]);
						vo.setPlayer4(player);
						groupsheets.add(vo);
					}
					
					
					
			
				}
				int jj =0;
				groupSheetWriter(groupsheets, String.valueOf(jj++));
			
		} finally {
			
		}
	}
	
	
	
	private static PlayerDetailsHome pdao = PlayerDetailsHome.getInstance();
	private static String getPlayerName(Integer player1Id) {
		PlayerDetails p = pdao.findById(player1Id);
		return p.getPlayerName();
	}
	
	private static GroupMatchesDetailsHome gDao = GroupMatchesDetailsHome.getInstance();
	
	/**
	 * 
	 * @param Event
	 * @return
	 */
	private static List<String> listDistinctGroupsByEvent(Event e) {
		List<String> list = gDao.findDistinctGroupNameByEventid(e.getEventId());
		return list;
	}
	
	/**
	 * 
	 * @param groupName
	 * @param Event
	 * @return
	 */
	private static List<GroupMatchesDetails> findAllGroupsByGroupName(String groupName, Event e) {
		List<GroupMatchesDetails> all = gDao.findGroupsByGroupNameAndEvent(groupName, e.getEventId());
		return all;
	}
}
