package com.VisionIT_OrangeHRM_Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Helper 
{
	static WebDriver d;
	private static String filePath = "./Screenshots/AutomationTest.html";

	public static void selectUtility(WebElement ele, String value)
	{
		try 
		{
			Select sel = new Select(ele);
			java.util.List<WebElement> options = sel.getOptions();
			
			for (WebElement str : options) 
			{
				if (value.equalsIgnoreCase(str.getText()))
				{
					str.click();
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static int getRandomNo_000()
	{
		Random rand = new Random();
		int randomInt = rand.nextInt(999);
		
		return randomInt;
	}
	
	public static void selectByDropDownValue(WebElement ele, String value)
	{
		Select sel = new Select(ele);
		sel.selectByValue(value);
	}
	
	public static void selectByDropDownVisibleText(WebElement ele, String visibleText)
	{
		new Select(ele).selectByVisibleText(visibleText);
	}
	
	public static void selectByDropDownIndex(WebElement ele, int index)
	{
		new Select(ele).selectByIndex(index);
	}
	
	public static void moveToImgContainer(WebDriver d, WebElement ele)
	{
		Actions builder = new Actions(d);
		Action act = builder.moveToElement(ele).build();
			act.perform();
	}
	
	public static void takeScreenShot(String imgName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)d;
		
		File scr = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(imgName + ".png");
		
		FileHandler.copy(scr, dest);
	}
	
	 public static String getCustomDate()
	 {
		String dateFormat = new SimpleDateFormat("ddMMyyyyhhMMss").format(new Date()); 
		return dateFormat;
	 }
	 
	  public static String captureScreenShot(WebDriver d, String screenShotName) throws IOException
	  {
		TakesScreenshot ts = (TakesScreenshot) d;

		File scr = ts.getScreenshotAs(OutputType.FILE);
		String screeShotPath = filePath + screenShotName + getCustomDate() + ".png";
		File dest = new File(screeShotPath);

		FileHandler.copy(scr, dest);

		return screeShotPath;
	  }
}
