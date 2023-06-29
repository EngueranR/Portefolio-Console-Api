package portefolio.portefolioconsole.BO;

import java.util.ArrayList;

public class Skill {

    private String language;
    private ArrayList<String> skillsDescription;
    private ArrayList<String> frameworks;

    public Skill(){}

    public Skill(String language, ArrayList<String> skillsDescription, ArrayList<String> frameworks) {
        this.language = language;
        this.skillsDescription = skillsDescription;
        this.frameworks = frameworks;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public ArrayList<String> getSkillsDescription() {
        return skillsDescription;
    }

    public void setSkillsDescription(ArrayList<String> skillsDescription) {
        this.skillsDescription = skillsDescription;
    }

    public ArrayList<String> getFrameworks() {
        return frameworks;
    }

    public void setFrameworks(ArrayList<String> frameworks) {
        this.frameworks = frameworks;
    }
}

