package model;


public class Book {
    private float ISBN;
    private Author author;
    private String title;
    private BookPublisher publisher;
    private int publication_year;
    private float price;
    private BookType bookType;

    public Book(float ISBN, Author author, String title, BookPublisher publisher, int publication_year, float price, BookType bookType) {
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.publication_year = publication_year;
        this.price = price;
        this.bookType = bookType;
    }

    public float getISBN() {
        return ISBN;
    }

    public void setISBN(float ISBN) {
        this.ISBN = ISBN;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BookPublisher getPublisher() {
        return publisher;
    }

    public void setPublisher(BookPublisher publisher) {
        this.publisher = publisher;
    }

    public int getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(int publication_year) {
        this.publication_year = publication_year;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }
}
