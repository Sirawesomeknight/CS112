import java.util.Scanner;

public class PostFixEval {
    public static void main(String args[]) {
        Scanner scan = new Scanner("2 17 * 4 + 3 4 + + =");
        PostFixEval pfe = new PostFixEval();
        System.out.println(pfe.value(scan));
    }

    public int value(Scanner scan){


        CS112Stack<Integer> theStack = new CS112Stack<Integer>();

        while(true) {
            if (scan.hasNextInt()) {
                theStack.push(scan.nextInt());
            } else {
                String operator = scan.next();
                if (!operator.equals("=")) {
                    int combined = 0;
                    int first = theStack.pop();
                    int second = theStack.pop();
                    switch (operator) {
                        case "+":
                            combined = second + first;
                            break;
                        case "-":
                            combined = second - first;
                            break;
                        case "*":
                            combined = second * first;
                            break;
                        case "/":
                            combined = second / first;
                            break;
                    }
                    theStack.push(combined);
                } else {
                    return theStack.pop();
                }
            }
        }
    }
}
