package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Journal implements Serializable {
    private String name;
    private ArrayList<String> disciplines;

    public Journal(String aJournalName) {
        this.name = aJournalName;

        this.disciplines = new ArrayList<String>();
    }

    public Journal(String aJournalName, ArrayList<String> disciplines) {
        this.name = aJournalName;
        this.disciplines = disciplines;
    }

    public Journal setDiscipline(String aDiscipline) {
        //TODO: validation
        this.disciplines.add(aDiscipline);
        return this;
    }
}
