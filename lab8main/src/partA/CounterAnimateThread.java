package partA;

public class CounterAnimateThread extends Thread {

	private CountPanel theCounter;
	private int pauseTime;

	public CounterAnimateThread(CountPanel cp, int pause) {
		pauseTime = pause;
		theCounter = cp;
	}

	public void run() {

		while (true) {
			try {
				Thread.sleep(pauseTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			theCounter.bumpCount();
		}

	}

}
