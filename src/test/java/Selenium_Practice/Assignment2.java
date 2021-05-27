package Selenium_Practice;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 
{
	static WebDriver d;
	final static String appPath = "https://www.google.co.in/maps?hl=en";
	final static String searchTxt = "wankhede stadium";
	final static String screenShotFilePath = "./Screenshots/Assignment2.html";
	public static String screenShotName = null;
	
	
	@FindBy(id = "searchboxinput")	@CacheLookup
	WebElement searchBox;
	
	
	
	public Assignment2(WebDriver d) 
	{
		this.d = d;
		PageFactory.initElements(d, this);
	}
	
	@Test(priority=1)
	public void launchApp() throws InterruptedException
	{
		new Assignment2(d);
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();
		
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		d.get(appPath);
		Thread.sleep(3000);	
	}
	
	@Test(priority=2)
	public void sendSearchTxt() throws InterruptedException, IOException
	{
		launchApp();
		searchBox.sendKeys(searchTxt);
		Thread.sleep(3000);
		Assignment2.takeScreenShot();
	}
	

	
	
	public static String getCustomeDate()
	{
		String date = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss").format(new Date());
		return date;
	}
	
	public static void takeScreenShot() throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)d;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		
		screenShotName = d.getTitle();
		String screenShotPath = screenShotName+getCustomeDate()+".png";
		File dest = new File(screenShotPath);
		
		FileUtils.copyDirectory(scr, dest);
	}
}
