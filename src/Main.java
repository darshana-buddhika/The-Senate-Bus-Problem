import java.util.concurrent.Semaphore;

public class Main 
{
	public static int count = 0;
	public static int riders = 50;
	public static Semaphore mutex = new Semaphore(1);
	public static Semaphore multiplex = new Semaphore(50);
	public static Semaphore bus = new Semaphore(0);
	public static Semaphore all_abord = new Semaphore(0);
	
	public static void main(String[] args)
	{
		System.out.println("##########################################");
		System.out.println("######## The Senate Bus Problem ##########");
		System.out.println("##########################################");
		Thread bus = new Bus("School Bus");
		
		
		for (int i = 0; i < 60; i++) {
			Thread child_obj = new Child(i+"");
			child_obj.start();
		}
		bus.start();
		try {
			bus.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
