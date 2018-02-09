
public class Bus_Generator extends Thread
{	
	Time_Generator next_time = new Time_Generator();
	private int bus_counter = 0;
	
	public void run() {
		while(true) 
		{
			Bus bus = new Bus(bus_counter+"");
			double bus_starts = next_time.bus_next_time();
			System.out.println("Bus thead is starts in : "+(int)bus_starts+" seconds");
			try {
				Thread.sleep((long)bus_starts*1000);
				bus.start();
				bus_counter++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
