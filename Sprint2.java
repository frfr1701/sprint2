package sprint2;

import javax.swing.JOptionPane;
import java.util.List;

public class Sprint2 {

    void program() {
        while (true) {
            boolean noCustomer = true;
            String check = JOptionPane.showInputDialog("Skriv in ett personnummer eller namn");
            if (check == null || check.equals("")) {
                break;
            }
            Databas databas = new Databas();
            List<Person> ListCustomers = databas.getAllPersons();
            for (Person ListCustomer : ListCustomers) {
                if (ListCustomer.compare(check)) {
                    noCustomer = false;
                    ListCustomer.Message();
                    if (ListCustomer.getIfKund() == 2) {
                        ListCustomer.findDatumUsePrintToFile();
                    }
                }
            }
            if (noCustomer) {
                Person neverCustomer = new InteKund();
                neverCustomer.Message();
            }
        }
    }

    public static void main(String[] args) {
        Sprint2 start = new Sprint2();
        boolean exitProgram = true;
        String[] Alternativ = {"Checka in Medlemmar", "Stäng av program"};
        while (exitProgram) {
            int svar = JOptionPane.showOptionDialog(null, "Sats Värdmö",
                    "Gym", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Alternativ, 0);
            switch (svar) {
                case -1:
                    exitProgram = false;
                    break;
                case 1:
                    exitProgram = false;
                    break;
                case 0:
                    start.program();
                    break;
            }
        }
        System.exit(0);
    }
}
