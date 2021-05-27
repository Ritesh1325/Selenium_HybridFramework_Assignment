package com.VisionIT_OrangeHRM_PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.VisionIT_OrangeHRM_TestBase.TestBase;

public class ProductPage extends TestBase
{
	WebDriver d;
	
	@FindBy(xpath="//*[@id='center_column']/ul/li[1]/div/div[2]/div[1]/span[1]")@CacheLookup
	public static WebElement PrintedDressPrice1;

	@FindBy(xpath="//*[@id='center_column']/ul/li[2]/div/div[2]/div[1]/span[1]")@CacheLookup
	public static WebElement PrintedDressPrice2;

	@FindBy(xpath="//*[@id='center_column']/ul/li[3]/div/div[2]/div[1]/span[1]")@CacheLookup
	public static WebElement PrintedSummerDressPrice1;

	@FindBy(xpath="//*[@id='center_column']/ul/li[4]/div/div[2]/div[1]/span[1]")@CacheLookup
	public static WebElement PrintedSummerDressPrice2;

	@FindBy(xpath="//*[@id='center_column']/ul/li[5]/div/div[2]/div[1]/span[1]")@CacheLookup
	public static WebElement PrintedChiffonDressPrice;

	public ProductPage(WebDriver d) 
	{
		this.d = d;
		PageFactory.initElements(d, this);
	}
	
	public static String subStringTypeCastInDouble(String str)
	{
		String s =	str.substring(1);
//		double d = Double.valueOf(s);
		return s;
	}
	
	public static String PrintedDressPrice1()
	{
		String p1 = PrintedDressPrice1.getText();
		return p1;
	}
	
	public static String PrintedDressPrice2()
	{
		String printedDressPrice2 = PrintedDressPrice2.getText();
		return printedDressPrice2;
	}
	public static String PrintedSummerDressPrice1()
	{
		String printedSummerDressPrice1 = subStringTypeCastInDouble(PrintedSummerDressPrice1.getText());
		return printedSummerDressPrice1;
	}
	public static String PrintedSummerDressPrice2()
	{
		String printedSummerDressPrice2 = subStringTypeCastInDouble(PrintedSummerDressPrice2.getText());
		return printedSummerDressPrice2;
	}
	public static String PrintedChiffonDressPrice()
	{
		String printedChiffonDressPrice = subStringTypeCastInDouble(PrintedChiffonDressPrice.getText());
		return printedChiffonDressPrice;
	}
}

