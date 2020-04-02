
import java.awt.*;
import javax.swing.*;

public class UseSimple extends JFrame {

	public static void main(String[] args) {

		SimpleAnimationExample thisOne = new SimpleAnimationExample();
		thisOne.init();

		thisOne.pack();
		thisOne.setVisible(true);
		thisOne.setSize(new Dimension(500,500));
	}
}
