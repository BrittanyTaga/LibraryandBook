import java.util.ArrayList;
import java.util.List;



public class Library {
    // Add the missing implementation to this class

    private String address; //addresses
    private List<Book> books = new ArrayList<Book>(); //collection of books
    private String hours; //hours of operation: "Libraries are open daily from 9am to 5pm."

    //creating constructor
    public Library(String address){
        this.address = address;
        this.hours = "Libraries are open daily from 9am to 5pm.";
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public static void printOpeningHours() {
        System.out.println("Libraries are open daily from 9am  to 5pm.");
    }

    private void printAddress() {
        System.out.print(this.address);
    }

    private void borrowBook(String booktitle) {
        boolean foundBook = false;
        for(int i = 0; i < this.books.size(); i++){
            // if the book is in our books
            if(this.books.get(i).getTitle() == booktitle){
                foundBook = true;
                // if the book isn't borrowed
                if(this.books.get(i).isBorrowed() != true){
                    //message: you successfully, borrowed "book title".
                    System.out.println("You sucessfully, borrowed " + booktitle);
                    this.books.get(i).borrowed();
                
                }else{
                 // if the book is borrowed
                    //Sorry, this book is already borrowed
                    System.out.println("Sorry, this book is already borrowed");
                }
                break;
            }
        }
        // the book is not in our books
        if(foundBook == false){
            System.out.println("Sorry, this book is not in our catalog.");
        }
    }
    
    private void printAvailableBooks() {
        for(int i = 0; i < this.books.size(); i++){
            if(this.books.get(i).isBorrowed() != true){
            System.out.println(this.books.get(i).getTitle());
        }
        }
    }

    private void returnBook(String booktitle) {
        for(int i = 0; i < this.books.size(); i++){
            if(this.books.get(i).getTitle() == booktitle){
            this.books.get(i).returned();
            System.out.println("You successfuly returned " + booktitle);
            }
        } 
    }

    public static void main(String[] args) {



        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }

   

   
} 