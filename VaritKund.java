package sprint2;

import javax.swing.JOptionPane;

public class VaritKund extends Person {

    String IfKund = "Personen har varit kund!";

    public VaritKund(String pnr, String namn) {
        super(pnr, namn);
    }

    @Override
    public String getIfKund() {
        return IfKund;
    }

    @Override
    public void Message() throws InterruptedException {
        JOptionPane pane = new JOptionPane(getIfKund(), JOptionPane.INFORMATION_MESSAGE);
        showMessage(pane);
    }
}
