/*Authot - Murtaza Nipplewala
  Date - 3rd December, 2020*/

public class Book implements Comparable<Book>{
    private int isbn;
    private String title;
    private String author;


    public Book(int isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }
    /**
     * @return the ISBN
     */
    public int getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the ISBN to set
     */
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int compareTo(Book b)
    {
        int compareVal = 0;
        if(isbn < b.getIsbn())
        {
            compareVal = -1;
        }
        else if (isbn > b.getIsbn())
        {
            compareVal = 1;
        }
        return compareVal;
    }
    /**
     * Generates a String representing the Book object
     * @return returns the String representing the Book
     */
    @Override
    public String toString() {
        String str = "";
        str += "ISBN: " + isbn + "\n";
        str += "Title: " + title + "\n";
        str += "Author: " + author + "\n";
        return str;
    }
}
