import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Kakurasu extends PuzzlePanel {

    private KakurasuBtn[] btns;

    int[] puzzlelabels = {15,10,11,2,3,1,10,8,4,6};

    public Kakurasu(Container cp){
        super(cp);
        this.setLayout(new GridLayout(grid + 2,grid + 2));
        JLabel[] labels = new JLabel[grid * 2];
        for(int i = 0; i <= 1; i++) {
            for (int j = 0; j < grid; j++) {
                labels[(grid * i) + j] = new JLabel(String.valueOf(j + 1));
            }
        }

        btns = new KakurasuBtn[grid * grid];

        this.add(new JLabel(""));
        for(int i = 0; i < grid; i++){
            this.add(labels[i]);
        }
        this.add(new JLabel(""));

        for(int i = 0; i < grid; i++){
            this.add(labels[i + grid]);
            for(int j = i * grid; j < (i * grid + grid); j++) {
                btns[j] = new KakurasuBtn(1,this);
                this.add(btns[j]);
            }
            this.add(new JLabel(String.valueOf(puzzlelabels[i])));
        }

        this.add(new JLabel(""));
        for(int i = grid; i < grid * 2; i++){
            this.add(new JLabel(String.valueOf(puzzlelabels[i])));
        }
        this.add(new JLabel(""));

        solver = new KakurasuSolver(grid, Arrays.copyOfRange(puzzlelabels,0,grid),Arrays.copyOfRange(puzzlelabels, grid,puzzlelabels.length));
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
        return super.solvePuzzle(solver, spots);
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
