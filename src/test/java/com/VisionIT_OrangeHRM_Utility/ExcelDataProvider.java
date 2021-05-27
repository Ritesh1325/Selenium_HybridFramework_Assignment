	package com.VisionIT_OrangeHRM_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Properties;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;

public class ExcelDataProvider 
{
	private String filePath = "./TestData/XL.xlsx";
	public Properties prop;
	
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	
	int colsCount, rowCunt;

	public ExcelDataProvider() 
	{
		try 
		{
			File f = new File(filePath);
			FileInputStream fis = new FileInputStream(f);
			
			wb = new XSSFWorkbook(fis);
		}
		catch (Exception e) 
		{
			Reporter.log("oops... Excel File Is Not Found >>>", true);
			e.printStackTrace();
		}
	}
	
	public String getStringCellData(String sheetName, int row, int cell)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
	}
	
	public int getNumericCellData(String sheetName, int row, int cell)
	{
		return (int) wb.getSheet(sheetName).getRow(row).getCell(cell).getNumericCellValue();
	}
	
	public String getStringCellData(int sheetIndex, int row, int cell)
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(cell).getStringCellValue();
	}
	
	public int getNumericCellData(int sheetIndex, int row, int cell)
	{
		return (int) wb.getSheetAt(sheetIndex).getRow(row).getCell(cell).getNumericCellValue();
	}
	
	public void setGreenColour()
	{
		try
		{
			FileOutputStream fio = new FileOutputStream(filePath);
			cell = row.createCell(rowCunt+1);
			CellStyle style1 = wb.createCellStyle();
			
			style1.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell.setCellValue("PASS"); 
	
			cell.setCellStyle(style1);
			wb.write(fio);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			Reporter.log("Style is not setting up >>>> ", true);
		}
	}
	
	public void setRedColour()
	{
		try
		{
			FileOutputStream fio = new FileOutputStream(filePath);
			cell = row.createCell(rowCunt+1);
			CellStyle style1 = wb.createCellStyle();
			
			style1.setFillForegroundColor(IndexedColors.RED.getIndex());
			style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell.setCellValue("FAIL"); 
	
			cell.setCellStyle(style1);
			wb.write(fio);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			Reporter.log("Style is not setting up >>>> ", true);
		}
	}
	
	public Object[][] excelTest111(String sheetName)
	{
		sheet = wb.getSheet(sheetName);
		
		rowCunt = sheet.getLastRowNum();
		System.out.println("Total Rows - "+ rowCunt);
		
		colsCount = sheet.getRow(0).getLastCellNum();
		System.out.println("Total Cols - " + colsCount);
		
		Object[][] data = new Object[rowCunt][colsCount];
		
		for (int r = 0; r < rowCunt; r++)
		{
			for (int c = 0; c < colsCount; c++)
			{
				data[r][c] = sheet.getRow(r).getCell(c).toString();// Heterogeneous data return
			}
		}
		return data;
	}
}
