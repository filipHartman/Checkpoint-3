package dao;

import model.Author;
import model.Book;
import model.BookPublisher;
import model.BookType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
                book = createBookFromDBData(rs, ISBN);
            }
            rs.close();
            ps.close();

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        return book;
        }

    private Book createBookFromDBData(ResultSet rs, String ISBN) throws SQLException{
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
