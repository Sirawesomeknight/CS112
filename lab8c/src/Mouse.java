import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseMotionListener {

    private int x;
    private int y;

    public Mouse(){
        x = 0;
        y = 0;
    }
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
