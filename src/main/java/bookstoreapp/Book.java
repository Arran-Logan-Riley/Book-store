/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapp;

/**
 * This Book class is extended from Item class. It has 3 more privates
 * properties: author, edition and volume.
 *
 * @author ddang
 */
public class Book extends Item implements SetAuthorVolume {

    //Properties
    private String author;
    private String edition;
    private String volume;

    //Constructor
    /**
     * This method constructs a Book object that has 10 parameters.
     *
     * @param itemID - integer
     * @param title - String
     * @param publisher - String
     * @param yearPublished - integer
     * @param ISBN - String
     * @param price - double
     * @param quantity - integer
     * @param author - String
     * @param edition - String
     * @param volumn - String
     */
    Book(int itemID, String title, String publisher, int yearPublished, String ISBN,
            double price, int quantity,
            String author, String edition, String volume) {
        //Call the base class constructor of derived class Item;
        super(itemID, title, publisher, yearPublished, ISBN, price, quantity);
        this.author = author;
        this.edition = edition;
        this.volume = volume;
    }

    //Methods
    /**
     * This toString() is override to toString() method in "Item" superclass
     *
     * @return
     * @return: a String containing all detailed info of a book
     */
    @Override
    public String toString() {
        return super.toString() + ". Author: " + this.author
                + ". Edition: " + this.edition + ". Volume:" + this.volume;
    }

    /**
     *
     * @return
     */
    @Override
    public String toSave() {
        return "book|" + super.toSave() + "|" + this.author + "|" + this.edition + "|" + this.volume;
    }

    //Setter & getter for edition
    /**
     * This method get the book edition
     *
     * @return String
     */
    public String getEdition() {
        return edition;
    }

    /**
     * This method set book Edition
     *
     * @param edition is a String
     */
    public void setEdition(String edition) {
        this.edition = edition;
    }

    //Override 4 abstract abstact methods in SetAuthorVolume interface
    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getAuthor() {
        return this.author;
    }

    @Override
    public void setVolume(String volume) {
        this.volume = volume;
    }

    @Override
    public String getVolume() {
        return this.volume;
    }

}
