
public class Bus extends Thread {
	private String name;
	private long start_time;
	Bus(String name){
		this.name = name;
		System.out.println("Bus thread : "+name+" is creating....");
	}
	public void run() {
		try {
			Thread.sleep(start_time);
			Main.mutex.acquire();
				if (Main.count > 0)
				{
					Main.riders = Math.min(Main.count,50);
					System.out.println("Notify Bus has arrived...");
					System.out.println(Main.riders + " riders are wating to aboard the bus..");
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
