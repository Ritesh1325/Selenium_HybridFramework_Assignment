package com.VisionIT_OrangeHRM_TestBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.VisionIT_OrangeHRM_Utility.ConfigDataProvider;
import com.VisionIT_OrangeHRM_Utility.ExcelDataProvider;
import com.VisionIT_OrangeHRM_Utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase 
{
	private static final Logger logger = LogManager.getLogger(TestBase.class);
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public static WebDriver d = null;
	public ConfigDataProvider configData;
	public ExcelDataProvider excelData;
	public static String firstName1;
	public static String lastName1;

	public static String userEmailAdd = "abc"+ Helper.getRandomNo_000() +"@abc.com";
	public static String userPassword = "ABcd&1212";;

	public static ExtentHtmlReporter htmlReport = null;
	public static ExtentReports reports = null;
	public static ExtentTest test = null;
	public String date;
	
	private String reportFilePath = "./Reports/automation.html";
	
	@BeforeSuite
	public void setUpSuite()
	{
		configData = new ConfigDataProvider();
		excelData = new ExcelDataProvider();
	}
	
	@BeforeTest
	public void setUpExtent()
	{
		htmlReport = new ExtentHtmlReporter(reportFilePath);
		htmlReport.config().setDocumentTitle("Automation Test Report");
		htmlReport.config().setReportName("Functional Test");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setAutoCreateRelativePathMedia(true);
		
		reports = new ExtentReports();
		reports.attachReporter(htmlReport);
		
		reports.setSystemInfo("OS", "Windows");
		logger.info("");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("QA", "Ritesh Malge");
		reports.setSystemInfo("Date & Time", date);
	}
	
	@BeforeMethod
	@Parameters("Browser")
	public void setUp(@Optional("chrome")String browserName)
	{
		try
		{
			if (browserName.equalsIgnoreCase("chrome")) 
			{
//				System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
				WebDriverManager.chromedriver().setup();
				d = new ChromeDriver();			
			}
			else if (browserName.equalsIgnoreCase("firefox")) 
			{
//				System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
				WebDriverManager.firefoxdriver().setup();
				d = new FirefoxDriver();
			}
			else if (browserName.equalsIgnoreCase("opera")) 
			{
//				System.setProperty("webdriver.opera.driver", "./Driver/operadriver.exe");
				WebDriverManager.operadriver().setup();
				d = new OperaDriver();
			}

			Reporter.log("Launching Application", true);
			d.get(configData.getAppUrl());
			
			d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			d.manage().window().maximize();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * @return 
	 * 
	 */
	public static synchronized WebDriver getDriver()
	{
		return tlDriver.get();
	}
	
	@AfterTest
	public void endReport()
	{
		reports.flush();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		try 
		{
			if (result.getStatus() == ITestResult.FAILURE) 
			{
				test.log(Status.FAIL, "Test Case Failed" + result.getName());
				test.log(Status.FAIL, "Test Case Failed" + result.getThrowable());
				
				String screenShotPath = Helper.captureScreenShot(d, result.getName());
				test.addScreencastFromPath(screenShotPath);
				
			}
			else if (result.getStatus() == ITestResult.SUCCESS) 
			{
				test.log(Status.PASS, "Test Case Passed" + result.getName());
			}
			else if (result.getStatus() == ITestResult.SKIP) 
			{
				test.log(Status.SKIP, "Test Case Skipped" + result.getName());
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		d.quit();
	}
}
