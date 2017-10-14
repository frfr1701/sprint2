package sprint2;

import javax.swing.JOptionPane;

public interface CheckKund {

    public boolean compare(String CheckPerson);

    public int getIfKund();

    public void Message() throws InterruptedException;

    public void showMessage(JOptionPane pane) throws InterruptedException;
}
