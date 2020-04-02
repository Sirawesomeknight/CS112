import javax.swing.*;
import java.awt.*;

public class SideMenu extends JPanel{

    private JButton solvePuzzle;
    private JButton resetPuzzle;

    public SideMenu(Container cp, Hitori hitori){

        JButton changePuzzle = new JButton("Change Puzzle");
        changePuzzle.addActionListener(new ChangePuzzleAction(changePuzzle,cp,this));

        solvePuzzle = new JButton("Solve Puzzle");
        solvePuzzle.addActionListener(new SolvePuzzleListener(hitori.getSolver(),hitori));

        resetPuzzle = new JButton("Reset Puzzle");
        resetPuzzle.addActionListener(new ResetAction(cp,hitori));

        this.add(changePuzzle);
        this.add(solvePuzzle);
        this.add(resetPuzzle);

    }

    public void updateSideButtons(Container cp, PuzzlePanel panel){
        solvePuzzle.removeActionListener(solvePuzzle.getActionListeners()[0]);
        resetPuzzle.removeActionListener(resetPuzzle.getActionListeners()[0]);
        solvePuzzle.addActionListener(new SolvePuzzleListener(panel.getSolver(),panel));
        resetPuzzle.addActionListener(new ResetAction(cp,panel));
    }
}
