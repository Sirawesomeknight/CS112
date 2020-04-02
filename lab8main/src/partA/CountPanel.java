package partA;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class CountPanel extends JPanel implements ActionListener {

	int counter;

	JTextField countIsHere;

	public CountPanel(JTextField countField) {
		countIsHere = countField;
		this.setPreferredSize(new Dimension(300,300));
	}

	public void bumpCount() {
		counter++;
		repaint();
	}

	public void actionPerformed(ActionEvent e) {

		String count = countIsHere.getText();
		
		counter = Integer.parseInt(count);

		System.out.println(counter);

		repaint();

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.orange);
		g.setFont(new Font("Serif",Font.BOLD,48));

		String counterS = ""+counter;
		
		g.drawString(counterS, 10, 50);


	}

}
