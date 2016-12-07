package com.adk.msword;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.adk.db.pingpong.GroupMatchesDetails;

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

public static void main(String[] args)
{
	 XWPFWordExtractor we = null;
	  
    try
    {
    	XWPFDocument docx = new XWPFDocument(getFileInputStream());
    	we = new XWPFWordExtractor(docx);
 
    	List<XWPFParagraph> paras = docx.getParagraphs();
    	Iterator<XWPFParagraph> itr = paras.iterator();
    	while (itr.hasNext()) {
			XWPFParagraph para = (XWPFParagraph) itr.next();
			if(para.getText().contains("Category")){
				XWPFRun run = para.createRun();
				run.setText(": Sub-Juniros");
				 
			}
			if(para.getText().contains("Umpire")){
				XWPFRun run = para.createRun();
				run.setText(": Dinesh");
			}
			if(para.getText().contains("Round")){
				XWPFRun run = para.createRun();
				run.setText(": pre-quater");
			}
		}
    	
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

	public Boolean printScoreSheet(List<GroupMatchesDetails> grpMatches){
		
		XWPFWordExtractor we = null;
		XWPFDocument docx;
		try {
			
		docx = new XWPFDocument(getFileInputStream());
		we = new XWPFWordExtractor(docx);
		List<XWPFParagraph> paras = docx.getParagraphs();
	    
		Iterator<XWPFParagraph> itrpara = paras.iterator();
		
		Iterator<GroupMatchesDetails> itr = grpMatches.iterator();
		
		while (itr.hasNext()) {
			GroupMatchesDetails group = (GroupMatchesDetails) itr.next();
			
			group.getPlayer1Id();
			group.getPlayer2Id();
			group.getTournament().getCategory().getCategoryName();
			
		}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		
		return false;
	}

}