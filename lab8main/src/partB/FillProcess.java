package partB;

import java.util.ArrayList;

import javax.swing.JTextField;


public class FillProcess {

	private JTextField putHere;
	private ArrayList<String> putThis;
	
	public FillProcess(JTextField outField, ArrayList<String> s) {
		putHere = outField;
		putThis = s;
	}

	public void run() {

		for (String one : putThis) {
			
			String alreadyThere = putHere.getText();
			String newText = alreadyThere + one;
			putHere.setText(newText);
			System.out.println(newText);



		}
		
		
	}

}
