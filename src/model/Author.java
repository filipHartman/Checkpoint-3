package model;

public class Author {
    private int authorId;
    private String name;
    private String surname;
    private int birthYear;
    private String city;
    private String country;

    public Author(int authorId, String name, String surname, int birthYear, String city, String country) {
        this.authorId = authorId;
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.city = city;
        this.country = country;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return String.format(
                "Author: ID: %d, %s %s, %d, %s, %s",
                authorId, name, surname, birthYear, city, country);
    }
}
