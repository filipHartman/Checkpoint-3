package dao;

import model.BookPublisher;

public class DaoBookPublisher {
    public BookPublisher createBookPublisher(String publisherId, String name, String city, String country) {
        return new BookPublisher(publisherId, name, city, country);
    }

    
}
