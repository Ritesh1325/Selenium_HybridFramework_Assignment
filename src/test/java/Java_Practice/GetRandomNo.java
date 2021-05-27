package Java_Practice;

import com.VisionIT_OrangeHRM_Utility.Helper;

public class GetRandomNo 
{
	/**
	 * 	Getting Random Number from Helper.getRandomNo()		
	 */
	public static void main(String[] args) 
	{
		for (int i = 1; i <= 10; i++) 
		{
			int r = Helper.getRandomNo_000();
			System.out.println("riteshvm" + r + ".com");
		}
		
/**
 * 	Factorial of 1 to 10 numbers		
 */
		int num = 10;
		long factorial = 1;
		for (int i = 1; i <= num; ++i) 
		{
			long fact = factorial *= i;
			System.out.println(i + " ---- " + fact);
		}
	}
}
