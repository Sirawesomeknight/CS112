import java.util.Scanner;

public class Convert {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        Convert convert = new Convert();
        System.out.println(convert.convert(scan));
    }

    public String convert(Scanner scan){
        CS112Stack<TheOperators> theStack = new CS112Stack<TheOperators>();

        String output = "";

        int basePrecedent = 0;

        while(true) {
            if(scan.hasNextInt()){
                output = output + scan.nextInt() + " ";
            }else{
                char theOperator = scan.next().charAt(0);
                if(theOperator == '('){
                    basePrecedent = basePrecedent + 4;
                }else if(theOperator == ')'){
                    basePrecedent = basePrecedent - 4;
                }else if (theOperator == '+' || theOperator == '-' || theOperator == '*' || theOperator == '/'){
                    TheOperators operator = new TheOperators();
                    operator.operator = theOperator;
                    if (operator.operator == '+' || operator.operator == '-') {
                        operator.precedence = 1 + basePrecedent;
                    } else {
                        operator.precedence = 2 + basePrecedent;
                    }
                    if(!theStack.isEmpty()) {
                        while (theStack.top().precedence >= operator.precedence) {
                            output = output + theStack.pop().operator + " ";
                            if(theStack.isEmpty()){
                                break;
                            }
                        }
                    }
                    theStack.push(operator);
                }else{
                    while(!theStack.isEmpty()){
                        output = output + theStack.pop().operator + " ";
                    }
                    output = output + "=";
                    return output;
                }
            }
        }
    }
}
