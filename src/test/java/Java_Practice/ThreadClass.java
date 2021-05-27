package Java_Practice;

public class ThreadClass 
{
	public static void main(String[] args) 
	{
		System.out.println("Thread is started");
		
		System.out.println("Thread Class Declared");
			Thread t = new Thread();
			t.start();
			String threadName = t.getName();
			System.out.println("Thread Name - " + threadName);
			
			System.out.println("Current Thread - " + Thread.currentThread());
			
			t.setName("My Thread");
			System.out.println("Giving Thread Name - " + t.getName());

			t.suspend();
			System.out.println("Thread Suspended");
			
			t.resume();
			System.out.println("Thread Is Resumed");

			boolean status = t.isInterrupted();
			System.out.println("Thread is Inturrepted or not - " + status);
			
			int activeThreads = t.activeCount();
			System.out.println("Total Thread are in Current Thread Group - " + activeThreads);
			
			System.out.println("Thread is stopped");
			t.stop();
		System.out.println("Thread is Finished");
	}
}
