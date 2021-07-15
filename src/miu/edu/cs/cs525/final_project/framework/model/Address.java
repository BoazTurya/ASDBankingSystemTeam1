package miu.edu.cs.cs525.final_project.framework.model;

public class Address {
    private String state;
    private String city;
    private String zip;
    private String Street;

    public Address( String street ,String state, String city, String zip) {
        this.state = state;
        this.city = city;
        this.zip = zip;
        Street = street;
    }

    public String getState() {
        return state;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
