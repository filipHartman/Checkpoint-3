package dao;

import model.Author;

public class DaoAuthor {
    public Author createAuthor(int authorId, String name, String surname, int birthYear, String city, String country) {
        return new Author(
                authorId, name, surname, birthYear, city, country
        );

    }

    

}
