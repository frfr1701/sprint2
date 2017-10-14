package sprint2;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.util.List;

public class Sprint2 {

    List<Person> ListCustomers;
    String loggString = "src\\sprint2\\logg.txt";
    Path logg = Paths.get("src\\sprint2\\logg.txt");
    String dayString = "///" + LocalDate.now().toString() + "///";

    void databasen() throws IOException {
        Databas databas = new Databas();
        ListCustomers = databas.getAllPersons();
    }

    void program() throws IOException, InterruptedException {
        boolean exit = true;
        while (exit) {
            boolean noCustomer = true;
            String check = JOptionPane.showInputDialog("Skriv in ett personnummer eller namn");
            if (check == null || check.equals("")) {
                exit = false;
                break;
            }
            for (Person ListCustomer : ListCustomers) {
                if (check.equalsIgnoreCase(ListCustomer.getNamn()) || check.equalsIgnoreCase(ListCustomer.getPnr())) {
                    noCustomer = false;
                    ListCustomer.Message();
                    if (ListCustomer.getIfKund().equalsIgnoreCase("Personen är kund!")) {
                        try (PrintWriter pw = new PrintWriter(new FileWriter(loggString, true));
                                BufferedReader br = Files.newBufferedReader(logg)) {
                            String compare = "";
                            int nodatefound = 1;
                            while ((compare = br.readLine()) != null) {
                                LocalDate dagensDatum = LocalDate.now();
                                compare = compare.trim();
                                if (!compare.equals("")) {
                                    if (compare.charAt(0) == '/' || compare.charAt(1) == '/' || compare.charAt(2) == '/') {
                                        nodatefound = 0;
                                        compare = compare.replace("/", " ");
                                        compare = compare.trim();
                                        if (dagensDatum.isAfter(LocalDate.parse(compare))) {
                                            nodatefound = 1;
                                        }
                                        if (dagensDatum.isEqual(LocalDate.parse(compare))) {
                                            nodatefound = 0;
                                        }
                                    }
                                }

                            }
                            if (nodatefound == 1) {
                                pw.println(dayString);
                            }
                            pw.println(ListCustomer.getPnr() + ", " + ListCustomer.getNamn());
                        } catch (Exception e) {
                            System.out.println("Man kan inte läsa filen!");
                        }
                    }
                }
            }
            if (noCustomer) {
                Person neverCustomer = new InteKund();
                neverCustomer.Message();
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
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
                    start.databasen();
                    start.program();
                    break;
            }
        }
        System.exit(0);
    }
}
