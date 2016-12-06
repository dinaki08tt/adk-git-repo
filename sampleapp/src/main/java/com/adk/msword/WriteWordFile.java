package com.adk.msword;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class WriteWordFile    {
	   //Blank Document

public static void main(String... args){

	   XWPFDocument document= new XWPFDocument();
       
	   //Write the Document in file system
	   URL url = WriteWordFile.class.getClassLoader().getResource("score_sheet.docx");
	   
	   File word = new File(url.getPath());

	   FileOutputStream out = null;
	try {
		out = new FileOutputStream(word);
	    
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

}