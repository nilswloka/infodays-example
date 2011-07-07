package examples.outsidein;

public class ConfirmationTextBuilder {

    public String textFor(Confirmation confirmation) {
        return confirmation.getFirstName() + " " + confirmation.getLastName() + " wird die Veranstaltung besuchen.";
    }

}
