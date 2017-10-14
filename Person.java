package sprint2;

import java.util.concurrent.TimeUnit;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public abstract class Person implements CheckKund{
    protected String pnr;
    protected String namn;
    public Person(String pnr, String namn) {
        this.pnr = pnr;
        this.namn = namn;
    }
    public Person(){
    }
    @Override
    public String getNamn(){
        return namn;
    }
    @Override
    public String getPnr(){
        return pnr;
    }
    
    @Override
    public void showMessage(JOptionPane pane) throws InterruptedException {
        JDialog all = pane.createDialog(null, "Gym");
        all.setModal(false);
        all.setVisible(true);
        TimeUnit.SECONDS.sleep(2);
        all.setVisible(false);
    }
}
