package edu.umd.cs.continents;

/**
 * Created by vibha on 3/23/16.
 */
public class ContinentName {



    private int id;
    private String name;

    public ContinentName(int id, String name) {
            this.id = id;
            this.name = name;
    }

    public String toString() {
            return name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
}
