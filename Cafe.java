public class Cafe extends Building {

    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    public Cafe(String name, String address) {
        super(name, address);
        this.nCoffeeOunces = 20;
        this.nSugarPackets = 10;
        this.nCreams = 10;
        this.nCups = 5;
    }

    /**
     * Sells a coffee from the cafe.
     *
     * @param size Size of ordered coffee.
     * @param nSugarPackets Number of sugar packets ordered in coffee.
     * @param nCreams Splashes of cream ordered in coffee.
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        //how much to restock by
        int restockCoffee = 0;
        int restockSugarPackets = 0;
        int restockCream = 0;
        int restockCups = 0;
        //sees if order will go below avaliable inventory
        if ((this.nCoffeeOunces - size) < 0) {
            System.out.println("There is not enough coffee to make that order.");
            //if so, adds to restock
            restockCoffee = 20;
        }
        if ((this.nSugarPackets - nSugarPackets) < 0) {
            System.out.println("There are not enough sugar packets to make that order.");
            restockSugarPackets = 3;
        }
        if ((this.nCreams - nCreams) < 0) {
            System.out.println("There are not enough splashes of cream to make that order.");
            restockCream = 3;
        }
        if ((this.nCups - nCups) < 0) {
            System.out.println("There are not enough cups to make this order.");
            restockCups = 5;
        }
        //if any restock variable is above 0, restocks cafe
        if ((restockCoffee != 0) || (restockSugarPackets != 0) || (restockCream != 0) || (restockCups != 0)) {
            restock(restockCoffee, restockSugarPackets, restockCream, restockCups);
        }
        //makes order
        System.out.print("Making coffee...");
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        System.out.println("Success!");
        System.out.println("Order up! " + size + "oz coffee with " + nSugarPackets + " sugar(s) and " + nCreams + " cream(s).");

    }

    /**
     * Restocks inventory in cafe.
     *
     * @param nCoffeeOunces Restocked ounces of coffee.
     * @param nSugarPackest Restocked number of sugar packets.
     * @param nCreams Restocked splashes of cream.
     * @param nCups Restocked number of cups.
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        System.out.print("Restocking...");
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("Success!");
    }

    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + restock \n + sellCoffee \n + enter() \n + exit()");
    }

    //will have to override gotofloor to actually disable functionality, throw runtime exception
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum >= 1) {
            throw new RuntimeException("You cannot leave the ground floor. The cafe's higher levels are reserved for staff.");
        }
    }

    //question: do we need to make restocking contingent on being inside the building?

    public static void main(String[] args) {
        Cafe cafe = new Cafe("Tatte", "Boston");
        System.out.println(cafe);
        for (int i = 1; i < 6; i++) {
            cafe.sellCoffee(12, 3, 2);
        }
        cafe.showOptions();
        cafe.enter();
        cafe.goUp();

    }

}
