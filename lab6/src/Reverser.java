import java.util.Scanner;

public class Reverser {

    public static void main(String arg[]){

        Scanner scan = new Scanner(System.in);

        String s = scan.nextLine();

        Reverser theReverse = new Reverser();

        System.out.println(theReverse.reverse(s));

    }

    public String reverse(String s){

        CS112Stack<Character> theStack = new CS112Stack<Character>();

        for(byte i = 0; i < s.length(); i++){
            theStack.push(s.charAt(i));
        }

        String output = "";

        while(!theStack.isEmpty()){
            output = output + theStack.pop();
        }

        return output;
    }

}
