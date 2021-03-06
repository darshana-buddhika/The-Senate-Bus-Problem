import java.util.Random;

public class Time_Generator {
	private int bus_mean_arrival_time = 60*20;  // mean time for a bus is 20 minutes
	private int child_mean_arrival_time = 30;  // mean time for a child is 30 seconds
	
	public double bus_next_time() {
		return next_time(bus_mean_arrival_time);
	}
	
	public double child_next_time() {
		return next_time(child_mean_arrival_time);
	}
	
	private double next_time(double lambda) 
	{
		Random rand = new Random();
		return Math.log(1-rand.nextDouble())*(-lambda);
	}

}
