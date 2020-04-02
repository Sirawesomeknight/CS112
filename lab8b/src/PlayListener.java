

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;


public class PlayListener implements ActionListener {

	public JTextField outField;
	public Game theGame;
	
	public PlayListener(JTextField outField, Game theG) {
		this.outField = outField;
		theGame = theG;
	}

	public void actionPerformed(ActionEvent e) {
		outField.setText("");
		ArrayList<String> s = theGame.playGame();
		FillProcess pt = new FillProcess(outField,s);
		pt.run();
	}

}
