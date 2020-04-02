import java.awt.*;

//Each button has two listeners. There is three different listeners throughout the program
//When the window is resized, the window is repainted. Thus, paintComponent is called and the window is repainted. A new random color is chosen
//for the ovals and the text
public class Lab7Run {

	public static void main(String[] args) {

		Lab7Frame frame = new Lab7Frame();
		frame.setUpFrame();

		frame.pack();
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(600,600));
		frame.repaint();

		// this method must finish and return before GUI 
		// handling begins
	}

}
