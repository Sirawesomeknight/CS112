import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class ControlAnimation implements ActionListener {

	private AnimateThread cat;
	private JButton starterButton;
	private boolean running = false;
	private boolean started = false;

	public ControlAnimation(JButton jb, AnimateThread a) {
		starterButton = jb;
		cat = a;
	}

	public void actionPerformed(ActionEvent e) {	
		if (!started) {
			cat.start();
			starterButton.setText("Stop Animation");
			started = true;
			running = true;
		}
		else if (running) {
			cat.setState(false);
			starterButton.setText("Restart Animation");
			running = false;
		}
		else {
			cat.setState(true);
			starterButton.setText("Stop Animation");
			running = true;
		}
	}

}
