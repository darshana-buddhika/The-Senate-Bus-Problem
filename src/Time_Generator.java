import java.util.Random;

public class Time_Generator {
	private int bus_mean_arrival_time = 120;
	private int child_mean_arrival_time = 2;
	
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
