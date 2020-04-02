import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;


public class FunPanel extends JPanel implements ActionListener {

	int number = 25;
	Color[] cs;
	int offset = 0;

	private Mouse mouse;

	private JPanel savedImage;
	private BufferedImage bi;
	private Graphics g2;

	public FunPanel() {
		cs = new Color[4];

		cs[0] = new Color(255,0,0);
		cs[1] = new Color(0,255,0);
		cs[2] = new Color(0,0,255);
		cs[3] = new Color(0,255,255);

		setPreferredSize(new Dimension(400, 400));

		mouse = new Mouse();

		this.addMouseMotionListener(mouse);

		savedImage = new JPanel();
		savedImage.setPreferredSize(new Dimension(400,400));

		bi = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
		g2 = bi.createGraphics();
		savedImage.paint(g2);
	}

	public void changeColors() {

		for (int j = 0; j<4; j++) {

			cs[j] = new Color((int) (Math.random()*255),
					(int) (Math.random()*255),
					(int) (Math.random()*255));

		}
	}

	public void bump() {
		offset++;
		repaint();
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(bi,0,0,400,400,null);

		int x = mouse.getX();
		int y = mouse.getY();

		g.setColor(cs[0]);

		g.fillOval(x,y,20,20);

		g2.setColor(cs[0]);

		g2.fillOval(x,y,20,20);

	}



	public void actionPerformed(ActionEvent arg0) {
		changeColors();
		repaint();

	}



}
