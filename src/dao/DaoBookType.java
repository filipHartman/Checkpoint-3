package dao;

import model.BookType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoBookType {
   public BookType createBookType(int typeId, String type) {
       return new BookType(typeId, type);
   }

   public BookType importBookType(int typeId) {
       BookType bookType = null;
       PreparedStatement ps = null;
       String query = "SELECT * FROM TypeBooks WHERE type_id = ?";
       try {
           ps = DBConnection.getConnection().prepareStatement(query);
           ps.setInt(1, typeId);
           ResultSet rs = ps.executeQuery();

           if(!rs.isClosed()) {
               String type = rs.getString("type");
               bookType = createBookType(typeId, type);
               rs.close();
           }
           ps.close();
       } catch (SQLException | ClassNotFoundException e) {
           System.err.println( e.getClass().getName() + ": " + e.getMessage() );
       }
       return bookType;
   }

   public ArrayList<BookType> importAllBookTypes() {
       ArrayList<BookType> bookTypes = new ArrayList<>();
       PreparedStatement ps = null;
       String query = "SELECT * FROM TypeBooks";
       try {
           ps = DBConnection.getConnection().prepareStatement(query);
           ResultSet rs = ps.executeQuery();
           while (rs.next()) {
               int typeId = rs.getInt("type_id");
               String type = rs.getString("type");
               BookType bookType = createBookType(typeId, type);
               bookTypes.add(bookType);
           }
           rs.close();
           ps.close();
       } catch (SQLException | ClassNotFoundException e) {
           System.err.println( e.getClass().getName() + ": " + e.getMessage() );
       }
       return bookTypes;
   }
}
