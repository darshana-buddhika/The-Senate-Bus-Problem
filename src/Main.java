import java.util.concurrent.Semaphore;

public class Main 
{
	public static int count = 0;
	public static int riders = 0;
	public static int bus_count = 0;
	public static Semaphore mutex = new Semaphore(1);
	public static Semaphore multiplex = new Semaphore(50);
	public static Semaphore bus = new Semaphore(0);
	public static Semaphore all_abord = new Semaphore(0);
	
	public static void main(String[] args)
	{
		System.out.println("####################################################");
		System.out.println("############# The Senate Bus Problem ###############");
		System.out.println("####################################################");
		
		new Bus_Generator().start();
		new Child_Generator().start();
		
		
	
	}
}
