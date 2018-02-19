package model;

public class BookPublisher {
    private String publisherId;
    private String name;
    private String city;
    private String country;

    public BookPublisher(String publisherId, String name, String city, String country) {
        this.publisherId = publisherId;
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
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
        return "Publisher: ID: "+publisherId+ ", " + name + ", "
                + city + ", "+ country;
    }
}
