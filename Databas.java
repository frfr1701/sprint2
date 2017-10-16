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

    List<Person> getAllPersons(){
        List<Person> ListCustomers = new ArrayList<>();
        LocalDate kravDatum = LocalDate.now().minusYears(1);
        String firstLine;
        String secondLine;
        try (BufferedReader br = Files.newBufferedReader(customers)) {
            while ((firstLine = br.readLine()) != null && (secondLine = br.readLine()) != null) {
                firstLine = firstLine.trim();
                secondLine = secondLine.trim();
                String[] box = firstLine.split(", ");
                if (kravDatum.isBefore(LocalDate.parse(secondLine))) {
                    ListCustomers.add(new Kund(box[0], box[1]));
                } else {
                    ListCustomers.add(new VaritKund(box[0], box[1]));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Man kunde inte läsa filen!");
        } catch (IOException e){
            System.out.println("Strömmen fungerar inte!");          
        }
        return ListCustomers;
    }
}
