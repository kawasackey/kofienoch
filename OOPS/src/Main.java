import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract Class: LibraryItem (Abstraction)
abstract class LibraryItem {
    protected String title;
    protected String author;

    public LibraryItem(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Abstract method: Must be implemented by subclasses
    public abstract void displayItemDetails();
}

// Subclass: Book (Inheritance)
class Book extends LibraryItem {
    private final int numberOfPages;

    public Book(String title, String author, int numberOfPages) {
        super(title, author);
        this.numberOfPages = numberOfPages;
    }

    @Override
    public void displayItemDetails() {
        System.out.println("Book: " + title + " by " + author + ", Pages: " + numberOfPages);
    }
}

// Subclass: Magazine (Inheritance)
class Magazine extends LibraryItem {
    private final int issueNumber;

    public Magazine(String title, String author, int issueNumber) {
        super(title, author);
        this.issueNumber = issueNumber;
    }

    @Override
    public void displayItemDetails() {
        System.out.println("Magazine: " + title + " by " + author + ", Issue Number: " + issueNumber);
    }
}

// Library Class: Demonstrates Polymorphism
class Library {
    private final List<LibraryItem> items = new ArrayList<>();

    // Add library item (Polymorphism)
    public void addItem(LibraryItem item) {
        items.add(item);
    }

    // Display details of all items (Polymorphism)
    public void displayItems() {
        for (LibraryItem item : items) {
            item.displayItemDetails();  // Polymorphism: Calls the appropriate subclass method
        }
    }
}

// Main Class to test the Library System with user input
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of items to add to the library:");
        int itemCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < itemCount; i++) {
            System.out.println("Do you want to add a Book or a Magazine? (Enter 'Book' or 'Magazine')");
            String itemType = scanner.nextLine();

            System.out.println("Enter title:");
            String title = scanner.nextLine();

            System.out.println("Enter author:");
            String author = scanner.nextLine();

            if (itemType.equalsIgnoreCase("Book")) {
                System.out.println("Enter number of pages:");
                int numberOfPages = scanner.nextInt();
                scanner.nextLine(); // Consume newline after int

                // Create a Book and add to library
                Book book = new Book(title, author, numberOfPages);
                library.addItem(book);

            } else if (itemType.equalsIgnoreCase("Magazine")) {
                System.out.println("Enter issue number:");
                int issueNumber = scanner.nextInt();
                scanner.nextLine(); // Consume newline after int

                // Create a Magazine and add to library
                Magazine magazine = new Magazine(title, author, issueNumber);
                library.addItem(magazine);
            }
        }

        // Display all items in the library
        System.out.println("\nItems in the Library:");
        library.displayItems();

        scanner.close();  // Close the scanner resource
    }
}