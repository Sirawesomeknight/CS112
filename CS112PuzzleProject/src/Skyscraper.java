import javax.swing.*;
import java.awt.*;

public class Skyscraper extends PuzzlePanel {

    private SkyscraperBtn[] btns;

    private int[] puzzlelabels = {2,1,5,2,2,2,2,1,3,2,1,4,2,2,3,3,4,1,2,3};

    public Skyscraper(Container cp) {
        super(cp);
        this.setLayout(new GridLayout(grid + 2,grid + 2));

        btns = new SkyscraperBtn[grid * grid];

        int[] top = new int[grid];
        int[] right = new int[grid];
        int[] left = new int[grid];
        int[] bottom = new int[grid];

        this.add(new JLabel(""));
        for(int i = 0; i < grid; i++){
            this.add(new JLabel(String.valueOf(puzzlelabels[i])));
            top[i] = puzzlelabels[i];
        }
        this.add(new JLabel(""));

        for(int i = 0; i < grid; i++){
            this.add(new JLabel(String.valueOf(puzzlelabels[i * 2 + grid])));
            left[i] = puzzlelabels[i * 2 + grid];
            for(int j = i * grid; j < (i * grid + grid); j++) {
                btns[j] = new SkyscraperBtn(0,this,grid);
                this.add(btns[j]);
            }
            this.add(new JLabel(String.valueOf(puzzlelabels[(i * 2 + 1) + grid])));
            right[i] = puzzlelabels[(i * 2 + 1) + grid];
        }

        this.add(new JLabel(""));
        for(int i = (grid * 4) - grid; i < grid * 4; i++){
            this.add(new JLabel(String.valueOf(puzzlelabels[i])));
            bottom[i - (grid * 4 - grid)] = puzzlelabels[i];
        }
        this.add(new JLabel(""));

        solver = new SkyscraperSolver(grid,top,right,bottom,left);
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

    @Override
    public boolean solvePuzzle(Solver solver, Spot[] spots) {
        if(super.solvePuzzle(solver, spots)){
            Spot[] sspots = solver.getSavedSpots();
            for(int i = 0; i < sspots.length; i++){
                spots[i].selectBtn();
                spots[i].setBtnValue(sspots[i].getBtnValue());
            }
            return true;
        }else{
            return false;
        }
    }

    public int checkWin(){
        int checker = solver.checkConstraints(getSpots());
        System.out.println("nigeria");
        if(checker == 0){
            //JOptionPane.showMessageDialog(cp, "You Failed!");
            //reset();
        }else if(checker == 2){
            JOptionPane.showMessageDialog(cp, "You Won!");
            reset();
        }
        return 1;
    }

}
