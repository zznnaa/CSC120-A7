import java.util.ArrayList;

public class House extends Building {

    private ArrayList <String> residents;
    private boolean hasDiningRoom;
    private boolean hasElevator;

    public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
        //super begins to construct House from parent class
        super(name, address, nFloors);
        this.residents = new ArrayList <String> ();
        this.hasDiningRoom = hasDiningRoom;
        this.hasElevator = hasElevator;
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
        if (isResident(name) == false) {
            this.residents.add(name);
        } else {
            throw new RuntimeException("This person is already a resident.");
        }
    }

    /**
     * Moves a resident out of the house.
     *
     * @param name The name of the resident.
     * @throws RuntimeException Resident is not part of the house.
     */
    public String moveOut(String name) {
        if (isResident(name) == true) {
            this.residents.remove(name);
        } else {
            throw new RuntimeException("This person is not a resident.");
        }
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
        House house = new House("home", "624", 5, true, true);
        System.out.println(house);
        try {
            house.moveIn("Zoe");
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