package examples.outsidein;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class ConfirmationRepository {

    private SimpleJdbcTemplate simpleJdbcTemplate;

    public void setSimpleJdbcTemplate(SimpleJdbcTemplate simpleJdbcTemplate) {
        this.simpleJdbcTemplate = simpleJdbcTemplate;
    }

    public void add(Confirmation confirmation) {
        simpleJdbcTemplate.update("INSERT INTO CONFIRMATIONS VALUES (?, ?, ?)", confirmation.getFirstName(),
                confirmation.getLastName(), confirmation.getEmail());
    }
}
