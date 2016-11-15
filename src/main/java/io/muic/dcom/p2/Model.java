package io.muic.dcom.p2;


import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.ArrayList;
import java.util.HashMap;

public class Model {

    private HashMap<String, Object> Parse = new HashMap<>();
    private HashMap<String, Object> station = new HashMap<>();
    private ArrayList<String > trail = new ArrayList<>();



    public Model(HashMap<String, Object> parse, HashMap<String, Object> station){

    }

    public Model(){}

    public ArrayList<String> getTrail() {
        return trail;
    }

    public HashMap<String, Object> getParse() {
        return Parse;
    }

    public HashMap<String, Object> getStation() {
        return station;
    }


}
