package sprint2;

import javax.swing.JOptionPane;

public class Kund extends Person {

    private String Message = "Personen är kund!";

    public Kund(String pnr, String namn) {
        super(pnr, namn);
    }

    @Override
    public int getIfKund() {
        return 2;
    }

    @Override
    public void Message() throws InterruptedException {
        JOptionPane pane = new JOptionPane(Message, JOptionPane.INFORMATION_MESSAGE);
        showMessage(pane);
    }
}
