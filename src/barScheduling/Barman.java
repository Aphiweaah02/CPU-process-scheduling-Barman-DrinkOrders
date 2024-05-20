package barScheduling;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/*
 Barman Thread class.
 */

public class Barman extends Thread {
	

	private CountDownLatch startSignal;
	private BlockingQueue<DrinkOrder> orderQueue;

	public int drinkSum;


	
	Barman(  CountDownLatch startSignal,int schedAlg) {
		if (schedAlg == 0) {
			this.orderQueue = new LinkedBlockingQueue<>();
			this.startSignal = startSignal;

		} else {
			this.orderQueue = new PriorityBlockingQueue<>(); //changed to priorityQueue
			//added priority this will ensure each element is compared before being added.
			this.startSignal = startSignal;
		}
	}

	public int countDrinks(){
		return drinkSum;  //returns drinks count in entire process.
	}
	
	public void drinkOrdering(DrinkOrder order) throws InterruptedException {
        orderQueue.put(order);
		drinkSum += 1;   //to keep track of how many drinks were ordered in the whole process.
    }
	
	
	public void run() {
		try {
			DrinkOrder nextOrder;
			
			startSignal.countDown(); //barman ready
			startSignal.await(); //check latch - don't start until told to do so

			while(true) {
				nextOrder=orderQueue.take();
				System.out.println("---Barman preparing order for patron "+ nextOrder.toString());
				sleep(nextOrder.getExecutionTime()); //processing order
				System.out.println("---Barman has made order for patron "+ nextOrder.toString());
				nextOrder.orderDone();
			}
		} catch (InterruptedException e1) {
			System.out.println("---Barman is packing up ");
		}
	}
}


