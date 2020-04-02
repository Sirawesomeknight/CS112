import javax.swing.*;
import java.awt.*;

public class PuzzlePanel extends JPanel {
    public int grid = 5;

    public Solver solver;

    public Container cp;

    private Spot[] spots;

    public PuzzlePanel(Container cp){
        int newHeight = (int) Math.floor(cp.getSize().height * 0.6);
        this.setPreferredSize(new Dimension(cp.getSize().width,newHeight));
        grid = 5;
        this.setLayout(new GridLayout(grid,grid));
        this.cp = cp;
    }

    public boolean solvePuzzle(Solver solver,Spot[] spots){

        boolean trySolver = solver.initialSolver(spots);
        if(trySolver){
            Spot[] sspots = solver.getSavedSpots();
            for(int i = 0; i < sspots.length; i++){
                if(sspots[i].getBtnValue() == 0){
                    spots[i].selectBtn();
                }
            }
            return true;
        }else{
            return false;
        }

    }

    public Spot[] getSpots(){
        return spots;
    }

    public int checkWin(){
        return solver.checkConstraints(spots);
    }


    public void reset() {

    }

    public Solver getSolver(){
        return solver;
    }
}
