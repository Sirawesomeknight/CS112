import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KakurasuBtnListener implements ActionListener {

    private KakurasuBtn btn;
    private boolean isSelected;
    private Kakurasu kakurasu;

    public KakurasuBtnListener(KakurasuBtn btn, boolean isSelected, Kakurasu kakurasu){
        this.btn = btn;
        this.isSelected = isSelected;
        this.kakurasu = kakurasu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!isSelected){
            btn.selectBtn();
            kakurasu.checkWin();
        }else{
            btn.unselectBtn();
        }
    }
}
