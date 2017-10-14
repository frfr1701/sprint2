package sprint2;

import javax.swing.JOptionPane;

public class InteKund extends Person {

    private String Meddelande = "Personen är inte kund!";

    @Override
    public int getIfKund() {
        return 0;
    }

    @Override
    public void Message() throws InterruptedException {
        JOptionPane pane = new JOptionPane(Meddelande, JOptionPane.INFORMATION_MESSAGE);
        showMessage(pane);
    }
}
