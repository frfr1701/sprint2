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

    private final Path logg = Paths.get("src\\sprint2\\logg.txt"); //Här skapar jag privat Path och variabler för inkapsling av variablerna så att de inte sprids.
    private final String Message;
    private String pnr;
    private String namn;

    public Person(String pnr, String namn, String Message) { //Konstruktorn VaritKund och Kund kommer till
        this.pnr = pnr;
        this.namn = namn;
        this.Message = Message;
    }

    public Person(String Message) { //Konstruktorn InteKund kommer till
        this.Message = Message;
    }

    @Override //Här är en av mina interface metoder
    public void findDatumUsePrintToFile() {
        try (BufferedReader br = Files.newBufferedReader(logg)) { //Skapar upp en reader till min logg
            String compare;
            boolean nodatefound = true; //Skapar och säter boolean nodatefound till true för att inget datum i loggen har blivit hittat än.
            while ((compare = br.readLine()) != null) { //Här loopar jag så länge raden som läses inte är null
                LocalDate dagensDatum = LocalDate.now(); //skapar fram dagens datum
                compare = compare.trim(); //trimmar compare
                if (!compare.equalsIgnoreCase("")) { //Om raden inte är tom
                    if (compare.charAt(0) == '/' || compare.charAt(1) == '/' || compare.charAt(2) == '/') { //Ifall raden innehåller datumloggens tre första "///" kommer den in här
                        compare = compare.replace("/", " "); //tar bort "///" på båda sidorna dock
                        compare = compare.trim(); //trimmar datumet
                        if (dagensDatum.isEqual(LocalDate.parse(compare))) { // om datumet i loggen så blir nodatefound false eftersom då har samma datum hittats som dagens datum.
                            nodatefound = false;
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

    private void printToFile(boolean nodatefound) {
        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(logg, CREATE, APPEND))) { //Här skapar jag en writer
            if (nodatefound) { //Här kollar jag ifall datumet inte blev hittat, om det inte blev hittat skriver jag ut dagens datum i loggen
                pw.println("///" + LocalDate.now().toString() + "///");
            }
            pw.println(pnr + ", " + namn); //Här skriver jag ut namnet på personen som blev incheckad

        } catch (IOException e) {
            System.out.println("Writern fungerar inte!");
        }
    }

    @Override
    public boolean compareName(String input) {
        return input.equalsIgnoreCase(namn); //Här jämför jag input med namnen;
    }

    @Override
    public boolean comparePnr(String input) {
        return input.equalsIgnoreCase(pnr); //Här jämför jag input med personnumrena;
    }

    @Override
    public void showMessage() {
        try { //Här gör jag en try och visar upp ett meddelande om vad personen är för typ av kund i ett 2 sekunder långt meddelande som avslutas efteråt.
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
