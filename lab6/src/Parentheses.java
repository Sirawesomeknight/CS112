import java.util.Scanner;

public class Parentheses {

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);

        String s = scan.nextLine();

        Parentheses readParen = new Parentheses();

        System.out.println(readParen.balanced(s));
    }

    public boolean balanced(String input) {

        CS112Stack<Character> theStack = new CS112Stack<Character>();

        for (byte i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '[') {
                theStack.push(input.charAt(i));
            }else if(input.charAt(i) == ')' || input.charAt(i) == '}' || input.charAt(i) == ']'){
                if(!theStack.isEmpty()){
                    if(pairings(theStack.top(),input.charAt(i))){
                        theStack.pop();
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }

        if(!theStack.isEmpty()){
            return false;
        }

        return true;
    }

    private boolean pairings(char a, char b){
        if(a == '(' && b == ')'){
            return true;
        }else if(a == '{' && b == '}'){
            return true;
        }else if(a == '[' && b == ']'){
            return true;
        }else{
            return false;
        }
    }

}
