package examples.outsidein;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConfirmationTextBuilderTest {

    @Test
    public void builds_text_based_on_confirmation() {
        ConfirmationTextBuilder confirmationTextBuilder = new ConfirmationTextBuilder();
        Confirmation confirmation = new Confirmation("Firstname", "Lastname", "Company", "Email", "Origin");
        String expected = confirmation.getFirstName() + " " + confirmation.getLastName() + " wird die Veranstaltung besuchen.";
        String actual = confirmationTextBuilder.textFor(confirmation);
        assertEquals(expected, actual);
    }

}
