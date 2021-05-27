package Java_Practice;

class ThreadTable
{
	synchronized void printTable(int n)
	{
		for (int i = 1; i <= 5; i++) 
		{
			System.out.println(n * i);
			try 
			{
				Thread.sleep(500);	
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
}

class MyThread1 extends Thread
{
	ThreadTable t;
	public MyThread1(ThreadTable t) 
	{
		this.t = t;
	}
	
	public void run()
	{
		t.printTable(5);
	}
}

class MyThread2 extends Thread
{
	ThreadTable t;
	public MyThread2(ThreadTable t) 
	{
		this.t = t;
	}
	
	public void run()
	{
		t.printTable(500);
	}
}

public class ThreadProgram 
{
	public static void main(String[] args) 
	{
		ThreadTable obj = new ThreadTable();
		MyThread1 m1 = new MyThread1(obj);
		MyThread2 m2 = new MyThread2(obj);
		
		m1.start();
		m2.start();
	}
}
