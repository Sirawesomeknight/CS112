import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetAction implements ActionListener {

    private Container cp;

    private PuzzlePanel reset;

    public ResetAction(Container cp, PuzzlePanel reset){
        this.cp = cp;
        this.reset = reset;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        reset.reset();
    }
}
