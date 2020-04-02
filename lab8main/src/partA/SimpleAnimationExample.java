package partA;

import java.awt.*;
import javax.swing.*;

public class SimpleAnimationExample extends JFrame {

	java.util.Random r = new java.util.Random();
	
	public void init() {

		Container contentPane = this.getContentPane();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane.setLayout(new FlowLayout());

		contentPane.add(new JLabel("Count:"));

		JTextField countField = new JTextField(20);
		contentPane.add(countField);

		JButton jb = new JButton("update count");
		this.getContentPane().add(jb);

		CountPanel cp = new CountPanel(countField);
		contentPane.add(cp);
		jb.addActionListener(cp);

		int howManyThreads = 1;
		int timeToPause = 1;
		
		for (int i=0; i<howManyThreads; i++) {
			CounterAnimateThread cat = new CounterAnimateThread(cp,2000*random(timeToPause));
			cat.start();
		}
	}
	
	/* returns an int between 1 and top, inclusive */

	private int random(int top) {
		return 1+r.nextInt(top);
	}
	

}


