

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
public class Game {

	public int guests = 7;
	public int stride = 2;


	public void setGuests(int guests) {
		this.guests = guests;
	}

	public void setStride(int stride) {
		this.stride = stride;
	}

	Scanner kb = new Scanner(System.in);

	public ArrayList<String> playGame() {

		ArrayList<String> answers = new ArrayList<String>();
		answers.add("Pasta on ");
		
		LinkedList<Integer> q = new LinkedList<Integer>();

		for (int i=1; i<guests+1; i++) 
			q.add(i);

		for (int i=0; i<guests-1; i++) {
			answers.add(q.removeFirst()+" ");
			for (int j=0; j<stride-1; j++) {
				q.add(q.removeFirst());
			}
		}

		answers.add(" Gold to "+q.removeFirst());
		if (!q.isEmpty())
			System.out.println("Problem - Queue isn't empty");
		return answers;

	}

	public int getGuests() {
		return guests;
	}

	public int getStride() {
		return stride;
	}
}
