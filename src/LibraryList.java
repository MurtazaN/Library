import java.util.Collections;
import java.util.LinkedList;

public class LibraryList {
    static private LinkedList<Book>libraryList;
    private BorrowedList bList;

    public LibraryList() {
        libraryList = new LinkedList<Book>();
        bList = new BorrowedList(this);
    }

    /**
     Adds a Book to the Library
     @param b - the book to be added
     */
    public void addBook(Book b) {
        libraryList.add(b);
    }

    /**
     *
     * @param isbn
     */
    public void loanBook(int isbn)
    {
        for(int i = 0; i < libraryList.size() ;i++)
        {
            if(isbn == libraryList.get(i).getIsbn())
            {
                bList.addBook(libraryList.get(i));
                libraryList.remove(i);
                System.out.println("Request has been processed. Collect");
            }
        }
    }

    /**
     Finds a student in the course roster
     @param isbn - the isbn of book being searched
     */
    public boolean findBook(int isbn)
    {
        boolean value = false;
        for(int i = 0; i < libraryList.size();i++)
        {
            if(libraryList.get(i).getIsbn() == isbn)
            {
                value= true;
                break;
            }
            else
                value= false;
        }
        return value;
    }

    /**
     Prints all Books in Library
     */
    public void printBook() {
        //Collections.sort(roster);
        System.out.println("==================================");
        System.out.println("All Books in Library are: ");
        System.out.println("==================================");
        for(int i = 0; i < libraryList.size();i++)
        {
            System.out.println(libraryList.get(i));
        }
    }
}
