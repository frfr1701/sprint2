package sprint2;

import javax.swing.JOptionPane;

public class VaritKund extends Person {

    private String Message = "Personen har varit kund!";

    public VaritKund(String pnr, String namn) {
        super(pnr, namn);
    }

    @Override
    public int getIfKund() {
        return 1;
    }

    @Override
    public void Message() throws InterruptedException {
        JOptionPane pane = new JOptionPane(Message, JOptionPane.INFORMATION_MESSAGE);
        showMessage(pane);
    }
}
