//M. M. Kuttel 2024 mkuttel@gmail.com
package barScheduling;

import java.io.*;
import java.util.*;
import java.util.concurrent.CountDownLatch;

/*
 This is the basicclass, representing the patrons at the bar
 */

public class Patron extends Thread {
	
	private Random random = new Random();// for variation in Patron behaviour

	private CountDownLatch startSignal; //all start at once, actually shared
	private Barman theBarman; //the Barman is actually shared though

	private int ID; //thread ID 
	private int lengthOfOrder;
	private long startTime, endTime; //for all the metrics
	
	public static FileWriter fileW;

	private DrinkOrder [] drinksOrder;
	
	Patron( int ID,  CountDownLatch startSignal, Barman aBarman) {
		this.ID=ID;
		this.startSignal=startSignal;
		this.theBarman=aBarman;
		this.lengthOfOrder=random.nextInt(5)+1;//between 1 and 5 drinks
		drinksOrder=new DrinkOrder[lengthOfOrder];
	}

	public void run() {
		try {
			//Do NOT change the block of code below - this is the arrival times
			startSignal.countDown(); //this patron is ready
			startSignal.await(); //wait till everyone is ready
	        int arrivalTime = random.nextInt(300)+ID*100;  // patrons arrive gradually later
	        sleep(arrivalTime);// Patrons arrive at staggered  times depending on ID 
			System.out.println("thirsty Patron "+ this.ID +" arrived");
			//END do not change

			int prepTimeMinimum = Integer.MAX_VALUE; // Initialize with maximum value
			long firstDrinkTime = -1; // used to keep track of first drink


			int totalDrinksTime = 0;
	        //create drinks order
	        for(int i=0;i<lengthOfOrder;i++) {
	        	drinksOrder[i]=new DrinkOrder(this.ID);
				prepTimeMinimum = Math.min(prepTimeMinimum, drinksOrder[i].getExecutionTime());
			}

			System.out.println("Patron "+ this.ID + " submitting order of " + lengthOfOrder +" drinks"); //output in standard format  - do not change this
	        startTime = System.currentTimeMillis();//started placing orders

			for(int i=0;i<lengthOfOrder;i++) {
				System.out.println("Order placed by " + drinksOrder[i].toString());
				// Calculate preparation time for the current drink order
				String[] parts = drinksOrder[i].toString().split(":");
				int preparationTime = DrinkOrder.getDrinkExecutionTime(parts[1].trim());

				// Update total drinks time
				totalDrinksTime += preparationTime;

				theBarman.drinkOrdering(drinksOrder[i]);

			}

			for(int i=0;i<lengthOfOrder;i++) {
				drinksOrder[i].waitForOrder();
				if(firstDrinkTime == -1) { //check if the first still has not yet arrived.
					if (drinksOrder[i].getExecutionTime() == prepTimeMinimum) {
						firstDrinkTime = System.currentTimeMillis();
					}
				}
			}
			endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;

			System.out.println("Patron "+ this.ID + " got order in " + totalTime);
			SchedulingSimulation schedulingSimulation = new SchedulingSimulation();
			schedulingSimulation.metricsRecord(this.ID, arrivalTime, totalDrinksTime, totalTime, (firstDrinkTime-startTime));

		} catch (InterruptedException e1) {  //do nothing
		} catch (IOException e) {
			//  Auto-generated catch block
			e.printStackTrace();

		}
}

}

	

