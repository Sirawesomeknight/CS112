import java.awt.event.*;

public class GoodSpotHandler implements ActionListener {

	
	private TheGame g;
	private Lab7Frame frame;
	private int buttonNum;
	
	public GoodSpotHandler(TheGame game1, Lab7Frame fr, int btnNum) {
		g = game1;
		frame = fr;
		buttonNum = btnNum;
	}

	public void actionPerformed(ActionEvent e) {
		g.spot(buttonNum);
		if (g.getDoneMessage() != null) {
			frame.setDoneMessage(g.getDoneMessage());
		}
		// ask for the Lab7Frame to be repainted
		frame.repaint();
	}

}
