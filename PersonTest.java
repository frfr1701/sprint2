package sprint2Test;

import sprint2.*;
import junit.framework.TestCase;
import org.junit.Test;

public class PersonTest {

    Person test = new Kund("9702201030", "Fredrik Frölund");
    Person test2 = new VaritKund("9702201030", "Fredrik Frölund");
    Person test3 = new InteKund();

    @Test

    public final void compareNamnTest() {
        TestCase.assertTrue(test.compareName("Fredrik Frölund"));
        TestCase.assertFalse(test.compareName("asdasd"));

        TestCase.assertTrue(test2.compareName("Fredrik Frölund"));
        TestCase.assertFalse(test2.compareName("asd"));

        TestCase.assertFalse(test3.compareName("Fredrik Frölund"));
    }

    public final void comparePnrTest() {
        TestCase.assertTrue(test.comparePnr("9702201030"));
        TestCase.assertFalse(test.comparePnr("asdasd"));

        TestCase.assertTrue(test2.comparePnr("9702201030"));
        TestCase.assertFalse(test2.comparePnr("asd"));

        TestCase.assertFalse(test3.comparePnr("9702201030"));
    }
}
