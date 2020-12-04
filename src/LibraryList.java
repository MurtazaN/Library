/*Authot - Murtaza Nipplewala
  Date - 3rd December, 2020*/

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
     * Method to loan book from library to student
     * @param isbn - isbn of book that is being loaned
     */
    public void loanBook(int isbn)
    {
        for(int i = 0; i < libraryList.size() ;i++)
        {
            if(isbn == libraryList.get(i).getIsbn())
            {
                bList.addBook(libraryList.get(i));
                libraryList.remove(i);
                System.out.println("Request has been processed. Collect the book from front desk.");
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
        if(!libraryList.isEmpty())
        {
            Collections.sort(libraryList);
            System.out.println("==================================");
            System.out.println("All Books in Library are: ");
            System.out.println("==================================");
            for (int i = 0; i < libraryList.size(); i++) {
                System.out.println(libraryList.get(i));
            }
        }
        else
            System.out.println("\nSorry, Library is currently empty.");
    }
}
