/*Authot - Murtaza Nipplewala
  Date - 3rd December, 2020*/

import java.util.Scanner;

public class LibraryDriver {
    LibraryList library = new LibraryList();
    BorrowedList borrowed = new BorrowedList(library);
    Book b;

    /**
     Adds a new Book object based on user input.
     @param in - the Scanner to read from.
     */
    public void addBook(Scanner in)
    {
        System.out.println("Enter Books's ISBN: ");
        int isbn = Integer.parseInt(in.nextLine());
        System.out.println("Enter Book's Title: ");
        String title = in.nextLine();
        System.out.println("Enter Book's Author Name: ");
        String author = in.nextLine();
        b = new Book (isbn, title, author);
        library.addBook(b);
    }

    /**
     Method to find Book in Library or Borrowed by student.
     @param in - the Scanner to read from.
     */
    public void findBook(Scanner in)
    {
        System.out.println("Enter the Books ISBN to search: ");
        int isbn = in.nextInt();
        if(library.findBook(isbn) == true)
        {
            System.out.println("Book is available in Library");
        }
        else if(borrowed.findBook(isbn) == true)
        {
            System.out.println("Book is borrowed by a Student");
        }
        else
            System.out.println("Sorry, Book is not available");
    }

    /**
     * Method to rent book from library to student
     * @param in - the Scanner to read from.
     */
    public void borrowBook(Scanner in)
    {
        System.out.println("Enter the ISBN of Book you want to borrow: ");
        int isbn = in.nextInt();
        if(library.findBook(isbn) == true)
        {
            library.loanBook(isbn);
        }
    }

    /**
     * Method to collect book from student back in library
     * @param in - the Scanner to read from.
     */
    public void returnBorrowedBook(Scanner in)
    {
        System.out.println("Enter the ISBN of Book you want to return: ");
        int isbn = Integer.parseInt(in.nextLine());
        if(borrowed.findBook(isbn) == true)
        {
            borrowed.returnBook(isbn);
        }
    }

    /**
     Method to print Books in library and borrowed by students
     */
    public void printAllBooks()
    {
        library.printBook();
        borrowed.printBook();
    }

    /**
     Method to print the Menu for Library.
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        LibraryDriver driver = new LibraryDriver();

        System.out.println("Welcome to Murtaza's Library");
        System.out.println("--------------------------------");

        boolean done = false;
        while (!done)
        {
            System.out.print("Please select an action: (F)ind, (A)dd, (B)orrowed, (P)rint, (R)eturn or (Q)uit: ");
            String choice = in.next();
            if (choice.equals("F") || choice.equals("f"))
            {
                driver.findBook(new Scanner(System.in));
            }
            else if (choice.equals("A") || choice.equals("a"))
            {
                driver.addBook(new Scanner(System.in));
            }
            else if (choice.equals("B") || choice.equals("b"))
            {
                driver.borrowBook(new Scanner(System.in));
            }
            else if (choice.equals("R") || choice.equals("r"))
            {
                driver.returnBorrowedBook(new Scanner(System.in));
            }
            else if (choice.equals("P") || choice.equals("p"))
            {
                driver.printAllBooks();
            }
            done = choice.equals("Q") || choice.equals("q");
        }
        System.out.println("Good bye. Please visit us again");
        in.close();
    }
}
