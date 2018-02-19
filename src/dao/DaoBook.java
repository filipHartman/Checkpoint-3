package dao;

import model.Author;
import model.Book;
import model.BookPublisher;
import model.BookType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoBook {
    public Book createBook(String ISBN, Author author, String title, BookPublisher publisher, int publicationYear, float price, BookType bookType) {
        return new Book(ISBN, author, title, publisher, publicationYear, price, bookType);
    }

    public Book importBook(String ISBN) {
        Book book = null;
        PreparedStatement ps = null;
        String query = "SELECT * FROM Books WHERE ISBN = ?";
        try{
            ps = DBConnection.getConnection().prepareStatement(query);
            ps.setString(1, ISBN);
            ResultSet rs = ps.executeQuery();
            if (!rs.isClosed()) {
                book = createBookFromDBData(rs);
            }
            rs.close();
            ps.close();

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        return book;
    }

    public ArrayList<Book> importAllBooks() {
        ArrayList<Book> books = new ArrayList<>();
        PreparedStatement ps = null;
        String query = "SELECT * FROM Books ORDER BY title ASC";
        try{
            ps = DBConnection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book book = createBookFromDBData(rs);
                books.add(book);

            }
            rs.close();
            ps.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return books;
    }

    private Book createBookFromDBData(ResultSet rs) throws SQLException{
        String ISBN = rs.getString("ISBN");
        int authorId = rs.getInt("author");
        Author author = getAuthorOfBook(authorId);
        String title = rs.getString("title");
        String publisherId = rs.getString("publisher");
        BookPublisher publisher = getPublisherOfBook(publisherId);
        int publicationYear = rs.getInt("publication_year");
        float price = rs.getFloat("price");
        int typeId = rs.getInt("type");
        BookType type = getTypeOfBook(typeId);

        Book book = createBook(
                ISBN, author, title, publisher, publicationYear, price, type);
        return book;
    }
    private Author getAuthorOfBook(int authorId) {
        DaoAuthor daoAuthor = new DaoAuthor();
        return daoAuthor.importAuthor(authorId);
    }

    private BookPublisher getPublisherOfBook(String publisherId) {
        DaoBookPublisher daoBookPublisher = new DaoBookPublisher();
        return daoBookPublisher.importBookPublisher(publisherId);
    }
    private BookType getTypeOfBook (int typeId) {
        DaoBookType daoBookType = new DaoBookType();
        return daoBookType.importBookType(typeId);
    }
}
