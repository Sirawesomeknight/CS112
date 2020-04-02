import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hitori extends PuzzlePanel{

    private int[] values;
    private int[] defaultValues = {4, 5, 1, 2, 4, 5, 4, 3, 2, 1, 3, 3, 2, 1, 5, 1, 4, 5, 3, 2, 5, 1, 4, 4, 4};

    private HitoriBtn[] btns;

    private HitoriSolver solver;

    Container cp;

    public Hitori(Container cp){
        super(cp);

        if(!readFromFile()){
            values = defaultValues;
        }

        btns = new HitoriBtn[grid * grid];

        for(int i = 0; i < btns.length; i++){
            btns[i] = new HitoriBtn(values[i],this);
            this.add(btns[i]);
        }

        solver = new HitoriSolver(grid);
    }

    private boolean readFromFile(){
        File file = new File("Hitori.txt");
        if(file.canRead() && file.exists()){
            try {
                Scanner scan = new Scanner(file);
                int grid = scan.nextInt();
                values = new int[grid * grid];
                int counter = 0;
                scan.nextLine();
                while(scan.hasNextLine()){
                    String init = scan.nextLine();
                    String[] strings = init.split(" ");
                    for(int i = 0; i < strings.length; i++){
                        values[counter] = Integer.parseInt(strings[i]);
                        counter++;
                    }
                }
                if(counter != grid * grid) {
                    JOptionPane.showMessageDialog(cp, "Error with Hitori.txt Using default setup...");
                    return false;
                }else{
                    this.grid = grid;
                    return true;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            }
        }else{
            return false;
        }
    }

    public void resetValues(){
        for(int i = 0; i < btns.length; i++){
            btns[i].setBtnValue(Integer.parseInt(btns[i].getText()));
        }
    }

    public void reset(){
        for(int i = 0; i < btns.length; i++){
            btns[i].unselectBtn();
        }
    }

    public Spot[] getSpots(){
        return btns;
    }

    public Solver getSolver(){
        return solver;
    }

    public int checkWin(){
        int checker = solver.checkConstraints(btns);
        if(checker == 0){
            JOptionPane.showMessageDialog(cp, "You Failed!");
            reset();
        }else if(checker == 2){
            JOptionPane.showMessageDialog(cp, "You Won!");
            reset();
        }
        return 1;
    }
}
