package carFactory;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*Your job is to implement the simulation of an assembly line that will build Cars. Each Car is made up of several components: tires, seats, engine and frame. Each of these 
components takes a different amount of time to build on their own. Here’s the breakdown on the simulated time each component takes to construct:
•Tire – 2 seconds
•Seats – 3 seconds
•Engine – 7 seconds
•Frame – 5 seconds
With these times, you must implement the code that will simulate the construction of each of these components individually, then once all the necessary components are built you 
must put them together to make a car. To build a car, you’ll need 4 tires, 5 seats, 1 engine and 1 frame. Here’s the catch, the assembly line can only and should only be capable of 
building 3 Components at any given time. You’ll need to implement this in your code.Once you’ve completed the assignment, try and fiddle with the order of which the 
Components are assembled on the line. Is there a particular order that provides the fastest building time for a Car?*/

public class Car {
	
	 public Car() {
		ExecutorService executor = Executors.newFixedThreadPool(3); 
		ArrayList<Runnable> tasks = new ArrayList<>();
		
		tasks.add(new Engine());
		tasks.add(new Frame());
		for (int i = 0; i < 5; i++) {
			tasks.add(new Seat());
		}
		for (int i = 0; i < 4; i++) {
			tasks.add(new Tire());
		}
		
		Long start = System.currentTimeMillis();
		for (Runnable task : tasks) {
			executor.execute(task);
		}
		executor.shutdown();
		while (true) {
			if(executor.isTerminated()) {
				break;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("A car is assembled in " + (end-start)/1000.0 + " seconds.");
		
	}
	
	private class Tire implements Runnable  {

		@Override
		public void run() {
			try {
				Thread.sleep(2000);
				System.out.println("A new tire has been created!");
			} catch (InterruptedException e) {
				System.out.println("Creating a tire failed!");
			}
			
		}
		
	}
	private class Engine implements Runnable  {

		@Override
		public void run() {
			try {
				Thread.sleep(7000);
				System.out.println("A new engine has been created!");
			} catch (InterruptedException e) {
				System.out.println("Creating an engine failed!");
			}
			
		}
		
	}
	private class Frame implements Runnable  {

		@Override
		public void run() {
			try {
				Thread.sleep(5000);
				System.out.println("A new frame has been created!");
			} catch (InterruptedException e) {
				System.out.println("Creating a frame failed!");
			}
			
		}
		
	}
	private class Seat implements Runnable  {

		@Override
		public void run() {
			try {
				Thread.sleep(3000);
				System.out.println("A new seat has been created!");
			} catch (InterruptedException e) {
				System.out.println("Creating a seat failed!");
			}
			
		}
		
	}

}
