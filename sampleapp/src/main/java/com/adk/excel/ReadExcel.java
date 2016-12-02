package com.adk.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel 
{
	
	static File excel = new File("D:\\221013\\eclipse_wkspc\\git_local_repo\\adk-git-repo\\sampleapp\\src\\main\\resources\\tour.xlsx");
	
	private static Object getCellValue(Cell cell) {
	    switch (cell.getCellType()) {
	    case Cell.CELL_TYPE_STRING:
	        return cell.getStringCellValue();
	 
	    case Cell.CELL_TYPE_BOOLEAN:
	        return cell.getBooleanCellValue();
	 
	    case Cell.CELL_TYPE_NUMERIC:
	        return cell.getNumericCellValue();
	    }
	 
	    return null;
	}
	
	public static List<Player> readPlayerList() throws IOException{
		
		FileInputStream inputStream = null;
		inputStream = new FileInputStream(excel);
         
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
         List<Player> listofPlayers = new ArrayList<Player>();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
           Player pl = new Player();
     
            while (cellIterator.hasNext()) {
                Cell nextCell = cellIterator.next();
                int columnIndex = nextCell.getColumnIndex();
     
                switch (columnIndex) {
                case 0:
                    pl.setName((String) getCellValue(nextCell));
                    break;
                case 1:
                    pl.setSeeding((Double) getCellValue(nextCell));
                    break;
                case 2:
                   pl.setAge((Double) getCellValue(nextCell));
                    break;
                }
     
     
            }
            listofPlayers.add(pl);
        }
        
//        System.out.println(listofPlayers);
         
//        ((FileInputStream) workbook).close();
        inputStream.close();
        inputStream = null;
        
        return listofPlayers;
	}
	
	
	
	
}

