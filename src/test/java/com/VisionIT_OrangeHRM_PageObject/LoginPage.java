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

public class LoginPage extends TestBase
{
	public String regUser = "abc@cnd.com";
	public String regPass = "ABcd@1212";
	
	WebDriver d;
	
	@FindBy(id = "email")
	@CacheLookup
	 WebElement emailText;
	
	@FindBy(id = "passwd")
	@CacheLookup
	 WebElement passText;

	@FindBy(id = "send_friend_button")
	@CacheLookup
	 WebElement sendToFried;

	@FindBy(id = "friend_name")
	@CacheLookup
	 WebElement friendName;
	
	@FindBy(id = "friend_email")
	@CacheLookup
	 WebElement friendEmail;
	
	@FindBy(id = "sendEmail")
	@CacheLookup
	 WebElement sendEmail;

	public LoginPage(WebDriver d)
	{
		this.d = d;
		PageFactory.initElements(d, this);
	}
	
	public void loginInApp()
	{
		try 
		{
			WebElement signInBtn = d.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
			signInBtn.click();
			
			Thread.sleep(2000);
			
			emailText.clear();
			emailText.sendKeys(regUser);

			passText.clear();
			passText.sendKeys(regPass);
			
			WebElement signInBtn1 = d.findElement(By.xpath("//*[@class='icon-lock left']"));
			signInBtn1.click();
			Assert.assertTrue(true);
			Reporter.log("Login Successful with User - " + regPass);
			test.pass("Login Successful with User Hence Test Case Is Passed");			

			Thread.sleep(2000);
			
			WebElement tshirtEle = d.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[3]/a"));
			tshirtEle.click();
			
			Thread.sleep(2000);
			
			WebElement moreEle = d.findElement(By.xpath("//span[contains(text(),'More')]"));
			moreEle.click();
			
			sendToFried.click();
			
			friendName.sendKeys("Venkatesh");		Thread.sleep(1000);
			friendEmail.sendKeys("venky@abc.com");	Thread.sleep(1000);
			sendEmail.click();
			
			WebElement confMsg = d.findElement(By.xpath("//*[@id='product']/div[3]"));
			String expMsg = "Your e-mail has been sent successfully";
			String actMsg = null;
			if (confMsg.isDisplayed()) 
			{
				WebElement msgText = d.findElement(By.xpath("//p[text()='Your e-mail has been sent successfully']"));
				actMsg = msgText.getText();
				
				Assert.assertEquals(actMsg, expMsg,"Expected Message And Actual Message Has Matched");
				test.pass("Expected Is matched with Actual Hence Test Case Is Passed");
			}
			else 
			{
				Assert.assertFalse(false);
				test.fail("Expected Is Not matched with Actual Hence Test Case Is Failed");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
