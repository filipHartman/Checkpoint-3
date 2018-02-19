package dao;

import model.Author;
import model.Book;
import model.BookPublisher;
import model.BookType;

public class DaoBook {
    public Book createBook(float ISBN, Author author, String title, BookPublisher publisher, int publicationYear, float price, BookType bookType) {
        return new Book(ISBN, author, title, publisher, publicationYear, price, bookType);
    }
}
