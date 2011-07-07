package spec;

import org.apache.commons.io.FileUtils;
import org.concordion.api.ResultSummary;
import org.concordion.internal.ConcordionBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.jvnet.mock_javamail.Mailbox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.jdbc.SimpleJdbcTestUtils;

import javax.mail.Message;
import javax.mail.internet.AddressException;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SystemTest {

    @Autowired
    private Properties configuration;

    @Autowired
    private DataSource dataSource;

    public SystemOutput createFileAndWait(String content, int millis) throws IOException, AddressException {
        writeFileWith(content.trim());
        waitFor(millis);
        return new SystemOutput(rowsInDatabase(), messagesInInbox());
    }

    private void writeFileWith(String content) throws IOException {
        FileUtils.writeStringToFile(new File(configuration.getProperty("input.directory"), "confirmations.csv"), content);
    }

    private void waitFor(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
            ;
        }
    }

    private int rowsInDatabase() {
        SimpleJdbcTemplate template = new SimpleJdbcTemplate(dataSource);
        return SimpleJdbcTestUtils.countRowsInTable(template, "CONFIRMATIONS");
    }

    private int messagesInInbox() throws AddressException {
        List<Message> inbox = Mailbox.get(configuration.getProperty("output.email_address"));
        return inbox.size();
    }

    private class SystemOutput {

        public int databaseEntries;
        public int messages;

        public SystemOutput(int databaseEntries, int messages) {
            this.databaseEntries = databaseEntries;
            this.messages = messages;
        }
    }

    @Test
    public void run() throws Exception {
        ResultSummary resultSummary = new ConcordionBuilder().build().process(this);
        resultSummary.print(System.out, this);
        resultSummary.assertIsSatisfied(this);
    }

}
