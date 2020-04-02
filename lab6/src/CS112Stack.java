import java.util.ArrayList;

public class CS112Stack<E> {

	ArrayList<E> theStack = new ArrayList<E>();
	
	public void push(E toPush) {
		theStack.add(toPush);
	}
	
	public boolean isEmpty() {
		return theStack.size() == 0;
	}
	
	public E pop() {
		if (isEmpty())
			return null;
		else {
			E top = theStack.remove(theStack.size()-1);
			return top;
		}
	}
	
	public E top() {
		if (isEmpty())
			return null;
		else {
			E top = theStack.get(theStack.size()-1);
			return top;
		}
	}
	
	public void printStack() {
		for (E element : theStack)
			System.out.println(element);
	}
	
	
	
	
	
}
