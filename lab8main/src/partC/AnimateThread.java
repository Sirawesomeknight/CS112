
public class AnimateThread extends Thread {

	private FunPanel thePanel;
	private int pauseTime;
	private boolean animating = true;

	public AnimateThread(FunPanel cp, int pause) {
		pauseTime = pause;
		thePanel = cp;
	}

	public void run() {

		while (true) {

			if (animating) thePanel.bump();

			try {
				Thread.sleep(pauseTime);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	public void faster() {
		pauseTime = pauseTime / 2;
	}

	public void setState(boolean b) {
		animating = b;
	}

	public void slower() {
		pauseTime = pauseTime * 2;
	}

}
