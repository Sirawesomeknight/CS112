package partB;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;


public class SetUpListener implements ActionListener {

	private JTextField guestField;
	private JTextField skipField;

	private Game theGame;
	private AugstineSwing theFrame;

	public SetUpListener(AugustineSwing s,JTextField gField, JTextField sField, Game theG) {
		guestField = gField;
		skipField = sField;
		theGame = theG;
		theFrame = s;
	}


	public void actionPerformed(ActionEvent arg0) {

		int number = Integer.parseInt(guestField.getText());	
		theGame.setGuests(number);		
		number = Integer.parseInt(skipField.getText());	
		theGame.setStride(number);
		theFrame.repaint();
	}

}
