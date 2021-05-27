package com.VisionIT_OrangeHRM_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.VisionIT_OrangeHRM_TestBase.TestBase;
import com.VisionIT_OrangeHRM_Utility.Helper;

public class SignIn extends TestBase
{
	WebDriver d;
		
	@FindBy(id = "SubmitCreate")
	@CacheLookup
	WebElement createAcccount;
	
	@FindBy(id = "email_create")
	@CacheLookup
	WebElement emailID;
	
	@FindBy(id = "uniform-id_gender1")
	@CacheLookup
	WebElement Mr;
	
	@FindBy(id = "uniform-id_gender2")
	@CacheLookup
	WebElement Mrs;
	
	@FindBy(id = "customer_firstname")
	@CacheLookup
	WebElement fName;
	
	@FindBy(id = "customer_lastname")
	@CacheLookup
	WebElement lName;
	
	@FindBy(id = "email")
	@CacheLookup
	WebElement email;
	
	@FindBy(id = "passwd")
	@CacheLookup
	WebElement pass;
	
	@FindBy(id = "days")
	@CacheLookup
	WebElement day;
	
	@FindBy(id = "months")
	@CacheLookup
	WebElement month;
	
	@FindBy(id = "years")
	@CacheLookup
	WebElement year;
	
	@FindBy(id = "newsletter")
	@CacheLookup
	WebElement signUpNewsLetter;
	
	@FindBy(id = "uniform-optin")
	@CacheLookup
	WebElement recivePart;
	
	public SignIn(WebDriver d) 
	{
		this.d = d;
		PageFactory.initElements(d, this);
	}
	
	
	public void personalInfo()
	
	//	String email, String firstName, String lastName,
	//  String pas, String dayText, String monthText, String yearText
	{
		try 
		{
			d.findElement(By.className("login")).click();
			Thread.sleep(1000);
	
			emailID.sendKeys(userEmailAdd);	//	abc123@abc.com	
			
			createAcccount.click();
			Thread.sleep(2000);
			
			WebElement createPage = d.findElement(By.xpath("//h1[contains(text(),'Create an account')]"));

			if (createPage.isDisplayed()) 
			{
				Assert.assertTrue(true);
				test.pass("Create Login Page Hence Test Case Is Passed");			
				
				Mr.click();
				fName.sendKeys("Ashish");
				lName.sendKeys("Mahajan");
				
				firstName1 = fName.getAttribute("value");
				lastName1 = lName.getAttribute("value");
				
				String emilVerify = email.getAttribute("value");
				Assert.assertEquals(emilVerify, userEmailAdd,"Entered Email ID Is Matched");
				
				pass.sendKeys(userPassword);
				
//-----------------SetDateOfBirth--------------------------------------
				
				Helper.selectByDropDownValue(day, "20");
		
				Helper.selectByDropDownIndex(month, 3);
			
				Helper.selectByDropDownIndex(year, 4);
				
				signUpNewsLetter.click();
				recivePart.click();
				
				YourAddressData y = new YourAddressData(d);
				y.YourAddressDataMeth();
			}
			else 
			{
				Assert.assertFalse(false);
				test.fail("Create Login Page Hence Test Case Is Failed");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
	}



}
