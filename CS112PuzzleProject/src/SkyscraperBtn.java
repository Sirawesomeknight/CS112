import java.awt.*;

public class SkyscraperBtn extends Spot {

    private int grid;

    public SkyscraperBtn(int num, Skyscraper skyscraper, int grid){
        super(num);
        this.setBackground(Color.blue);
        this.setForeground(Color.green);
        this.setFont(new Font("Arial", Font.PLAIN, 40));
        this.grid = grid;
        this.addActionListener(new SkyscraperBtnListener(this,selected,skyscraper));
    }

    public void selectBtn(){
        this.setBackground(Color.YELLOW);
        if(getBtnValue() == grid){
            setBtnValue(1);
        }else {
            setBtnValue(getBtnValue() + 1);
        }
        this.setText(String.valueOf(getBtnValue()));
        setSelected(true);
    }

    public void unselectBtn(){
        this.selected = false;
        this.setBackground(Color.blue);
        setBtnValue(0);
        this.setText("");
    }

    public void setBtnValue(int value){
        this.setText(String.valueOf(value));
        super.setBtnValue(value);
    }
}
