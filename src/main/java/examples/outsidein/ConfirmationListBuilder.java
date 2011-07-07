package examples.outsidein;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ConfirmationListBuilder {

    public List<Confirmation> buildFrom(String csvInput) throws IOException {
        List<String> lines = retrieveContentLinesFrom(csvInput);
        List<Confirmation> result = createConfirmationsFromLines(lines);
        return result;
    }

    private List<String> retrieveContentLinesFrom(String csvInput) throws IOException {
        List<String> lines = retrieveAllLinesFrom(csvInput);
        removeHeader(lines);
        return lines;
    }

    private void removeHeader(List<String> allLines) {
        allLines.remove(0);
    }

    private List<String> retrieveAllLinesFrom(String csvInput) throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader(csvInput));
        List<String> lines = new ArrayList<String>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }

    private List<Confirmation> createConfirmationsFromLines(List<String> lines) {
        List<Confirmation> result = new ArrayList<Confirmation>();
        for (String line : lines) {
            Confirmation confirmation = createConfirmationFromLine(line);
            result.add(confirmation);
        }
        return result;
    }

    private Confirmation createConfirmationFromLine(String line) {
        StringTokenizer fields = new StringTokenizer(line, ";");
        return new Confirmation(fields.nextToken(), fields.nextToken(), fields.nextToken(), fields.nextToken(), fields.nextToken());
    }

}
