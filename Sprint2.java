package sprint2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;
import javax.swing.JDialog;

public class Sprint2 {

    JOptionPane pane = new JOptionPane();
    Path customers = Paths.get("src\\sprint2\\customers.txt");
    Path logg = Paths.get("src\\sprint2\\logg.txt");
    String loggString = "src\\sprint2\\logg.txt";
    String dayString = "";
    int daynote = 0;
    int nodatefound = 1;

    void showMessage() throws InterruptedException {
        JDialog all = pane.createDialog(null, "Gym");
        all.setModal(false);
        all.setVisible(true);
        TimeUnit.SECONDS.sleep(2);
        all.setVisible(false);
    }

    void checkMemberProgram() throws IOException {

        boolean exit = true;
        try (BufferedReader brlogg = Files.newBufferedReader(logg)) {
            LocalDate dagensDatum = LocalDate.now();
            dayString = "///" + dagensDatum.toString() + "///";
            String compare = "";
            while ((compare = brlogg.readLine()) != null) {
                compare=compare.trim();
                if(!compare.equals("")){
                    if (compare.charAt(0) == '/' || compare.charAt(1) == '/' || compare.charAt(2) == '/') {
                        nodatefound = 0;
                        compare = compare.replace("/", " ");
                        compare = compare.trim();
                        if (dagensDatum.isAfter(LocalDate.parse(compare))) {
                            daynote = 1;
                        }
                        if (dagensDatum.isEqual(LocalDate.parse(compare))) {
                            daynote = 0;
                        }
                }
            }
            }
            if (nodatefound == 1) {
                dayString = "///" + dagensDatum.toString() + "///";
            }
        } catch (FileNotFoundException e) {
            System.out.println("Man kan inte läsa filen!");
        }
        while (exit) {
            String check = JOptionPane.showInputDialog("Skriv in ett personnummer eller namn");
            if (check == null || check.equals("")) {
                exit = false;
                break;
            }
            try (BufferedReader br = Files.newBufferedReader(customers);
                    PrintWriter pw = new PrintWriter(new FileWriter(loggString, true))) {
                String firstLine;
                String secondLine;
                boolean found = false;
                while ((firstLine = br.readLine().trim()) != null && (secondLine = br.readLine()) != null) {
                    String[] box = firstLine.split(", ");
                    if (box[0].equalsIgnoreCase(check.trim()) || box[1].equalsIgnoreCase(check.trim())) {
                        LocalDate kravDatum = LocalDate.now().minusYears(1);
                        if (kravDatum.isBefore(LocalDate.parse(secondLine))) {
                            pane = new JOptionPane("Personen är kund!", JOptionPane.INFORMATION_MESSAGE);
                            showMessage();
                            if (daynote == 1 || nodatefound==1) {
                                pw.println(dayString);
                                daynote = 0;
                                nodatefound = 0;
                            }
                            pw.println(firstLine);
                            pw.println(secondLine);
                            found = true;
                        } else {
                            pane = new JOptionPane("Personen har varit kund!", JOptionPane.INFORMATION_MESSAGE);
                            showMessage();
                            found = true;
                        }
                    }
                }
                if (!found) {
                    pane = new JOptionPane("Personen är inte kund!", JOptionPane.INFORMATION_MESSAGE);
                    showMessage();
                }

            } catch (Exception e) {
                System.out.println("Man kan inte läsa filen!");
            }
        }
    }

    public static void main(String[] args) throws IOException {
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
                    start.checkMemberProgram();
                    break;
            }
        }
        System.exit(0);
    }
}
