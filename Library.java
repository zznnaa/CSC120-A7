import java.util.Hashtable;

public class Library extends Building {

    private Hashtable <String, Boolean> collection;
    private boolean hasElevator;
    private String mediaType;

    /* Default constructor */
    public Library(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.collection = new Hashtable <String, Boolean> ();
        this.hasElevator = true;
        this.mediaType = "books";
    }

    /* Overloaded constructor with customizable mediaType */
    public Library(String name, String address, int nFloors, String mediaType){
        super(name, address, nFloors);
        this.collection = new Hashtable <String, Boolean> ();
        this.hasElevator = true;
        this.mediaType = mediaType;
    }

    //conditions for using elevator
    public void goToFloor(int floorNum) {
        if (floorNum != this.activeFloor+1 && floorNum != this.activeFloor-1){
            System.out.println("You used the elevator!");
        }
        super.goToFloor(floorNum);
    }
    
    //says whether title contained in collection
    public boolean containsTitle(String title) {
        return collection.containsKey(title);
    }

    /**
     * Checks if title is avaliable to check out in the library.
     *
     * @param title Title of the book.
     * @return T/F Whether title is avaliable to check out.
     * @throws RuntimeException Book is not contained in the collection.
     */
    public boolean isAvaliable(String title) {
        //checks if title contained in library
        if (containsTitle(title) != true) {
            throw new RuntimeException("This title is not avaliable in the library.");
        }
        boolean avaliability = collection.get(title);
        return avaliability;
        }

    /**
     * Checks whether all titles are avaliable / unavaliable to check out in the library.
     *
     * @param avaliable T/F Whether books checked in or out.
     * @return T/F Whether titles are avaliable to check out.
     */
    public boolean isAvaliable(boolean avaliable) {
        //checks if title contained in library
        if (collection.containsKey(false) == false && avaliable == true) {
            System.out.println("All items are currently avaliable in the library");
        } if (collection.containsKey(true) == false && avaliable == false) {
            System.out.println("All items are checked out of the library.");
        }
        return avaliable;
    }

    /**
     * Adds book to the library.
     *
     * @param title Title of the book.
     * @throws RuntimeException This book is already contained in the collection.
     */
    public void addTitle(String title) {
        System.out.print("Adding \"" + title + "\" to the library...");
        if (containsTitle(title) == false) {
            collection.put(title, true);
        } else {
            throw new RuntimeException("This title is already in the collection.");
        }
        System.out.println("Success!");
    }

    /**
     * Removes book from the library.
     *
     * @param title Title of the book.
     * @return Title of the book.
     * @throws RuntimeException Book is not contained in the collection.
     */
    public String removeTitle(String title) {
        System.out.print("Removing \"" + title + "\" from the library...");
        if (containsTitle(title) == true) {
            collection.remove(title);
        } else {
            throw new RuntimeException("This title is not in the collection.");
        }
        System.out.println("Success!");
        return title;
    }

    /**
     * Checks out book from the library.
     *
     * @param title Title of the book.
     */
    public void checkOut(String title) {
        System.out.print("Checking out \"" + title + "\" from the library...");
        try {
            //check if title avaliable in library
            if (this.isAvaliable(title) == true) {
                //change value of title in collection
                collection.put(title, false);
                System.out.println("Success!");
            } else {
                System.out.println("Another patron has already checked out this item.");
            }
            //catches if book not in collection
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }

    /**
     * Returns out book from the library.
     *
     * @param title Title of the book.
     */
    public void returnBook(String title) {
        System.out.print("Returning \"" + title + "\" to the library...");
        try {
            //check if title avaliable in library
            if (this.isAvaliable(title) == false) {
                //changes value of title in collection
                collection.put(title, true);
                System.out.println("Success!");
            } else {
                System.out.println("This item hasn't been checked out.");
            }
            //catches exception if book not in collection
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }

    //prints contents of the collection
    public void printCollection() {
        System.out.println(this.name + " Collection:");
        //checks if any books in collection
        if (this.collection.size() == 0) {
            System.out.println("This collection does not currently contain any items.");
        } else {
            //iterates through each value in hashtable and prints (although can do any action)
            this.collection.forEach((key, value)
              -> System.out.println("\t Title: " + key + "\t Avaliable: " + value));
        }
    }

    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + containsTitle(t) \n + isAvaliable(t) \n + addTitle(t) \n + removeTitle(t) \n + checkOut(t) \n + returnBook(t) \n + printCollection() \n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    }

    public static void main(String[] args) {
        Library library = new Library("San Mateo Public Library", "downtown", 4, "video games");
        System.out.println(library);
        try {
            library.addTitle("Civilization IV");
        } catch (RuntimeException e) {
            System.out.println(e);
        }
        library.isAvaliable(true);
        library.returnBook("Civilization IV");
        library.checkOut("Civilization IV");
        library.printCollection();
        //System.out.println(library.isAvaliable("Civilization IV"));
        //System.out.println(library.containsTitle("Civilization IV"));
        try {
            library.removeTitle("Civilization IV");
        } catch (RuntimeException e) {
            System.out.println(e);
        }
        library.printCollection();

        library.showOptions();
        library.enter();
        library.goToFloor(4);
        library.goDown();


    }

}