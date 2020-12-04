/*Authot - Murtaza Nipplewala
  Date - 3rd December, 2020*/

import java.util.Collections;
import java.util.LinkedList;

public class BorrowedList {
    static private LinkedList<Book>borrowedList;
    private LibraryList lib;

    public BorrowedList(LibraryList lib) {
        borrowedList = new LinkedList<Book>();
        this.lib = lib;
    }

    /**
     Adds a Book to the Library
     @param b - the book to be added
     */
    public void addBook(Book b) {
        borrowedList.add(b);
    }

    public void returnBook(int isbn)
    {
        for(int i = 0; i < borrowedList.size() ;i++)
        {
            if(isbn == borrowedList.get(i).getIsbn())
            {
                lib.addBook(borrowedList.get(i));
                borrowedList.remove(i);
                System.out.println("Request has been processed. Deposit the book at front desk.");
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
        for(int i = 0; i < borrowedList.size();i++)
        {
            if(borrowedList.get(i).getIsbn() == isbn)
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
     Prints all Books Borrowed by Students
     */
    public void printBook() {
        if(!borrowedList.isEmpty())
        {
            Collections.sort(borrowedList);
            System.out.println("==================================");
            System.out.println("All Books Borrowed by Students are: ");
            System.out.println("==================================");
            for(int i = 0; i < borrowedList.size();i++)
            {
                System.out.println(borrowedList.get(i));
            }
        }
        else
            System.out.println("No Books have been loaned to the students.\n");
    }
}
