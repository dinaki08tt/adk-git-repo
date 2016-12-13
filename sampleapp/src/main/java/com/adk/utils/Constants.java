package com.adk.utils;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Constants {

	private static final String OUTPUT_FOLDER = "D:\\221013\\eclipse_wkspc\\git_local_repo\\adk-git-repo\\sampleapp\\output";
	public static File OUTPUT_DIR = new File(OUTPUT_FOLDER);
	
	
	public static String getEventName(String categoryName, String matchType, String gender, Integer categoryId, Integer tourId){
		final String seperator = "-";
		String result = categoryName+seperator+matchType+seperator+gender+seperator+categoryId+seperator+tourId;
		return result;
	}
	
	
	public static Date getDate(String date) {
		SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd" );
		try {
			return df.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
