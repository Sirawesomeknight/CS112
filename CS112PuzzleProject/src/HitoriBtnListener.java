import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HitoriBtnListener implements ActionListener {

    private HitoriBtn btn;
    private boolean isSelected;
    private Hitori hitori;

    public HitoriBtnListener(HitoriBtn btn, boolean isSelected, Hitori hitori){
        this.btn = btn;
        this.isSelected = isSelected;
        this.hitori = hitori;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!isSelected){
            btn.selectBtn();
            hitori.checkWin();
        }else{
            btn.unselectBtn();
        }
    }
}
