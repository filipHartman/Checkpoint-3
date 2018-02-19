package dao;

import model.Author;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
