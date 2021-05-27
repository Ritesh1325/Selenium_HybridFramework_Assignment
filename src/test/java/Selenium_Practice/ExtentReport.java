package Selenium_Practice;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport 
{
	static WebDriver d = null;
	private ExtentHtmlReporter exHTMLReporter= null;
	private ExtentReports exReports = null;
	private ExtentTest exTest;
	static String dateFormat;
	private static String filePath = "./Reports/Automationpractice.html";
	Throwable t = null;
	private static final Logger log = LogManager.getLogger(ExtentReport.class);
	
	  @BeforeTest
	  public void setUpExtent() throws Exception 
	  {
		 File f = new File(filePath);
		 
		 log.info("Extent Report Format Invocked...", t);
		 exHTMLReporter = new ExtentHtmlReporter(f);
		 exHTMLReporter.config().setDocumentTitle("Automation Testing Report");
		 exHTMLReporter.config().setReportName("Functional Test Report");
		 exHTMLReporter.config().setTheme(Theme.DARK);
		 exHTMLReporter.config().setAutoCreateRelativePathMedia(true);
		 
		 exReports = new ExtentReports();
		 exReports.attachReporter(exHTMLReporter);
		 
		 exReports.setSystemInfo("OS", "Windows");
		 exReports.setSystemInfo("Browser", "Chrome");
		 exReports.setSystemInfo("QA Name", "Ritesh Malge");
		 exReports.setSystemInfo("DateAndTime", dateFormat);
	  }
	  
	  @AfterTest
	  public void endReport()
	  {
		  exReports.flush();
		  log.info("Extent Report Generated", t);
	  }
	  
	  @BeforeMethod
	  public void setUpBrowser()
	  {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			d = new ChromeDriver();
			log.info("Browser Driver Invocked...", t);
			d.get("http://automationpractice.com");
			log.info("Application Launched...", t);
			d.manage().window().maximize();
			log.info("Application Window Has Maximized...", t);
			d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  }
	  
		@Test(priority=1)
		public void verifyURL_TC_001()
		{
			Reporter.log("URL Redirection Test", true);
			exTest = exReports.createTest("Verify URL of the page");
			log.info("Verify URL of the page TC_001 Test Case Started", t);
			String expUrl = "http://automationpra99ctice.com/index.php";
			String actUrl = d.getCurrentUrl();
	
			Assert.assertEquals(actUrl, expUrl);
/*			if (actUrl.equals(expUrl)) 
			{
				Assert.assertTrue(true);
				exTest.pass("Expected URL is matched Test Passed");
			}
			else 
			{
//				Assert.assertFalse(false);
				exTest.fail("Expected URL is not matched Test Failed");
			}
*/				log.info("Verify URL of the page TC_001 Test Case Ended", t);

		}
		
		@Test(priority=2)
		public void verifyTitle_TC_002()
		{
			Reporter.log("Landing Page Title Test", true);
			exTest = exReports.createTest("Verify Title Of The Page");
			log.info("Verify Title Of The Page TC_002 Test Case Started", t);

			String expTitle = "My Store123";
			String actTitle = d.getTitle();
			Assert.assertEquals(actTitle, expTitle);
/*			if (actTitle.equals(expTitle)) 
			{
				Assert.assertTrue(true);
				exTest.pass("Expected Title is matched Test Passed");
			}
			else 
			{
//				Assert.assertFalse(false);
				exTest.fail("Expected Title is not matched Test Failed");
			}
			
*/		log.info("Verify Title Of The Page TC_002 Test Case Ended", t);
		}
	  @AfterMethod
	  public void tearDown(ITestResult result)
	  {
		try 
		{
			  if (result.getStatus() == ITestResult.FAILURE) 
			  {

				  exTest.log(Status.FAIL, "Test Case Failed" + result.getName());
				  log.info("Test Case Failed" + result.getName());
				  exTest.log(Status.FAIL, "Test Case Failed" + result.getThrowable());
				  log.info("Test Case Failed" + result.getThrowable());
				  String screenShotPath = captureScreenShot(d, result.getName());
				  log.info("Capturing Screen Shot for Test Case Failed" + result.getName());
//				  exTest.log(Status.FAIL, "Snapshot Is Below: " + exTest.addScreenCaptureFromPath(screenShotPath));
				  exTest.addScreencastFromPath(screenShotPath);
				  log.info("Attaching Screen Shot for Test Case Failed" + result.getName());
//				  exTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath));
			  }
			  else if (result.getStatus() == ITestResult.SUCCESS)
			  {
				  exTest.log(Status.PASS, "Test Case Passed" + result.getName());
				  log.info("Test Case Passed" + result.getName());
			  }
			  else if (result.getStatus() == ITestResult.SKIP) 
			  {
				  exTest.log(Status.SKIP, "Test Case Skipped" + result.getName());
				  log.info("Test Case Skipped" + result.getName());
			  }
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			  d.quit();			
		}
	  }
	  
	  public static String captureScreenShot(WebDriver d, String screenShotName) throws Exception
	  {
			dateFormat = new SimpleDateFormat("_dd_MM_yyyy_hh_mm_ss").format(new Date());
	
			TakesScreenshot ts = (TakesScreenshot)d;
	
			File scr = ts.getScreenshotAs(OutputType.FILE);
			String screeShotPath = "./Screenshots/" + screenShotName + dateFormat + ".png";
			File dest = new File(screeShotPath);
	
			FileHandler.copy(scr, dest);
	
			return screeShotPath;
	  }
}
