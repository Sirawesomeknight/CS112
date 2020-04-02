import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePuzzleAction implements ActionListener {
    JPopupMenu menu;
    JButton button;

    public ChangePuzzleAction(JButton button, Container cp, SideMenu bigMenu){
        this.button = button;

        menu = new JPopupMenu();

        JMenuItem hitori = new JMenuItem("Hitori");
        menu.add(hitori);
        hitori.addActionListener(new PuzzleAction("hit",cp,bigMenu));

        JMenuItem kakurasu = new JMenuItem("Karukasu");
        menu.add(kakurasu);
        kakurasu.addActionListener(new PuzzleAction("rasu",cp,bigMenu));

        JMenuItem skyscraper = new JMenuItem("Skyscraper");
        menu.add(skyscraper);
        skyscraper.addActionListener(new PuzzleAction("sky",cp,bigMenu));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        menu.show(button,button.getWidth()/2,button.getHeight()/2);
    }
}
