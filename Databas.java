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

    private final Path customers = Paths.get("src\\sprint2\\customers.txt");

    List<IPerson> getAllPersons() {
        List<IPerson> ListCustomers = new ArrayList<>();
        String firstLine;
        String secondLine;
        try (BufferedReader br = Files.newBufferedReader(customers)) {
            while ((firstLine = br.readLine()) != null && (secondLine = br.readLine()) != null) {
                firstLine = firstLine.trim();
                secondLine = secondLine.trim();
                String[] box = firstLine.split(", ");
                Person p = makePerson(box, LocalDate.parse(secondLine));
                if (p == null) {
                    System.out.println(box[1] + " gick inte att skapa och blev ej tillagd i listan!");
                } else {
                    ListCustomers.add(p);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Kan inte hitta filen!");
        } catch (IOException e) {
            System.out.println("Readern fungerar inte!");
        }
        return ListCustomers;
    }

    public Person makePerson(String[] box, LocalDate datum) {
        LocalDate kravDatum = LocalDate.now().minusYears(1);
        Person person = null;
        if (LocalDate.now().isAfter(datum)) {

            if (kravDatum.isBefore(datum)) {
                person = new Kund(box[0], box[1]);
            } else {
                person = new VaritKund(box[0], box[1]);
            }
        }
        return person;
    }
}
