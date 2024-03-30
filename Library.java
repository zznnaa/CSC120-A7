import java.util.Hashtable;

public class Library extends Building {

    private Hashtable < String, Boolean > collection;

    public Library(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.collection = new Hashtable < String, Boolean > ();
    }

    //whether title contained in collection
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
        if (collection.containsKey(title) == true) {
            boolean avaliability = collection.get(title);
            return avaliability;
            //throws exception otherwise
        } else {
            throw new RuntimeException("This title is not contained in the library.");
        }
    }

    /**
     * Adds book to the library.
     *
     * @param title Title of the book.
     * @throws RuntimeException This book is already contained in the collection.
     */
    public void addTitle(String title) {
        if (containsTitle(title) == false) {
            collection.put(title, true);
        } else {
            throw new RuntimeException("This title is already in the collection.");
        }
    }

    /**
     * Removes book from the library.
     *
     * @param title Title of the book.
     * @return Title of the book.
     * @throws RuntimeException Book is not contained in the collection.
     */
    public String removeTitle(String title) {
        if (containsTitle(title) == true) {
            collection.remove(title);
        } else {
            throw new RuntimeException("This title is not in the collection.");
        }
        return title;
    }

    /**
     * Checks out book from the library.
     *
     * @param title Title of the book.
     */
    public void checkOut(String title) {
        try {
            //check if title avaliable in library
            if (this.isAvaliable(title) == true) {
                //change value of title in collection
                collection.put(title, false);
            } else {
                System.out.println("Another patron has already checked out this book.");
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
        try {
            //check if title avaliable in library
            if (this.isAvaliable(title) == false) {
                //changes value of title in collection
                collection.put(title, true);
            } else {
                System.out.println("This book hasn't been checked out.");
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
            System.out.println("This collection does not currently contain any books.");
        } else {
            //iterates through each value in hashtable and prints (although can do any action)
            this.collection.forEach((key, value)
              -> System.out.println("\t Title: " + key + "\t Avaliabile: " + value));
        }
    }

    public static void main(String[] args) {
        Library library = new Library("San Mateo Public Library", "downtown", 4);
        System.out.println(library);
        try {
            library.addTitle("The Little Engine That Could");
        } catch (RuntimeException e) {
            System.out.println(e);
        }
        library.returnBook("The Little Engine That Could");
        library.checkOut("The Little Engine That Could");
        library.printCollection();
        try {
            library.removeTitle("The Little Engine That Could");
        } catch (RuntimeException e) {
            System.out.println(e);
        }
        library.returnBook("The Little Engine That Could");
        library.printCollection();

    }

}