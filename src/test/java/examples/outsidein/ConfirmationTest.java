package examples.outsidein;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConfirmationTest {

    @Test
    public void confirmations_equality_depends_on_all_fields() {
        Confirmation oneConfirmation = new Confirmation("Firstname", "Lastname", "Company", "Email", "Origin");
        Confirmation anotherConfirmation = new Confirmation("Firstname", "Lastname", "Company", "Email", "Origin");
        assertEquals(oneConfirmation, anotherConfirmation);
    }

    @Test
    public void equal_confirmations_have_same_hashcode() {
        Confirmation oneConfirmation = new Confirmation("Firstname", "Lastname", "Company", "Email", "Origin");
        Confirmation anotherConfirmation = new Confirmation("Firstname", "Lastname", "Company", "Email", "Origin");
        assertEquals(oneConfirmation.hashCode(), anotherConfirmation.hashCode());
    }


}
