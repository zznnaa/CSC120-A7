import java.util.ArrayList;

public class House extends Building {

    private ArrayList <String> residents;
    private boolean hasDiningRoom;
    private boolean hasElevator;

    /* Default constructor */
    public House(String name, String address, int nFloors, boolean diningRoom, boolean elevator) {
        //super begins to construct House from parent class
        super(name, address, nFloors);
        this.residents = new ArrayList <String> ();
        this.hasDiningRoom = diningRoom;
        this.hasElevator = elevator;
    }

    /* Overloaded constructor with no dining room or elevator */
    public House(String name, String address, int nFloors) {
        //super begins to construct House from parent class
        super(name, address, nFloors);
        this.residents = new ArrayList <String> ();
        this.hasDiningRoom = false;
        this.hasElevator = false;
    }

    //says whether the house has a dining room
    public boolean hasDiningRoom() {
        if (this.hasDiningRoom == true) {
            return true;
        } else {
            return false;
        }
    }

    //says whether the house has an elevator
    public boolean hasElevator() {
        if (this.hasElevator == true) {
            return true;
        } else {
            return false;
        }
    }

    //says number of residents
    public int nResidents() {
        return this.residents.size();
    }

    //says whether resident is in house
    public boolean isResident(String person) {
        return this.residents.contains(person);
    }

    /**
     * Moves a resident into the house.
     *
     * @param name The name of the resident.
     * @throws RuntimeException Resident already belongs to the house.
     */
    public void moveIn(String name) {
        System.out.print("Moving resident in...");
        if (isResident(name) == true) {
          throw new RuntimeException("This person is already a resident.");
        }
        this.residents.add(name);
        System.out.println("Success!");
    }

    /**
     * Moves a resident with accomodations into the house.
     *
     * @param name The name of the resident.
     * @param accomodations Whether the resident has accomodations / needs an elevator.
     * @throws RuntimeException Resident already belongs to the house.
     */
    public void moveIn(String name, boolean accomodations){
        System.out.print("Moving resident (with accomodations) in...");
        if (isResident(name) == true) {
            throw new RuntimeException("This person is already a resident.");
        }
        if (accomodations == true && this.hasElevator == false) {
            throw new RuntimeException("This person cannot move into a House without an elevator.");
        }
        this.residents.add(name);
        System.out.println("Success!");
    }

    /**
     * Moves a resident out of the house.
     *
     * @param name The name of the resident.
     * @throws RuntimeException Resident is not part of the house.
     */
    public String moveOut(String name) {
        System.out.print("Moving resident out...");
        if (isResident(name) == false) {
            throw new RuntimeException("This person is not a resident.");
        }
        this.residents.remove(name);
        System.out.println("Success!");
        return name;
    }

    //conditions for using elevator
    public void goToFloor(int floorNum) {
        if (floorNum != this.activeFloor+1 && floorNum != this.activeFloor-1 && this.hasElevator == false){
            throw new RuntimeException("This building does not have an elevator. You cannot go up / down the stairs more than one floor at a time.");
        }
        super.goToFloor(floorNum);
    }

    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + moveIn(n) \n + moveOut(n) \n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) \n");
    }

    public static void main(String[] args) {
        House house = new House("home", "624", 5);
        System.out.println(house);
        try {
            house.moveIn("Zoe", true);
        } catch (RuntimeException e) {
            System.out.println(e);
        }
        System.out.println(house.nResidents());
        try {
            house.moveOut("Zoe");
        } catch (RuntimeException e) {
            System.out.println(e);
        }
        System.out.println(house.nResidents());
        house.showOptions();
        house.enter();
        house.goUp();
        house.goDown();
        house.goToFloor(5);
        
    }

}