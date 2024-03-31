import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Seelye Hall", "1 Seelye Dr Northampton, MA 01063", 5));
        myMap.addBuilding(new House("Albright", "7 Bedford Terrace Northampton, MA 01063", 4));
        myMap.addBuilding(new House("Tyler", "58 College Ln Northampton, MA 01063", 4, true, false));
        myMap.addBuilding(new House("Haven", "100 Elm St Northampton, MA 01063", 3));
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Dr Northampton, MA 01063", 5, "books"));
        myMap.addBuilding(new Cafe("Campus Center Cafe", "100 Elm St Northampton, MA 01063"));
        myMap.addBuilding(new Building("McConnell Hall", "50 College Ln Northampton, MA 01063", 4));
        myMap.addBuilding(new House("Cushing", "186 Elm St Northampton, MA 01063", 4, true, true));
        myMap.addBuilding(new Building("John M. Greene Hall", "60 Elm St Northampton, MA 01063", 3));
        myMap.addBuilding(new Library("Hillyer Library", "20 Elm St Northampton, MA 01063", 3, "books"));
        System.out.println(myMap);
    }
    
}
