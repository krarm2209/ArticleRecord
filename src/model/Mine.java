package model;

import java.util.ArrayList;

public class Mine {
    private String commodity;
    private ArrayList<String> methods;

    public Mine(String aCommodity) {
        this.commodity = aCommodity;

        this.methods = new ArrayList<String>();
    }

    public Mine(String aCommodity, ArrayList<String> methods) {
        this.commodity = aCommodity;
        this.methods = methods;
    }

    public Mine setMiningMethod(String aMethod) {
        //TODO: validation
        this.methods.add(aMethod);
        return this;
    }
}
