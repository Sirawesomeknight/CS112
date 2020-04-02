

public class TheGame {

	// Notice that the Game does not know about the GUI interface to the game

	private int howManyPushed = 0;
	private int limit;
	private String doneMessage = null;
	private int howMany = 11;
	private int[] badButtons = {1,3};
	public TheGame(int i) {
		limit = i;
	}

	public void badSpot() {
		doneMessage = "You Lose - Good!";
	}

	public void spot() {
		howManyPushed++;
		if (howManyPushed == limit)
			doneMessage = "Curses, you win";
	}

	public boolean isButtonBad(int c) {
		for (int a : badButtons)
			if (c==a) return true;
		return false;
	}

	public String getDoneMessage() {
		return doneMessage;
	}

	public int howManyButtons() {
		return howMany;
	}
}
