/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapp;

/**
 * This Software class is extended from Item class. It has 1 more private
 * properties: version
 *
 * @author ddang
 */
public class Software extends Item {

    //Properties
    private String version;

    //Constructor
    /**
     * This method constructs a Software object that has 8 parameters.
     *
     * @param itemID - integer
     * @param title - String
     * @param publisher - String
     * @param yearPublished - integer
     * @param ISBN - String
     * @param price - Double
     * @param quantity - Integer
     * @param version - String
     */
    Software(int itemID, String title, String publisher, int yearPublished, String ISBN,
            double price, int quantity,
            String version) {
        //Call the base class constructor of derived class Item;
        super(itemID, title, publisher, yearPublished, ISBN, price, quantity);
        this.version = version;
    }

    //Methods
    /**
     * This toString() is override to toString() method in "Item" superclass
     *
     * @return
     * @return: a String containing all detailed info of a software
     */
    @Override
    public String toString() {
        return super.toString() + ". Version: " + this.version;
    }

    /**
     *
     * @return
     */
    @Override
    public String toSave() {
        return "software|" + super.toSave() + "|" + this.version;
    }

    //Setter and getter for "version" properites
    /**
     * This method returns software version
     *
     * @return a String
     */
    public String getVersion() {
        return version;
    }

    /**
     * This method sets version to a software
     *
     * @param version - String
     */
    public void setVersion(String version) {
        this.version = version;
    }
}
