package sprint2;

import javax.swing.JOptionPane;

public interface CheckKund {

    public String getNamn();

    public String getPnr();

    public String getIfKund();

    public void Message() throws InterruptedException;

    public void showMessage(JOptionPane pane) throws InterruptedException;
}
