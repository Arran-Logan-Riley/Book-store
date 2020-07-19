/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapp;

/**
 * This Item class is an abstract class. It's superclass of 3 types of classes
 * Book, MusicCD_DVD, Software.
 *
 * @author ddang
 */
abstract public class Item {

    //Properties
    private int itemID;
    private String title;
    private String publisher;
    private int yearPublished;
    private String ISBN;
    private double price;
    private int quantity;

    public Item(int itemID, String title, String publisher, int yearPublished, String ISBN,
            double price, int quantity) {
        this.itemID = itemID;
        this.title = title;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.ISBN = ISBN;
        this.price = price;
        this.quantity = quantity;
    }

    public Item() {
        this.itemID = 12345;
        this.title = "unknown";
        this.publisher = "unknown";
        this.yearPublished = 1000;
        this.ISBN = "12.012-6511";
        this.price = 0;
        this.quantity = 0;
    }

    //Methods
    /**
     * This method returns a string containing all detailed info of an item This
     * method will be override by all sub-classes later
     *
     * @return a String
     */
    public String toString() {
        return "itemID: " + itemID + ". Title: " + title + ". Publisher: " + publisher
                + ". Year published: " + Integer.toString(yearPublished)
                + ". ISBN: " + ISBN + ". Price: " + Double.toString(price)
                + ". Quantity: " + Integer.toString(quantity);
    }

    /**
     *
     * @return
     */
    public String toSave() {
        return itemID + "|" + title + "|"
                + publisher + "|" + Integer.toString(yearPublished) + "|"
                + ISBN + "|" + Double.toString(price) + "|" + Integer.toString(quantity);
    }

    ////////////////////////////////////////////////////////////////////////////
    //Getters & Setters
    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        if (yearPublished < 0) {
            this.yearPublished = 0;
        } else {
            this.yearPublished = yearPublished;
        }
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            this.price = 0;
        } else {
            this.price = price;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            this.quantity = 0;
        } else {
            this.quantity = quantity;
        }
    }
}
