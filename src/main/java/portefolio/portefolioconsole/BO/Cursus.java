package portefolio.portefolioconsole.BO;

import java.util.ArrayList;

public class Cursus {
    private String year;
    private ArrayList<String> description;
    private String institution;

    public Cursus(){}
    public Cursus(String year, ArrayList<String> description, String institution) {
        this.year = year;
        this.description = description;
        this.institution = institution;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ArrayList<String> getDescription() {
        return description;
    }

    public void setDescription(ArrayList<String> description) {
        this.description = description;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }
}
