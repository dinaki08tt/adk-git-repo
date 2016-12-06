package com.adk.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.adk.db.pingpong.PlayerDetails;
import com.adk.db.pingpong.PlayerDetailsHome;

public class ReadExcel 
{
	
	
	private static Object getCellValue(Cell cell) {
	    
		if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
		{
			if(HSSFDateUtil.isCellDateFormatted(cell))
		        return cell.getDateCellValue();
		}
	
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
			
		InputStream inputStream = null;
        inputStream = ReadExcel.class.getClassLoader().getResourceAsStream("player_entry.xlsx"); 
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
                    pl.setFatherName((String) getCellValue(nextCell));
                case 2:
                	pl.setMotherName((String) getCellValue(nextCell));
                    break;
                case 3:
                	pl.setOccupation((String) getCellValue(nextCell));
                    break; 
                case 4:
                	pl.setDOB((Date) getCellValue(nextCell));
                    break;
                case 5:
                	pl.setDOJ((Date) getCellValue(nextCell));
                    break;    
                case 6:
                	pl.setMobileNo(((Double)getCellValue(nextCell)).intValue());
                    break;    
                case 7:
                	pl.setAddress((String) getCellValue(nextCell));
                    break;
                case 8:
                	pl.setAge((Double) getCellValue(nextCell));
                    break;
                case 9:
                	pl.setIsParentPlayer((Boolean) getCellValue(nextCell));
                    break;
                case 10:
                	pl.setIsParentWillingLearn((Boolean) getCellValue(nextCell));
                    break;    
                case 11:
                	pl.setIsPlayerReferee((Boolean) getCellValue(nextCell));
                    break;
                case 12:
                	pl.setPlayerCode((String) getCellValue(nextCell));
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
	

	public static List<Entry> readEntryList() throws IOException{
			
		InputStream inputStream = null;
		
		inputStream = ReadExcel.class.getClassLoader().getResourceAsStream("entry_list.xlsx");
         
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
         List<Entry> listofPlayers = new ArrayList<Entry>();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            Entry entry = new Entry();
            while (cellIterator.hasNext()) {
                Cell nextCell = cellIterator.next();
                int columnIndex = nextCell.getColumnIndex();
     
                switch (columnIndex) {
                case 0:
                    entry.setName((String) getCellValue(nextCell));
                    break;
                case 1:
                    entry.setPlayerCode((String) getCellValue(nextCell));
                    break;
                case 2:
                	entry.setSeeding(((Double) getCellValue(nextCell)).intValue());
                    break;
               }
     
            }
            listofPlayers.add(entry);
        }
        
        
        inputStream.close();
        inputStream = null;
        
        return listofPlayers;
	}
	
	
	public static void main(String args[]){
//		populatePlayersToDB();
		try {
			System.out.println(readEntryList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void populatePlayersToDB() {
		PlayerDetailsHome dao = new PlayerDetailsHome();
		
		try {
			List<Player> pls = readPlayerList();
			
		Iterator<Player> itr = pls.iterator();
		while (itr.hasNext()) {
			Player player = (Player) itr.next();
			PlayerDetails pd = new PlayerDetails();
			pd.setPlayerName(player.getName());
			pd.setAddress(player.getAddress());
			pd.setAge(player.getAge().intValue());
			pd.setDateOfJoining(player.getDOJ());
			pd.setDob(player.getDOB());
			pd.setFatherName(player.getFatherName());
			pd.setMotherName(player.getMotherName());
			pd.setMobileNumber(player.getMobileNo().toString());
			pd.setOccupation(player.getOccupation());
			pd.setPlayerCode(player.getPlayerCode());
			pd.setIsParentPlayer(player.getIsParentPlayer());
			pd.setIsParentRefere(player.getIsPlayerReferee());
			pd.setIsParentWillingToLearn(player.getIsParentWillingLearn());
			System.out.println("Excel Record :"+player.toString());
			System.out.println("DB Pojo:"+pd.toString());
			dao.persist(pd);
		}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}

