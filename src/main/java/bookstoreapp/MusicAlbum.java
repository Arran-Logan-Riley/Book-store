/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapp;

/**
 * This MusicCD_DVD class is extended from Item class. It has 2 more privates
 * properties: artist and volume.
 *
 * @author ddang
 */
public class MusicAlbum extends Item implements SetAuthorVolume {

    //Properties
    private String artist;
    private String volume;

    //Constructor
    /**
     * This method constructs a Music CD/DVD object that has 9 parameters.
     *
     * @param itemID - integer
     * @param title - String
     * @param publisher - String
     * @param yearPublished - integer
     * @param ISBN - String
     * @param price - Double
     * @param quantity - integer
     * @param artist - String
     * @param volume - String
     */
    MusicAlbum(int itemID, String title, String publisher, int yearPublished, String ISBN,
            double price, int quantity,
            String artist, String volume) {
        //Call the base class constructor of derived class Item;
        super(itemID, title, publisher, yearPublished, ISBN, price, quantity);
        this.artist = artist;
        this.volume = volume;
    }

    //Methods
    /**
     * This toString() is override to toString() method in "Item" superclass
     *
     * @return
     * @return: a String containing all detailed info of a music CD/DVD
     */
    @Override
    public String toString() {
        return super.toString() + ". Author: " + this.artist + ". Volume:" + this.volume;
    }

    /**
     *
     * @return
     */
    @Override
    public String toSave() {
        return "musicalbum|" + super.toSave() + "|" + this.artist + "|" + this.volume;
    }

    //Override 4 abstract abstact methods in SetAuthorVolume interface
    @Override
    public void setAuthor(String artist) {
        this.artist = artist;
    }

    @Override
    public String getAuthor() {
        return this.artist;
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
