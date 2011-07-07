package examples.outsidein;

public class CompanyResolver {

    public String companyFor(Confirmation confirmation) {
        return confirmation.getOrigin().toLowerCase();
    }

}
