package dao;

import model.Author;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoAuthor {
    public Author createAuthor(int authorId, String name, String surname, int birthYear, String city, String country) {
        return new Author(
                authorId, name, surname, birthYear, city, country
        );

    }

    public Author importAuthor(int authorId) {
        Author author = null;
        PreparedStatement ps = null;
        String query = "SELECT * FROM Authors WHERE author_id = ?";
        try {
            ps = DBConnection.getConnection().prepareStatement(query);
            ps.setInt(1, authorId);
            ResultSet rs = ps.executeQuery();
            if (!rs.isClosed()) {
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int birthYear = rs.getInt("birth_year");
                String city = rs.getString("city");
                String country = rs.getString("country");
                author = createAuthor(authorId, name, surname, birthYear, city, country);
                rs.close();
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return author;
    }

    public ArrayList<Author> importAllAuthors() {
        ArrayList<Author> authors = new ArrayList<>();
        PreparedStatement ps = null;
        String query = "SELECT * FROM Authors";
        try {
            ps = DBConnection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int authorId = rs.getInt("author_id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int birthYear = rs.getInt("birth_year");
                String city = rs.getString("city");
                String country = rs.getString("country");
                Author author = createAuthor(authorId, name, surname, birthYear, city, country);
                authors.add(author);
            }
            rs.close();
            ps.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return authors;
    }
}
