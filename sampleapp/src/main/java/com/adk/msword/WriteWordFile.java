package com.adk.msword;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.adk.db.pingpong.Event;
import com.adk.db.pingpong.GroupMatchesDetails;
import com.adk.db.pingpong.PlayerDetails;
import com.adk.db.pingpong.PlayerDetailsHome;

//import org.apache.poi.hwpf.HWPFDocument;
//import org.apache.poi.hwpf.extractor.WordExtractor;

import com.adk.utils.Constants;

public class WriteWordFile {

public static void main1(String... args){

	FileOutputStream out = null;
	try {
		
	out = getFileOutputStream();
	
	
	   XWPFDocument document= new XWPFDocument();
        
		 XWPFParagraph title = document.createParagraph();
		 XWPFRun run= title.createRun();
		 run.setText("ADK Table Tennis Academy");
		 
		 XWPFParagraph category = document.createParagraph();
		 XWPFRun run1= category.createRun();
		 run1.setText("Sub Juniors");
		
		
	   //create table
	   XWPFTable table = document.createTable();
	   
	   XWPFTableRow tableRowThree = table.getRow(0);
	   tableRowThree.getCell(0).setText("Player Name");
	   tableRowThree.addNewTableCell().setText(" Game1 ");
	   tableRowThree.addNewTableCell().setText(" Game2 ");
	   tableRowThree.addNewTableCell().setText(" Game3 ");
	   tableRowThree.addNewTableCell().setText(" Game4 ");
	   tableRowThree.addNewTableCell().setText(" Game5 ");
		
	   //create first row
	   XWPFTableRow tableRowOne = table.createRow();
//	   tableRowOne.addNewTableCell().setText(" player1 score  ");
//	   tableRowOne.addNewTableCell().setText(" player1 score  ");
//	   tableRowOne.addNewTableCell().setText(" player1 score  ");
//	   tableRowOne.addNewTableCell().setText(" player1 score  ");
//	   tableRowOne.addNewTableCell().setText(" player1 score  ");
	   tableRowOne.getCell(0).setText("Player1 Name");
	   tableRowOne.getCell(1).setText(" player1 score  ");
	   tableRowOne.getCell(2).setText(" player1 score  ");
	   tableRowOne.getCell(3).setText(" player1 score  ");
	   tableRowOne.getCell(4).setText(" player1 score  ");
	   tableRowOne.getCell(5).setText(" player1 score  ");
	   
	   //create second row
	   XWPFTableRow tableRowTwo = table.createRow();
	   tableRowTwo.getCell(0).setText("Player2 Name");
	   tableRowTwo.getCell(1).setText(" player2 score  ");
	   tableRowTwo.getCell(2).setText(" player2 score  ");
	   tableRowTwo.getCell(3).setText(" player2 score  ");
	   tableRowTwo.getCell(4).setText(" player2 score  ");
	   tableRowTwo.getCell(5).setText(" player2 score  ");
	   
	   
		 XWPFParagraph umpireSign = document.createParagraph();
		 XWPFRun run2= umpireSign.createRun();
		 run2.setText("Umpire Sign");


		 XWPFParagraph winnerSign = document.createParagraph();
		 XWPFRun run3= winnerSign.createRun();
		 run3.setText("Winner Sign");
	   
	   
	   document.write(out);
	   out.close();
	   
	   System.out.println("score_sheet.docx written successully");
	   
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public static FileOutputStream getFileOutputStream(String name) throws IOException {
	String suffix_file_name = "score_sheet_";
	String ext = ".docx";
	FileOutputStream out = null;
	File msword = null;
	if(Constants.OUTPUT_DIR.isDirectory()){
		msword = new File(Constants.OUTPUT_DIR, "msword");
	}
	
	File[] files = msword.listFiles();
	
	for(File f : files){
		
		if(f.getName().equalsIgnoreCase(suffix_file_name)){
			f.delete();
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			out = new FileOutputStream(f);
		}
	}
	
	File newFile = new File(msword, suffix_file_name+name+ext);
	if(newFile.exists()){
		out = new FileOutputStream(newFile);
	}else{
		newFile.createNewFile();
		out = new FileOutputStream(newFile);
	}
	
	return out;
}



public static FileOutputStream getFileOutputStream() throws FileNotFoundException {
	FileOutputStream out = null;
	File msword = null;
	if(Constants.OUTPUT_DIR.isDirectory()){
		msword = new File(Constants.OUTPUT_DIR, "msword");
	}
	File[] files = msword.listFiles();
	
	for(File f : files){
		if(f.getName().equalsIgnoreCase("score_sheet.docx")){
			
			f.delete();
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			out = new FileOutputStream(f);
		}
	}
	return out;
}

public static FileInputStream getFileInputStream() throws FileNotFoundException {
	InputStream in = null;
	File msword = null;
	if(Constants.OUTPUT_DIR.isDirectory()){
		msword = new File(Constants.OUTPUT_DIR, "msword");
	}
	File[] files = msword.listFiles();
	
	for(File f : files){
		if(f.getName().equalsIgnoreCase("score_sheet_template.docx")){
			in = new FileInputStream(f);
		}
	}
	return (FileInputStream) in;
}

public static void main11(String... strings){

	 XWPFWordExtractor we = null;
	 XWPFDocument docx = null;
	try {
		docx = new XWPFDocument(getFileInputStream());
		we = new XWPFWordExtractor(docx);
 		
		System.out.println("========== Table Content =========");
		String ppos ="P11";
		String player ="Dinesh";
		
		replaceTableValue(docx, ppos, player);
		
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(we !=null)
				we.close();
		} catch (IOException e) {
			we = null;
		}
	}
}

public static void replaceTableValue(XWPFDocument docx, String ppos, String player) {
	List<XWPFTable> tables = docx.getTables();
	Iterator<XWPFTable> itrt = tables.iterator();
//	int i = 0;
	while (itrt.hasNext()) {
//		System.out.println(i++);
		XWPFTable table = (XWPFTable) itrt.next();
		List<XWPFTableRow> rows = table.getRows();
		Iterator<XWPFTableRow> itrrow = rows.iterator();
		while (itrrow.hasNext()) {
			XWPFTableRow row = (XWPFTableRow) itrrow.next();
			XWPFTableCell cell = row.getCell(0);
			String old = cell.getText();
			if(old.equalsIgnoreCase(ppos)){
				String v = old.replace(old, player);
				cell.setText(": "+v);
			}
			
		}
		
	}
}

public static void main(String[] args)
{
	 XWPFWordExtractor we = null;
	  
    try
    {
    	XWPFDocument docx = new XWPFDocument(getFileInputStream());
    	we = new XWPFWordExtractor(docx);
    	
    	String categoryName = null;
    	String matchType = null;
    	String round = null;
    	String position = null;
    	categoryName = "Sub Juniors";
    	matchType = "doubles";
    	round = "One";
    	position ="1";
    	replacePara(docx, categoryName, matchType, "female", round, position);
    	categoryName = "Sub Juniors";
    	matchType = "doubles";
    	round = "One";
    	position ="2";
    	replacePara(docx, categoryName, matchType, "female",round, position);
    	categoryName = "Sub Juniors";
    	matchType = "doubles";
    	round = "One";
    	position ="3";
    	replacePara(docx, categoryName, matchType, "female",round, position);
    	
    	position = "4";
    	replaceUmpireWinner(docx, position);

    	String ppos ="P31";
		String player ="Dinesh";
		
		replaceTableValue(docx, ppos, player);
		
		ppos ="P32";
		player ="Gopal";
		
		replaceTableValue(docx, ppos, player);
	 	
    	docx.write(getFileOutputStream());
    	 System.out.println("score_sheet.docx written successully");
    }
    catch (Exception exep)
    {
        exep.printStackTrace();
    }finally {
		try {
			if(we!=null)
				we.close();
		} catch (IOException e) {
			we = null;
		}
	}
}

public static void replaceUmpireWinner(XWPFDocument docx, String pos) {
	List<XWPFParagraph> paras = docx.getParagraphs();
	Iterator<XWPFParagraph> itr = paras.iterator();
	
	while (itr.hasNext()) {
		XWPFParagraph para = (XWPFParagraph) itr.next();
	
		List<XWPFRun> runs = para.getRuns();
		XWPFRun r1 = para.createRun(); 
		String text = para.getText();
		if(text.contains(pos)){
			for (XWPFRun r : runs) { 
				r.setText("Umpire Name & Sign"+"                                                                                                     "+"Winner Name & Sign", 0); 
			} 
			text = text.replace(pos, "  "); 
			r1.setText(text,0);
		}
				
	}
}


public static void replacePlayer(XWPFDocument docx, String pos, String playerName) {
	List<XWPFParagraph> paras = docx.getParagraphs();
	Iterator<XWPFParagraph> itr = paras.iterator();
	
	while (itr.hasNext()) {
		XWPFParagraph para = (XWPFParagraph) itr.next();
	
		List<XWPFRun> runs = para.getRuns();
		XWPFRun r1 = para.createRun(); 
		String text = para.getText();
		if(text.contains(pos)){
			for (XWPFRun r : runs) { 
				r.setText(playerName, 0); 
			} 
			text = text.replace(pos, " "); 
			r1.setText(text,0);
		}
		
				
	}
}

public static void replacePara(XWPFDocument docx, String categoryName, String matchType, String gender, String round,
		String position) {
	List<XWPFParagraph> paras = docx.getParagraphs();
	Iterator<XWPFParagraph> itr = paras.iterator();
	
	while (itr.hasNext()) {
		XWPFParagraph para = (XWPFParagraph) itr.next();
	
		List<XWPFRun> runs = para.getRuns();
		String text = para.getText();
		if(text.contains(position)){
			for (XWPFRun r : runs) { 
				r.setText("Category : "+categoryName+"                   "+"Gender : "+gender+"                   "+"Type : "+matchType+"                     "+"Round : "+round, 0); 
			} 
			text = text.replace(position, "  "); 
			
			XWPFRun r1 = para.createRun(); 
			r1.setText(text,0);
		}
		
				
	}
}

	public static Boolean printScoreSheet(List<Event> events){
		

		XWPFWordExtractor we = null;		
		try {

			XWPFDocument docx;
			
			
		Iterator<Event> itr = events.iterator();
		while (itr.hasNext()) {
			Event event = (Event) itr.next();
			Set groups = event.getGroupMatchesDetailses();
			
			Object[] arrGrp = groups.toArray();
			
//			for(int j = 0; j < arrGrp.length; j++){
			int j = 0;
			GroupMatchesDetails match = null;
			while(j < arrGrp.length){
			docx = new XWPFDocument(getFileInputStream());
			we = new XWPFWordExtractor(docx);
				//replace 1	
			match = (GroupMatchesDetails) arrGrp[j];

				//replace place holders
				replacePara(docx, event.getCategory().getCategoryName(), event.getCategory().getMatchType(), event.getCategory().getGender(), "One", "1");
				String playerName = getPlayerName(match.getPlayer1Id());
				replaceTableValue(docx, "P11", playerName);
				playerName = getPlayerName(match.getPlayer2Id());
				replaceTableValue(docx, "P12", playerName);
				
			j++;
			//replace 2
			match = (GroupMatchesDetails) arrGrp[j];

			//replace place holders
			
			replacePara(docx, event.getCategory().getCategoryName(), event.getCategory().getMatchType(), event.getCategory().getGender(), "One", "2");
			playerName = getPlayerName(match.getPlayer1Id());
			replaceTableValue(docx, "P21", playerName);
			playerName = getPlayerName(match.getPlayer2Id());
			replaceTableValue(docx, "P22", playerName);
			
			j++;
			//replace 3
			match = (GroupMatchesDetails) arrGrp[j];

			//replace place holders
			
			replacePara(docx, event.getCategory().getCategoryName(), event.getCategory().getMatchType(), event.getCategory().getGender(), "One", "3");
			playerName = getPlayerName(match.getPlayer1Id());
			replaceTableValue(docx, "P31", playerName);
			playerName = getPlayerName(match.getPlayer2Id());
			replaceTableValue(docx, "P32", playerName);
			j++;
						
	    	replaceUmpireWinner(docx, "4");
			
	    	docx.write(getFileOutputStream(String.valueOf(j)));
			}	
				
			
		}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(we != null)
						we.close();
				} catch (IOException e) {
					we = null;
				}
		}
    	
		return false;
	}
	
	
	static PlayerDetailsHome pdao = new PlayerDetailsHome();
	private static String getPlayerName(Integer player1Id) {
		PlayerDetails p = pdao.findById(player1Id);
		return p.getPlayerName();
	}

}