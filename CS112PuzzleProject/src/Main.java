import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public Main(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setName("Jhulsizer's puzzles");

        Container cp = this.getContentPane();
        cp.setLayout(new BorderLayout());

        Hitori hitori = new Hitori(cp);
        cp.add(hitori,BorderLayout.CENTER);

        SideMenu sidemenu = new SideMenu(cp,hitori);
        cp.add(sidemenu, BorderLayout.PAGE_END);
    }

    public static void main(String args[]){
        Main window = new Main();

        window.pack();

        window.setSize(new Dimension(800,600));

        window.setResizable(false);

        window.setVisible(true);
    }
}
