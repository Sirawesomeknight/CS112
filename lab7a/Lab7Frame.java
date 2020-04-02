import java.awt.*;
import javax.swing.*;


public class Lab7Frame extends JFrame {

	private JLabel message;
	private int buttonCount;
	private JButton[] buttons;

	public void setUpFrame() {

		// Exit when window is closed
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container ct = getContentPane();

		// set the layout manager to a grid 0 rows by 3 columns 
		// (0 means however many you need)
		ct.setLayout(new GridLayout(4,0));

		TheGame game1 = new TheGame(7);

		buttonCount = game1.howManyButtons();

		GoodSpotHandler goodHand = new GoodSpotHandler(game1,this);
		BadSpotHandler badHand = new BadSpotHandler(game1, this);

		Lab7DisplayPanel panel = new Lab7DisplayPanel();

		buttons = new JButton[buttonCount];

		for (int i=0; i< buttonCount; i++) {

			// create a button  (DiamondButton is part of Lab 7)
			//
			Color c = new Color(randomColorCoord(),randomColorCoord(),randomColorCoord());
			JButton jb = new DiamondButton(c);

			ct.add(jb);

			// Adding an action listener -
			// when the button is pushed, the actionPerformed method of the
			// Listener is called
			//

			if (game1.isButtonBad(i)) {
				jb.addActionListener(badHand);
			}
			else
				jb.addActionListener(goodHand);

			if (i==2) {
				panel.randomSet();
				ct.add(panel);
			}

			buttons[i] = jb;
		}
		message = new JLabel("Keep pressing buttons");
		ct.add(message);

		Lab7DisplayPanel two = new Lab7DisplayPanel();
		ct.add(two);
	}

	private int randomColorCoord() {
		return (int) (Math.random()*256);
	}

	public void setDoneMessage(String message1) {
		message.setText(message1);

		for (JButton b : buttons) {
			b.setEnabled(false);
		}


	}
}
