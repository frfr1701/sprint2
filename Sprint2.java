package sprint2;

import static javax.swing.JOptionPane.*;
import java.util.List;

public class Sprint2 {

    void program() {
        while (true) {
            boolean noCustomer = true;
            String input = showInputDialog("Skriv in ett personnummer eller namn");
            if (input == null || input.equals("")) {
                break;
            }
            Databas databas = new Databas();
            List<IPerson> ListCustomers = databas.getAllPersons();
            for (IPerson ListCustomer : ListCustomers) {
                if (ListCustomer.compareName(input) || ListCustomer.comparePnr(input)) {
                    noCustomer = false;
                    ListCustomer.showMessage();
                    if (ListCustomer instanceof Kund) {
                        ListCustomer.findDatumUsePrintToFile();
                    }
                }
            }
            if (noCustomer) {
                Person neverCustomer = new InteKund();
                neverCustomer.showMessage();
            }
        }
    }

    public static void main(String[] args) {
        Sprint2 start = new Sprint2();
        String[] Alternativ = {"Checka in Medlemmar", "Stäng av program"};
        program:
        while (true) {
            int svar = showOptionDialog(null, "Sats Värdmö",
                    "Gym", DEFAULT_OPTION, INFORMATION_MESSAGE, null, Alternativ, 0);
            switch (svar) {
                case -1:
                    break program;
                case 1:
                    break program;
                case 0:
                    start.program();
                    break;
            }
        }
    }
}
