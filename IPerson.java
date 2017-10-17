package sprint2;

import javax.swing.JOptionPane;

public interface IPerson {

    public boolean compare(String CheckPerson);

    public int getIfKund();

    public void Message();

    public void showMessage(JOptionPane pane) throws InterruptedException;
}
