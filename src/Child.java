import java.util.concurrent.Semaphore;

public class Child extends Thread {
		
	
	private String name;
	
	Child(String name){
		this.name = name;
		System.out.println("Creating Child thread : "+name);
	}
	
	public void run() {
		try {
			Main.mutex.acquire();
			System.out.println("Child : "+ name + " Entering to the station..");
				Main.count ++;
			Main.mutex.release();
			
			Main.bus.acquire();
			
			Main.multiplex.acquire();
			
			aboard();
			
			Main.count -- ;
			Main .riders -- ;
			System.out.println("  ");
			
			if (Main.riders  == 0)
			{
				System.out.println("Notify bus to depart...");
				Main.multiplex.release(50);
				Main.all_abord.release();
				
			}
			else
			{
				Main.bus.release();
			}
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	private void aboard() 
	{
		System.out.println("Child aboard to the bus : "+name);
	}
}
