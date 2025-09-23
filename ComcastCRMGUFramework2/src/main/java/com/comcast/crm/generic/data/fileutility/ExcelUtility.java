package com.comcast.crm.generic.data.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	public String getDataFromExcel(String sheetName, int rowNum, int celNum) throws Exception
	{
		FileInputStream fis = new FileInputStream("./testData/testSciptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}
	
	public int getRowCount(String sheetName) throws Exception 
	{
		FileInputStream fis = new FileInputStream("./testData/testSciptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		wb.close();
		return rowCount;	
	}
	
	public void setDataIntoExcel(String sheetName, int rowNum, int celNum, String data) throws Exception
	{
		FileInputStream fis = new FileInputStream("./testData/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(celNum);
		
		FileOutputStream fos = new FileOutputStream("./testData/testScriptData.xlsx");
		wb.write(fos);
		wb.close();
		
	}
	
	
	
}
