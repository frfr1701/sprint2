package sprint2Test;

import java.time.LocalDate;
import sprint2.*;
import junit.framework.TestCase;
import org.junit.Test;

public class DatabasTest {

    Databas databas = new Databas();

    @Test
    public final void makePersonTest() {

        LocalDate before = LocalDate.now().minusYears(2);
        LocalDate after = LocalDate.now().minusMonths(2);
        LocalDate future = LocalDate.now().plusYears(1);

        String[] namn = {"Fredrik", "Frölund"};
        TestCase.assertTrue(databas.makePerson(namn, after) instanceof Kund);
        TestCase.assertFalse(databas.makePerson(namn, before) instanceof Kund);
        TestCase.assertTrue(databas.makePerson(namn, before) instanceof VaritKund);
        TestCase.assertFalse(databas.makePerson(namn, after) instanceof VaritKund);
        TestCase.assertNull(databas.makePerson(namn, future));
    }
}
