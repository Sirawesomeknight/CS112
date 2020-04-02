import java.awt.*;

public class HitoriBtn extends Spot{

    public HitoriBtn(int num,Hitori hitori){
        super(num);
        this.setText(String.valueOf(num));
        this.addActionListener(new HitoriBtnListener(this,selected,hitori));
    }

    public void selectBtn(){
        this.setBackground(Color.gray);
        setBtnValue(0);
        setSelected(true);
    }

    public void unselectBtn(){
        this.setBackground(Color.green);
        setBtnValue(Integer.parseInt(this.getText()));
        setSelected(false);
    }
}
