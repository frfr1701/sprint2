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
        TestCase.assertTrue(test.getIfKund() == 2);
        TestCase.assertFalse(test.getIfKund() == 1);
        TestCase.assertFalse(test.getIfKund() == 0);

        TestCase.assertTrue(test2.getIfKund() == 1);
        TestCase.assertFalse(test2.getIfKund() == 2);
        TestCase.assertFalse(test2.getIfKund() == 0);

        TestCase.assertTrue(test3.getIfKund() == 0);
        TestCase.assertFalse(test3.getIfKund() == 2);
        TestCase.assertFalse(test3.getIfKund() == 1);
    }

    public final void CompareTest() {
        TestCase.assertTrue(test.compare("Fredrik Frölund"));
        TestCase.assertTrue(test.compare("9702201030"));
        TestCase.assertFalse(test.compare("asdasd"));

        TestCase.assertTrue(test2.compare("Fredrik Frölund"));
        TestCase.assertTrue(test2.compare("9702201030"));
        TestCase.assertFalse(test2.compare("asdasd"));

        TestCase.assertFalse(test3.compare("Fredrik Frölund"));
        TestCase.assertFalse(test3.compare("9702201030"));

    }
}
