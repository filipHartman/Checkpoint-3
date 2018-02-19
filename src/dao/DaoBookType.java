package dao;

import model.BookType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
