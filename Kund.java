package sprint2;

import javax.swing.JOptionPane;

public class Kund extends Person {

    String IfKund = "Personen är kund!";

    public Kund(String pnr, String namn) {
        super(pnr, namn);
    }

    @Override
    public String getIfKund() {
        return IfKund;
    }

    @Override
    public void Message() throws InterruptedException {
        JOptionPane pane = new JOptionPane(IfKund, JOptionPane.INFORMATION_MESSAGE);
        showMessage(pane);
    }
}
