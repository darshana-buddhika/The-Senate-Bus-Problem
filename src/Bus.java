
public class Bus extends Thread {
	private String name;
	
	Bus(String name){
		this.name = name;
		System.out.println("Bus thread is creating....");
	}
	public void run() {
		
		try {
			Main.mutex.acquire();
				if (Main.count > 0)
				{
					System.out.println("Notify Bus has arrived...");
					Main.bus.release();
					System.out.println("Wait for All aborad signle...");
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
//		Bus depature code ...
	}
}
