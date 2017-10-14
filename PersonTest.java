package sprint2Test;

import sprint2.*;
import junit.framework.TestCase;
import org.junit.Test;

public class PersonTest {

    Person test = new Kund("9702201030", "Fredrik Frölund");
    Person test2 = new VaritKund("9702201030", "Fredrik Frölund");
    Person test3 = new InteKund();

    @Test
    public final void getIfKundTest() {
        TestCase.assertTrue(test.getIfKund().equalsIgnoreCase("Personen är kund!"));
        TestCase.assertTrue(test2.getIfKund().equalsIgnoreCase("Personen har varit kund!"));
        TestCase.assertTrue(test3.getIfKund().equalsIgnoreCase("Personen är inte kund!"));
    }

    public final void getNamnTest() {
        TestCase.assertTrue(test.getNamn().equalsIgnoreCase("Fredrik Frölund"));
        TestCase.assertTrue(test2.getNamn().equalsIgnoreCase("Fredrik Frölund"));
    }

    public final void getPnrTest() {
        TestCase.assertTrue(test.getPnr().equalsIgnoreCase("9702201030"));
        TestCase.assertTrue(test2.getPnr().equalsIgnoreCase("9702201030"));
    }
}
