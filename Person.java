package sprint2;

import java.util.concurrent.TimeUnit;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public abstract class Person implements CheckKund{
    protected String pnr;
    protected String namn;
    protected String IfKund;
    public Person(String pnr, String namn, String IfKund) {
        this.namn = namn;
        this.pnr = pnr;
        this.IfKund=IfKund;
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
    public String getIfKund(){
        return IfKund;
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
