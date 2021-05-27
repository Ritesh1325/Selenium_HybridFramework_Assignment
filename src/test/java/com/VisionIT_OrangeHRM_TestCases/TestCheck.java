package com.VisionIT_OrangeHRM_TestCases;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCheck 
{
  @BeforeMethod
  public void launchApp() 
  {
	  Reporter.log("Launch App", true);
  }
  
  @Test
  public void login() 
  {
	  Reporter.log("login", true);
  }
  
  @AfterMethod
  public void logout() 
  {
	  Reporter.log("logout", true);
  }
  
  @BeforeTest
  public void setUpDriver() 
  {
	  Reporter.log("setUpDriver", true);
  }
  
  @AfterTest
  public void tearDownDriver() 
  {
	  Reporter.log("tearDownDriver", true);
  }
}
