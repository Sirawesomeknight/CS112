

//In order to win this game, the player must get 3 squares in a row or in a column without losing.
//There are reduced buttons, but there is also only one random deadly square

public class TheGame {

	// Notice that the Game does not know about the GUI interface to the game

	private int howManyPushed = 0;
	private int limit;
	private String doneMessage = null;
	private int howMany = 9;
	private int[] badButtons = {(int) (Math.random() * (howMany - 1))};
	private boolean[] buttonsPressed = new boolean[howMany];
	public TheGame(int i) {
		limit = i;
		for(byte p = 0; p < buttonsPressed.length; p++){
			buttonsPressed[p] = false;
		}
	}

	public void badSpot() {
		doneMessage = "You Lose - Good!";
	}

	public void spot(int buttonPressed) {

			addPressedButton(buttonPressed);

			int row = getRow(buttonPressed);
			int column = getColumn(buttonPressed);

			for(int j = row; j < (row + 3); j++){
				if(buttonsPressed[j] == false){
					break;
				}else if(j == (row + 2)){
					doneMessage = "Curses, you win";
				}
			}

			for(int j = column; j < (column + 7); j += 3){
				if(buttonsPressed[j] == false){
					break;
				}else if(j == (column + 6)){
					doneMessage = "Curses, you win";
				}
			}

	}

	private int getRow(int buttonPressed){
		if(buttonPressed <= 2){
			return 0;
		}else if(buttonPressed <= 5){
			return 3;
		}else{
			return 6;
		}
	}

	private int getColumn(int buttonPressed){
		return (buttonPressed % 3);
	}

	private void addPressedButton(int buttonPressed){
		buttonsPressed[buttonPressed] = true;
		System.out.println(buttonPressed);
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
