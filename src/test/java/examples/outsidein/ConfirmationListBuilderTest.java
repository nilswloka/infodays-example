package examples.outsidein;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConfirmationListBuilderTest {

    @Test
    public void can_be_initialized() {
        ConfirmationListBuilder confirmationListBuilder = new ConfirmationListBuilder();
    }

    @Test
    public void creates_one_list_item_per_line() throws IOException {
        String input = "first_name;last_name;company;email;origin\n" +
                "Stefan;S.;OPITZ CONSULTING Gummersbach GmbH;stefan.s@example.nowhere;OC";
        ConfirmationListBuilder confirmationListBuilder = new ConfirmationListBuilder();
        List<Confirmation> result = confirmationListBuilder.buildFrom(input);
        assertEquals(1, result.size());
    }

    @Test
    public void works_with_lines_ending_with_cr_lf() throws IOException {
        String input = "first_name;last_name;company;email;origin\r\n" +
                "Stefan;S.;OPITZ CONSULTING Gummersbach GmbH;stefan.s@example.nowhere;OC\r\n";
        Confirmation expected = new Confirmation("Stefan", "S.", "OPITZ CONSULTING Gummersbach GmbH", "stefan.s@example.nowhere", "OC");
        ConfirmationListBuilder confirmationListBuilder = new ConfirmationListBuilder();
        List<Confirmation> result = confirmationListBuilder.buildFrom(input);
        assertEquals(expected, result.get(0));
    }

    @Test
    public void creates_confirmations_based_on_lines() throws IOException {
        String input = "first_name;last_name;company;email;origin\n" +
                "Stefan;S.;OPITZ CONSULTING Gummersbach GmbH;stefan.s@example.nowhere;OC";
        Confirmation expected = new Confirmation("Stefan", "S.", "OPITZ CONSULTING Gummersbach GmbH", "stefan.s@example.nowhere", "OC");
        ConfirmationListBuilder confirmationListBuilder = new ConfirmationListBuilder();
        List<Confirmation> result = confirmationListBuilder.buildFrom(input);
        assertEquals(expected, result.get(0));
    }

}
