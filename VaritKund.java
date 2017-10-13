package sprint2;

import javax.swing.JOptionPane;

public class VaritKund extends Person{
    public VaritKund(String pnr, String namn, String IfKund) {
        super(pnr, namn, IfKund);  
    }
    @Override
    public void Message() throws InterruptedException{
        JOptionPane pane = new JOptionPane(getIfKund(), JOptionPane.INFORMATION_MESSAGE);
        showMessage(pane);
    }
}
