package Selenium_Practice;

import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDriven 
{
	WebDriver d;
	String url = "https://opensource-demo.orangehrmlive.com";
	String excelPath = "F:\\Selenium Project 2021\\Project Material\\ExcelTestData.xlsx";
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	int rowCount, cellCount;
	
	WebElement userName = d.findElement(By.id("txtUsername"));
	WebElement pass = d.findElement(By.id("txtPassword"));
	WebElement login = d.findElement(By.id("btnLogin"));
	WebElement welcomeLink = d.findElement(By.id("welcome"));
	
	public void launchApp()
	{
//		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		d = new ChromeDriver();
		d.get(url);
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void closeApp()
	{
		if (d != null) 
		{
			d.quit();
		}
	}
	public void loginTest() throws Exception
	{
		for (int r = 0; r < rowCount; r++) 
		{
			userName.sendKeys(getStringCellData("Login", 1, 1));
			pass.sendKeys(getStringCellData("Login", 1, 2));
			login.click();
			
			if (welcomeLink.isDisplayed()) 
			{
				getPassStatus("Login", r, sheet.getRow(r).getLastCellNum()+1);
			}
			else 
			{
				getFailStatus("Login", r, sheet.getRow(r).getLastCellNum()+1);				
			}
		}
	}
	public String getStringCellData(String sheetName, int row, int cell)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
	}
	
	public void getPassStatus(String sheetName, int rowNo, int cellNo) throws Exception
	{
		File f = new File(excelPath);
		FileOutputStream fio = new FileOutputStream(f);
		
		wb = new XSSFWorkbook();
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNo);
		cell = row.createCell(cellNo);
		cell.setCellValue("PASS");
		
		CellStyle style1 = wb.createCellStyle();
		style1.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style1);
		
		wb.write(fio);
		
		wb.close();
		fio.close();
	}
	
	public void getFailStatus(String sheetName, int rowNo, int cellNo) throws Exception
	{
		File f = new File(excelPath);
		FileOutputStream fio = new FileOutputStream(f);
		
		wb = new XSSFWorkbook();
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNo);
		cell = row.createCell(cellNo);
		cell.setCellValue("PASS");
		
		CellStyle style1 = wb.createCellStyle();
		style1.setFillForegroundColor(IndexedColors.RED.getIndex());
		style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style1);
		
		wb.write(fio);
		
		wb.close();
		fio.close();
	}

	public static void main(String[] args) throws Exception
	{
		DataDriven d = new DataDriven();
		
		d.launchApp();
		d.loginTest();
		d.closeApp();
	}
}
