package sprint2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Databas {

    private final Path customers = Paths.get("src\\sprint2\\customers.txt"); //Här skapar jag mitt path directory till min customers textfil.

    List<IPerson> getAllPersons() {
        List<IPerson> ListCustomers = new ArrayList<>(); //Här skapar jag en lista av interfacet till Person "IPerson" som gör att får acess utåt bara saker som är i interfacet och public.
        String firstLine;
        String secondLine;
        try (BufferedReader br = Files.newBufferedReader(customers)) { //Här skapar jag min reader i en try-catch
            while ((firstLine = br.readLine()) != null && (secondLine = br.readLine()) != null) { //Här kollar jag hela tiden ifall de två raderna inte innehåller null, då fortsätter whileloopen
                firstLine = firstLine.trim(); //trimmar båda vid eventuella space i customer filen
                secondLine = secondLine.trim();
                String[] pnrNamn = firstLine.split(", "); //splitar för att få fram personnummer och namn
                Person p = makePerson(pnrNamn, LocalDate.parse(secondLine));
                if (p == null) { //ifall personen inte var något av kraven, alltså registerad i framtiden. Då skriver programmet ut kundens namn med meddelandet att den inte blev tillagd i listan.
                    System.out.println(pnrNamn[1] + " gick inte att skapa och blev ej tillagd i listan!");
                } else {
                    ListCustomers.add(p); //Här lägger jag till personen i listan
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Kan inte hitta filen!");
        } catch (IOException e) {
            System.out.println("Readern fungerar inte!");
        }
        return ListCustomers;
    }

    public Person makePerson(String[] pnrNamn, LocalDate datum) {
        LocalDate kravDatum = LocalDate.now().minusYears(1);
        Person person = null;
        if (LocalDate.now().isAfter(datum) || LocalDate.now().isEqual(datum)) { //Om dagens datumet är efter efter eller i lika med datumet personen blev medlem, då blir man någon typ av medlem, annars blir man null och inget eftersom den framtida betalningen inte har skett.

            if (kravDatum.isBefore(datum)) { //Här kollar jag ifall personen är kund 
                person = new Kund(pnrNamn[0], pnrNamn[1]);
            } else { //Om den inte är kund då är personen en som har varit en kund
                person = new VaritKund(pnrNamn[0], pnrNamn[1]);
            }
        }
        return person; //Här retunerar jag personen och vad den blev
    }
}
