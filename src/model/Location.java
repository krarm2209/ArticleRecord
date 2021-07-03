package model;

public class Location {
    private String region;
    private String country;
    private String state;
    private String city;
    private String other;

    public Location(String aRegion) {
        //TODO: validation
        this.region = aRegion;
        this.country = null;
        this.state = null;
        this.city = null;
        this.other = null;
    }

    public Location(String aRegion, String aCountry, String aState, String aCity, String aOther) {
        this.region = aRegion;
        this.country = aCountry;
        this.state = aState;
        this.city = aCity;
        this.other = aOther;
    }

    public Location setCountry(String aCountry) {
        //TODO: validation
        this.country = aCountry;
        return this;
    }

    public Location setState(String aState) {
        //TODO: validation
        this.state = aState;
        return this;
    }

    public Location setCity(String aCity) {
        //TODO: validation
        this.city = aCity;
        return this;
    }

    public Location setOther(String aOther) {
        //TODO: validation
        this.other = aOther;
        return this;
    }
}
