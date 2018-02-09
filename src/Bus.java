
public class Bus extends Thread {
	private String name;
	private long start_time;
	Bus(String name, double start_time){
		this.name = name;
		this.start_time = (long)start_time;
		System.out.println("Bus thread is creating....");
	}
	public void run() {
		try {
			Thread.sleep(start_time);
			Main.mutex.acquire();
				if (Main.count > 0)
				{
					System.out.println("Notify Bus has arrived...");
					Main.bus.release();
					System.out.println("Bus is Wait for All aborad signle...");
					Main.all_abord.acquire();
					
				}
			
			Main.mutex.release();
			
			System.out.println("All aboard Bus is ready to depart...");
			
			depart();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void depart() 
	{
		System.out.println("Bus is departing....");
	}
}
