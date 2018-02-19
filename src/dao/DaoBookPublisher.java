package dao;

import model.BookPublisher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoBookPublisher {
    public BookPublisher createBookPublisher(String publisherId, String name, String city, String country) {
        return new BookPublisher(publisherId, name, city, country);
    }

    public BookPublisher importBookPublisher(String publisherId) {
        BookPublisher bookPublisher = null;
        PreparedStatement ps = null;
        String query = "SELECT * FROM Publishers WHERE publisher_id = ?";
        try {
            ps = DBConnection.getConnection().prepareStatement(query);
            ps.setString(1, publisherId);
            ResultSet rs = ps.executeQuery();
            if (!rs.isClosed()) {
                String name = rs.getString("name");
                String city = rs.getString("city");
                String country = rs.getString("country");
                bookPublisher = createBookPublisher(publisherId, name, city, country);
                rs.close();
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return bookPublisher;
    }

    public ArrayList<BookPublisher> importAllBookPublishers() {
        ArrayList<BookPublisher> bookPublishers = new ArrayList<>();
        PreparedStatement ps = null;
        String query = "SELECT * FROM Publishers";
        try {
            ps = DBConnection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String publisherId = rs.getString("publisher_id");
                String name = rs.getString("name");
                String city = rs.getString("city");
                String country = rs.getString("country");
                BookPublisher bookPublisher = createBookPublisher(publisherId, name, city, country);
                bookPublishers.add(bookPublisher);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return bookPublishers;
    }
}
