package model;

import java.util.ArrayList;

//TODO: REVIEW METHODS
public class Article {
    private String author;
    private int pubYear;
    private String title;

    private ArrayList<String> topics;
    private ArrayList<String> pmlus;
    private ArrayList<String> research;
    private String dataType;

    private Journal pubJournal;
    private ArrayList<Mine> mines;
    private ArrayList<Location> locations;

    //Constructor
    public Article(String anAuthor, int aPubYear, String aTitle) {
        this.author = anAuthor;
        this.pubYear = aPubYear;
        this.title = aTitle;

        this.topics = new ArrayList<String>();
        this.pmlus = new ArrayList<String>();
        this.research = new ArrayList<String>();
        this.mines = new ArrayList<Mine>();
        this.locations = new ArrayList<Location>();
    }

    //Setters
    public Article setJournal(Journal aJournal) {
        this.pubJournal = aJournal;
        return this;
    }

    public Article setDataType(String aDataType) {
        //TODO: validation
        this.dataType = aDataType;
        return this;
    }

    public Article setResearchMethod(String aMethod) {
        //TODO: validation
        this.research.add(aMethod);
        return this;
    }

    public Article setResearchMethods(ArrayList<String> aMethodsList) {
        //TODO: validation (check for existing and append)
        this.research.addAll(aMethodsList);
        return this;
    }

    public Article setMine(Mine aMine) {
        //TODO: validation
        this.mines.add(aMine);
        return this;
    }

    public Article setLocation(Location aLocation) {
        //TODO: validation
        this.locations.add(aLocation);
        return this;
    }

    public Article setTopic(String aTopic) {
        //TODO: validation
        this.topics.add(aTopic);
        return this;
    }

    public Article setTopic(ArrayList<String> topicList) {
        this.topics.addAll(topicList);
        return this;
    }

    public Article setPMLU(String aPMLU) {
        //TODO: validation
        this.pmlus.add(aPMLU);
        return this;
    }

    public Article setPMLU(ArrayList<String> pmlus) {
        //TODO: validation
        this.pmlus.addAll(pmlus);
        return this;
    }

    //Getters
    public String getTitle() {
        return this.title;
    }

}
