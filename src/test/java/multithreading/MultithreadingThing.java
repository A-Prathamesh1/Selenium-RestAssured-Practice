package multithreading;

public class MultithreadingThing implements Runnable {

	int threadNumber;

	public MultithreadingThing(int threadNum) {
		this.threadNumber = threadNum;
	}

	@Override
	public void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.println(i + " from thread: " + threadNumber);
//			if (threadNumber == 3) {
//				// thread 3 will print only 1 first time and will die
//				throw new RuntimeException();
//			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
