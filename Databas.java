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
    private Path customers = Paths.get("src\\sprint2\\customers.txt");
    
    public List<Person> getAllPersons() throws IOException{
       List<Person> ListCustomers = new ArrayList<>();
        LocalDate kravDatum = LocalDate.now().minusYears(1);
        String firstLine;
        String secondLine;
        try (BufferedReader br = Files.newBufferedReader(customers)){
            while ((firstLine=br.readLine().trim())!= null && (secondLine=br.readLine().trim())!= null){
                String[] box = firstLine.split(", ");
                if (kravDatum.isBefore(LocalDate.parse(secondLine))) {
                    ListCustomers.add(new Kund(box[0],box[1],"Personen är kund!"));
                 }else {
                    ListCustomers.add(new VaritKund(box[0],box[1],"Personen har varit kund!"));
                 }
            }
        }catch(FileNotFoundException e){
            System.out.println("Man kunde inte läsa filen!");
        }catch(NullPointerException e){
            
        }
        return ListCustomers;
    }
}
