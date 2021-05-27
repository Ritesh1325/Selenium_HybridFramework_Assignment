package Selenium_Practice;

import java.io.IOException;

public class ReverseString 
{
	String str;
	public void byUsingLoop(String str)
	{
		this.str = str;
		String revString = "";
		
//		str = str.toLowerCase();
		for (int i = str.length()-1; i >= 0; i--) 
		{
			revString = revString + str.charAt(i);
		}
		
		System.out.println("Original String - " + str);
		System.out.println("Reverse String - " + revString);		
	}
	
	public void byUsingRevMeth(String string) throws IOException 
	{
		StringBuffer sb = new StringBuffer(string);
		System.out.println("Original String - " + sb);
		System.out.println("Reverse String - " + sb.reverse());
	}
	
	public static void main(String[] args) throws IOException 
	{
		ReverseString rs = new ReverseString();
		
		rs.byUsingLoop("Hey Im using loop");
		rs.byUsingRevMeth("hey Im using method");
	}
}
