package Java_Practice;

import java.util.Scanner;

public class SwapTwoNumWithoutUseTempVar 
{
	public static void main(String[] args) 
	{
		System.out.println("Enter A & B Number - ");
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println("Before Swapping A's Value - " + a + " And " + "B's Value - " + b );
		
		a = a + b;		//	 a-25 +  b-40 = (a = 65)
		b = a - b;		//	40 = 65 - 40 = (b = 25)
		a = a - b;		//	65 = 65 - 25 = (a = 40)
		
		System.out.println("After Swapping A's Value - " + a + " And " + "B's Value - " + b );
		
		sc.close();
	}
}
