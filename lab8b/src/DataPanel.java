

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;


public class DataPanel extends JPanel {
	
	private Game theGame;
	
	public DataPanel(Game g) {
		theGame = g;
		setPreferredSize(new Dimension(200,400))
;	}
	
    @Override
	public void paintComponent(Graphics g) {
		
		int guests = theGame.getGuests();
		int stride = theGame.getStride();
		
		g.setColor(Color.blue);
		g.setFont(new Font("Serif",Font.BOLD,24));
		g.drawString(""+guests,10,50);
		
		g.setColor(Color.red);
		g.drawString(""+stride,100,50);
		
	}

	
	
	
}
