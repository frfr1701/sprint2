package sprint2;

import java.util.concurrent.TimeUnit;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public abstract class Person implements CheckKund {

    private String pnr;
    private String namn;

    public Person(String pnr, String namn) {
        this.pnr = pnr;
        this.namn = namn;
    }

    public Person() {
    }

    String getNamn() {
        return namn;
    }

    String getPnr() {
        return pnr;
    }

    @Override
    public boolean compare(String CheckPerson) {
        return CheckPerson.equalsIgnoreCase(pnr) || CheckPerson.equalsIgnoreCase(namn);
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
