/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapp;

/**
 *
 * @author ddang
 */
public class ItemOrder {

    //Properties
    private Item item;
    private int quantity;

    //Constructors
    public ItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    //Methods
    public String toString() {
        return "Item: " + item.getItemID() + ". Quantity: " + quantity + ".\n";
    }

    //
    public String toSave() {
        return item.getItemID() + "," + quantity;
    }

    //
    public double getPrice() {
        return item.getPrice() * quantity;
    }

    ////////////////////////////////////////////////////////////////////////////
    //Getters & Setters
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
