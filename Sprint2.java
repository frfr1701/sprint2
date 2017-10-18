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
            Databas databas = new Databas(); //Här gör jag ett objekt av databasen
            List<IPerson> ListCustomers = databas.getAllPersons(); //Här hämtar jag listan av alla objekt 
            for (IPerson ListCustomer : ListCustomers) { //Här har jag en for each loop med varje objekt
                if (ListCustomer.compareName(input) || ListCustomer.comparePnr(input)) { //Här jämför jag min input med personnummer och namn.
                    noCustomer = false; 
                    ListCustomer.showMessage(); //Anropar meddelandet för personen
                    if (ListCustomer instanceof Kund) { //Om personen bara är kund
                        ListCustomer.findDatumUsePrintToFile(); //Printar beroende på datum och alltid personen
                    }
                }
            }
            if (noCustomer) { //Om det inte fanns en kund som hette så
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
