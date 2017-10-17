package sprint2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;

public abstract class Person implements IPerson {

    private final Path logg = Paths.get("src\\sprint2\\logg.txt");
    private final String Message;
    private String pnr;
    private String namn;

    public Person(String pnr, String namn, String Message) {
        this.pnr = pnr;
        this.namn = namn;
        this.Message = Message;
    }

    public Person(String Message) {
        this.Message = Message;
    }

    protected String getNamn() {
        return namn;
    }

    @Override
    public void findDatumUsePrintToFile() {
        try (BufferedReader br = Files.newBufferedReader(logg)) {
            String compare;
            int nodatefound = 1;
            while ((compare = br.readLine()) != null) {
                LocalDate dagensDatum = LocalDate.now();
                compare = compare.trim();
                if (!compare.equals("")) {
                    if (compare.charAt(0) == '/' || compare.charAt(1) == '/' || compare.charAt(2) == '/') {
                        nodatefound = 0;
                        compare = compare.replace("/", " ");
                        compare = compare.trim();
                        if (dagensDatum.isEqual(LocalDate.parse(compare))) {
                            nodatefound = 0;
                        }
                    }
                }

            }
            printToFile(nodatefound);
        } catch (FileNotFoundException e) {
            System.out.println("Kan inte hitta filen!");
        } catch (IOException e) {
            System.out.println("Readern fungerar inte!");
        }
    }

    public void printToFile(int nodatefound) {
        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(logg, CREATE, APPEND))) {
            if (nodatefound == 1) {
                pw.println("///" + LocalDate.now().toString() + "///");
            }
            pw.println(pnr + ", " + namn);

        } catch (IOException e) {
            System.out.println("Writern fungerar inte!");
        }
    }

    @Override
    public boolean compareName(String CheckPerson) {
        return CheckPerson.equalsIgnoreCase(namn);
    }

    @Override
    public boolean comparePnr(String CheckPerson) {
        return CheckPerson.equalsIgnoreCase(pnr);
    }

    @Override
    public void showMessage() {
        try {
            JOptionPane pane = new JOptionPane(Message, INFORMATION_MESSAGE);
            JDialog all = pane.createDialog(null, "Gym");
            all.setModal(false);
            all.setVisible(true);
            TimeUnit.SECONDS.sleep(2);
            all.setVisible(false);
        } catch (InterruptedException e) {
            System.out.println("Tidsfördröjningen fick ett problem!");
        }
    }
}
