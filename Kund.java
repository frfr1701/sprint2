package sprint2;

import javax.swing.JOptionPane;

public class Kund extends Person{
    public Kund(String pnr, String namn, String IfKund) {
        super(pnr, namn, IfKund);  
    }
    @Override
    public void Message() throws InterruptedException{
        JOptionPane pane = new JOptionPane(getIfKund(), JOptionPane.INFORMATION_MESSAGE);
        showMessage(pane);
    }
}
