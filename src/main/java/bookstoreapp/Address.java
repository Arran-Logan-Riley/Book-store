/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapp;

/**
 * THis Address class is to create a address having (1) houseNumber (String);
 * (2) street (String); (3) city (String); (4) postalCode (int); (5) Country
 * (String).
 *
 * @author ddang
 */
public class Address {

    //Properties
    private String houseNumber;
    private String street;
    private String city;
    private int postalCode;
    private String country;

    //Constructor
    public Address(String houseNumber, String street, String city, int postalCode, String country) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    //Methods: 
    public String toString() {
        return "Unit number: " + houseNumber + ". Street: " + street + ". City: " + city
                + ". Postal code: " + postalCode + ". Country: " + country;
    }

    public String toSave() {
        String unitNumber = this.houseNumber.replaceAll(";", "").replaceAll("|", "");
        String str = this.street.replaceAll(";", "").replaceAll("|", "");
        String cityName = this.city.replaceAll(";", "").replaceAll("|", "");
        String countryName = this.country.replaceAll(";", "").replaceAll("|", "");

        //return houseNumber + ";" + street + ";" + city + ";" + postalCode + ";" + country;
        return unitNumber + ";" + str + ";" + cityName + ";" + postalCode + ";" + countryName;
    }


    ////////////////////////////////////////////////////////////////////////////
    //GETTERS/SETTERS
    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
