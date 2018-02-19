package model;

public class BookPublisher {
    private String publsherId;
    private String name;
    private String city;
    private String country;

    public BookPublisher(String publsherId, String name, String city, String country) {
        this.publsherId = publsherId;
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public String getPublsherId() {
        return publsherId;
    }

    public void setPublsherId(String publsherId) {
        this.publsherId = publsherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Publisher: id "+publsherId+ ", " + name + ", "
                + city + ", "+ country;
    }
}
