
public class UseStack {

    public static void main(String[] args) {

	UseStack use;
	use = new UseStack();
	use.go();

    }

    public void go() {

	CS112Stack<Character> s = new CS112Stack<Character>();

	for (char i='a'; i<='z';i++)
	    {
		s.push(i);
	    }

	while (!s.isEmpty())
	    {
		System.out.print(s.pop());
	    }

	System.out.println();
    }

}
