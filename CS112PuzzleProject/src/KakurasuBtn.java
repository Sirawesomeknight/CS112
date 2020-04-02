import java.awt.*;

public class KakurasuBtn extends Spot {

    public KakurasuBtn(int num, Kakurasu kakurasu){
        super(num);
        this.addActionListener(new KakurasuBtnListener(this,selected,kakurasu));
    }

    public void selectBtn(){
        this.setBackground(Color.gray);
        setBtnValue(0);
        setSelected(true);
    }

    public void unselectBtn(){
        this.setBackground(Color.green);
        setBtnValue(1);
        setSelected(false);
    }
}
