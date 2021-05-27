package Java_Practice;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class getCurrentDateTime 
{
	@Test
	public void getCustomeDate()
	{
		String date = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss").format(new Date());
		System.out.println("Current Date and Time - " + date);
	}
}
