package portefolio.portefolioconsole.BO;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Experience {

    private String year;
    private String role;
    private String company;
    private ArrayList<String> description;


    public Experience(){}

    public Experience(String year, String role, String company, ArrayList<String> description) {
        this.year = year;
        this.role = role;
        this.company = company;
        this.description = description;
    }

    public String getYear() {
        return year;
    }

    public String getRole() {
        return role;
    }

    public String getCompany() {
        return company;
    }

    public ArrayList<String> getDescription() {
        return description;
    }
}

