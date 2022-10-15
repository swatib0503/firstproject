package com.bankingproject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exeldata {
	
	public static String getdata(int i, int j) throws IOException {
		File file = new File("C:\\Users\\swati\\OneDrive\\Desktop\\fileframeworkuse.xlsx");
		
		FileInputStream inputstream = new FileInputStream(file);
		
		
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(inputstream);
		
		XSSFSheet sheet = wb.getSheet("sheet1");
		
		XSSFRow row = sheet.getRow(i);
		XSSFCell cell = row.getCell(j);
		
		String data = cell.getStringCellValue();
		return data;
		
			}

}
