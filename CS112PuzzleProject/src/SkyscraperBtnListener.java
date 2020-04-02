import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SkyscraperBtnListener implements ActionListener {
    private SkyscraperBtn btn;
    private boolean isSelected;
    private Skyscraper skyscraper;

    public SkyscraperBtnListener(SkyscraperBtn btn, boolean isSelected, Skyscraper skyscraper){
        this.btn = btn;
        this.isSelected = isSelected;
        this.skyscraper = skyscraper;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!isSelected){
            btn.selectBtn();
            skyscraper.checkWin();
        }else{
            btn.unselectBtn();
        }
    }
}
