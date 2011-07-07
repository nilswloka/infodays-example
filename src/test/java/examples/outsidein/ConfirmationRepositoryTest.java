package examples.outsidein;

import org.junit.Test;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ConfirmationRepositoryTest {

    @Test
    public void use_confirmation_properties_as_insert_values() {
        ConfirmationRepository confirmationRepository = new ConfirmationRepository();
        SimpleJdbcTemplate simpleJdbcTemplate = mock(SimpleJdbcTemplate.class);
        confirmationRepository.setSimpleJdbcTemplate(simpleJdbcTemplate);
        Confirmation confirmation = new Confirmation("Firstname", "Lastname", "Company", "Email", "Origin");
        confirmationRepository.add(confirmation);
        verify(simpleJdbcTemplate).update("INSERT INTO CONFIRMATIONS VALUES (?, ?, ?)",
                confirmation.getFirstName(), confirmation.getLastName(), confirmation.getEmail());
    }

}
