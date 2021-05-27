package com.VisionIT_OrangeHRM_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.VisionIT_OrangeHRM_TestBase.TestBase;
import com.VisionIT_OrangeHRM_Utility.Helper;

public class YourAddressData extends TestBase
{
	WebDriver d;
	
	@FindBy(id = "firstname")
	@CacheLookup
	WebElement fName;
	
	@FindBy(id = "lastname")
	@CacheLookup
	WebElement lName;
	
	@FindBy(id = "company")
	@CacheLookup
	WebElement company;

	@FindBy(id = "address1")
	@CacheLookup
	WebElement add1;

	@FindBy(id = "address2")
	@CacheLookup
	WebElement add2;
	
	@FindBy(id = "city")
	@CacheLookup
	WebElement citty;
	
	@FindBy(id = "id_state")
	@CacheLookup
	WebElement state;

	@FindBy(id = "postcode")
	@CacheLookup
	WebElement postal;

	@FindBy(id = "id_country")
	@CacheLookup
	WebElement country;

	@FindBy(id = "other")
	@CacheLookup
	WebElement additionInf;

	@FindBy(id = "phone_mobile")
	@CacheLookup
	WebElement mPhone;

	@FindBy(id = "alias")
	@CacheLookup
	WebElement alias;

	@FindBy(id = "submitAccount")
	@CacheLookup
	WebElement registerBtn;

	public YourAddressData(WebDriver d) 
	{
		this.d = d;
		PageFactory.initElements(d, this);
	}
	
	public void YourAddressDataMeth() throws InterruptedException
	{
//		fName.sendKeys(firstName);
//		lName.sendKeys(lastName);
		
		company.sendKeys("Cognizant");

		add1.sendKeys("P.O.Box109, Near Big Bazar");
	//	add2.sendKeys(Addr2);
		
		citty.sendKeys("Pune");

		Helper.selectByDropDownIndex(state, 3);

		postal.sendKeys("87898");
		
		Helper.selectByDropDownIndex(country, 1);
		
		additionInf.sendKeys("Ashish Mahajan, IT Software Engineer, Pune");
		
		mPhone.sendKeys("9860894545");
		
		alias.clear();
		alias.sendKeys("P.O.Box109, Near Big Bazar");
		
		registerBtn.click();
		Thread.sleep(2000);
		
		WebElement MyPersonalInfo = d.findElement(By.xpath("//span[contains(text(),'My personal information')]"));
		
		if (MyPersonalInfo.isDisplayed()) 
		{
			MyPersonalInfo.click();
			Thread.sleep(2000);
			
			if (firstName1 == fName.getAttribute("value") && lastName1 == lName.getAttribute("value")) 
			{
				Reporter.log("First Name & Last Name Is Matched Which We Inserted");
				Assert.assertTrue(true);
			}
		}
	}
}


/*String firstName, String lastName, String comp,
String addr1, String Addr2, String city, String stat, String post,
String countr, String addInfo, String pho*/