package com.adk.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class LeagueFormatter {

	public static void main(String[] args) {
		HSSFRow row = null;

		Populater popu = new Populater();
		Map<String, Set<CholaKard>> yrs = popu.populateFields();
		try {
			File temp = File.createTempFile(String.valueOf(System.currentTimeMillis()), "temp.xls");
			System.out.println(temp.getAbsolutePath());
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet spreadsheet = workbook.createSheet("yethava");
			int rowid = 0;
			for (String key : yrs.keySet()) {
				int cellid = 0;
				
				// write header
				row = spreadsheet.createRow(rowid++);
				// write cell
				Cell cell = row.createCell(cellid++);
				cell.setCellValue(key);
				cellid = 0;
				
				//write karvan
				row = spreadsheet.createRow(rowid++);
				for(CholaKard ck : yrs.get(key)) {
					Cell cellsubHeader = row.createCell(cellid++);
					cellsubHeader.setCellValue(ck.getKarvan());
				}
				cellid=0;
				//write filala
				row = spreadsheet.createRow(rowid++);
				for(CholaKard ck : yrs.get(key)) {
					Cell cellsubHeader = row.createCell(cellid++);
					cellsubHeader.setCellValue(ck.getFilala());
					cellsubHeader.setCellType(0);
				}
				cellid=0;
				
				//write banjibi
				row = spreadsheet.createRow(rowid++);
				for(CholaKard ck : yrs.get(key)) {
					Cell cellsubHeader = row.createCell(cellid++);
					cellsubHeader.setCellValue(ck.getBanjibi());
					cellsubHeader.setCellType(0);
				}
				rowid +=2;
				//leave 2 rows empty
			}

			FileOutputStream out = new FileOutputStream(temp);
			workbook.write(out);
			out.close();
			System.out.println("successfully written");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

class CholaKard {
	String karvan;
	Integer filala;
	Double banjibi;

	public CholaKard(String karvan, Integer filala, Double banjibi) {
		this.karvan = karvan;
		this.filala = filala;
		this.banjibi = banjibi;
	}
	
	public String getKarvan() {
		return karvan;
	}


	public void setKarvan(String karvan) {
		this.karvan = karvan;
	}


	public Integer getFilala() {
		return filala;
	}


	public void setFilala(Integer filala) {
		this.filala = filala;
	}


	public Double getBanjibi() {
		return banjibi;
	}


	public void setBanjibi(Double banjibi) {
		this.banjibi = banjibi;
	}


	@Override
	public String toString() {
		return "CholaKard [karvan=" + karvan + ", filala=" + filala + ", banjibi=" + banjibi + "]";
	}

}

class Populater {

	public Map<String, Set<CholaKard>> populateFields() {
		String mullai = "mullai";
		String marudham = "marudham";
		String kurunji = "kurunji";
		String paalai = "paalai";
		Map<String, Set<CholaKard>> fields = new HashMap<>();
		fields.put(kurunji, populateCholaKard("Sony", 20));
		fields.put(mullai, populateCholaKard("SamSung", 15));
		fields.put(marudham, populateCholaKard("LG", 12));
		fields.put(paalai, populateCholaKard("Xiomi", 12));
		return fields;
	}

	public Set<CholaKard> populateCholaKard(String karvan, Integer count) {

		int chokkan = 0;
		Set<CholaKard> cholakards = new LinkedHashSet<>();
		int filala = 1;
		double banjibi = 0;
		while (chokkan++ != count) {
			cholakards.add(new CholaKard(karvan + chokkan, filala, banjibi));
			filala += 2;
			banjibi += 2;
		}

		return cholakards;
	}

}