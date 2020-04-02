import javax.swing.*;
import java.awt.*;

public class Spot extends JButton {

    public boolean selected = false;
    private int value;


    public Spot(int num){
        this.setBackground(Color.green);
        value = num;
    }

    public int getBtnValue(){
        return value;
    }

    public void setBtnValue(int value){
        this.value = value;
    }

    public void selectBtn(){
        this.selected = true;
    }

    public void setSelected(boolean value){
        this.selected = value;
    }

    public boolean isSelected(){
        System.out.println("ran");
        return this.selected;
    }

    public void unselectBtn(){
        this.selected = false;
    }
}
