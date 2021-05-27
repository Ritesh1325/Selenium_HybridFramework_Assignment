package com.VisionIT_OrangeHRM_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider 
{
	private String filePath = "./Configure/config.properties";
	public Properties prop;
	
	public ConfigDataProvider() 
	{
		try 
		{
			File f = new File(filePath);
			FileInputStream fis = new FileInputStream(f);
			
			prop = new Properties();		
			prop.load(fis);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public String getKeyValue(String searchKey)
	{
		return prop.getProperty(searchKey);
	}
	
	public String getAppUrl()
	{
		return prop.getProperty("appUrl");
	}
	
	public String getSheet()
	{
		return prop.getProperty("sheetName1");
	}
	
	public String getEmail()
	{
		return prop.getProperty("email");
	}
	
	public String getFirstName()
	{
		return prop.getProperty("first_name");
	}

	public String getLastName()
	{
		return prop.getProperty("last_name");
	}
	
	public String getPassword()
	{
		return prop.getProperty("password");
	}

	public String getDay()
	{
		return prop.getProperty("day");
	}
	
	public String getMonth()
	{
		return prop.getProperty("month");
	}

	public String getYear()
	{
		return prop.getProperty("year");
	}

	public String getAdditionalInfo()
	{
		return prop.getProperty("additionalInfo");
	}

	public String getMobilePhone()
	{
		return prop.getProperty("mobile");
	}
	
	public String getAlias()
	{
		return prop.getProperty("alias");
	}
}
