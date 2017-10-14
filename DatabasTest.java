package sprint2Test;

import java.io.IOException;
import java.util.List;
import sprint2.*;
import junit.framework.TestCase;
import org.junit.Test;

public class DatabasTest {

    Databas databastest = new Databas();

    @Test
    public final void getAllPersonsTest() throws IOException {
        List<Person> ListCustomers = databastest.getAllPersons();
        ListCustomers.forEach((ListCustomer) -> {
            if (ListCustomer.getIfKund().equalsIgnoreCase("Personen har varit kund!") || ListCustomer.getIfKund().equalsIgnoreCase("Personen är kund!")) {
                TestCase.assertTrue(true);
            } else {
                TestCase.assertTrue(false);
            }
        });
    }

}
