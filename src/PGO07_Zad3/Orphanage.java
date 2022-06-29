package PGO07_Zad3;

import java.util.HashSet;
import java.util.Set;

class Orphanage {
    private String name;
    private Location location;
    private Set<Child> children;

    public Orphanage(String name, Location location) {
        this.name = name;
        this.location = location;

        this.children = new HashSet<>();
    }

    public void addChild(Child child){
        if (children.contains(child)) {
            System.out.println("This child has been added to the orphanage");
        } else {
            this.children.add(child);
        }
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
