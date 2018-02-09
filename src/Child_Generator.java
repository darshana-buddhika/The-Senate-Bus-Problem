
public class Child_Generator extends Thread
{
	Time_Generator next_time = new Time_Generator();
	private int child_counter  = 0;
	
	public void run() {
		while(true) 
		{
			Child bus = new Child(child_counter+"");
			double child_create = next_time.child_next_time();
			System.out.println("Child thead is starts in : "+(int)child_create+" seconds");
			try {
				Thread.sleep((long)child_create*1000);
				bus.start();
				child_counter++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
