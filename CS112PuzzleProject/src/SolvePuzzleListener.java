import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SolvePuzzleListener implements ActionListener {

    private PuzzlePanel panel;
    private Solver solver;

    public SolvePuzzleListener(Solver solver, PuzzlePanel panel){
        this.panel = panel;
        this.solver = solver;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panel.solvePuzzle(solver,panel.getSpots());
    }
}
