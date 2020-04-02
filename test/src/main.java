public class main {
    public static void main(String[] args){
        int size = 7;
        for(int i = 0; i < size + 2; i++){
            for(int j = 0; j < size + 2; j++){
                if(j == 0 || i == j || i + j == ((size + 2) - 1) || j == (size + 2) - 1){
                    System.out.print("+");
                }else{
                    System.out.print("-");
                }
            }
            System.out.println("");
        }
    }
}
