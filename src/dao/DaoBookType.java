package dao;

import model.BookType;

public class DaoBookType {
   public BookType createBookType(int typeId, String type) {
       return new BookType(typeId, type);
   }
}
