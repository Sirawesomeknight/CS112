import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PuzzleAction implements ActionListener {

    private String puzzle;
    private Container cp;
    private SideMenu menu;

    public PuzzleAction(String puzzle, Container cp,SideMenu menu){
        this.puzzle = puzzle;
        this.cp = cp;
        this.menu = menu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cp.remove(0);
        switch (puzzle){
            case "hit":
                Hitori hitori = new Hitori(cp);
                cp.add(hitori,0);
                menu.updateSideButtons(cp,hitori);

            break;
            case "rasu":
                Kakurasu kakurasu = new Kakurasu(cp);
                cp.add(kakurasu,0);
                menu.updateSideButtons(cp,kakurasu);
            break;
            case "sky":
                Skyscraper skyscraper = new Skyscraper(cp);
                cp.add(skyscraper,0);
                menu.updateSideButtons(cp,skyscraper);
                break;
        }
        cp.revalidate();
        cp.repaint();
    }
}
