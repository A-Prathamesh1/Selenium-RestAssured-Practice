package multithreading;

public class MultiThreadingDemo {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * MultithreadingThing thing = new MultithreadingThing();
		 * 
		 * // to run threads concurrently use thing.start() // to make threads run one
		 * after other thing.run(); thing.run(); MultithreadingThing thing2 = new
		 * MultithreadingThing(); thing2.run();
		 */

		for (int i = 0; i < 5; i++) {
			MultithreadingThing thing = new MultithreadingThing(i);
			Thread thread = new Thread(thing);
//			thread.start();
			thread.run();
//			thread.join();
//			thread.run();
//			thing.start(); // start the magic! 5 threads concurrently
//			thing.run(); // 5 threads runs one after other
		}

//		throw new RuntimeException();
	}
}
