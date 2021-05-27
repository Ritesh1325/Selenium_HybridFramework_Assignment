package Selenium_Practice;

import org.testng.annotations.Test;

public class StringPrograms 
{

	@Test
	public void subStringMeth() 
	{
		String str = new String("$152.87");
		System.out.println(str.substring(1));
	}
}
