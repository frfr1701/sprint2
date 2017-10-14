package sprint2;

import javax.swing.JOptionPane;

public class InteKund extends Person{
    String IfKund="Personen är inte kund!";
    @Override
    public String getIfKund(){
        return IfKund;
    }
    @Override
    public void Message() throws InterruptedException {
        JOptionPane pane = new JOptionPane(getIfKund(), JOptionPane.INFORMATION_MESSAGE);
        showMessage(pane);
    }
}
