/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapp;

import static bookstoreapp.BookStoreApp.bookstore;
import java.util.ArrayList;

/**
 *
 * @author ddang
 */
public class ShoppingCart {

    //Properties
    private Customer customer;
    private ArrayList<ItemOrder> itemOrders = new ArrayList<ItemOrder>();

    //Constructor(s)
    public ShoppingCart(Customer customer) {
        this.customer = customer;
        this.itemOrders = new ArrayList<ItemOrder>();
    }

    //Methods
    public String toString() {
        String itemOrders = "";
        for (ItemOrder itemOrder : this.itemOrders) {
            String className = itemOrder.getItem().getClass().getName();
            String itemType = className.substring(className.indexOf(".") + 1);
            //
            itemOrders += ("Item: " + itemType + ". Title: " + itemOrder.getItem().getTitle() + ". Quantity: " + itemOrder.getQuantity() + "\n");
        }
        //
        return "Shopping cart of " + customer.getName() + ":\n" + itemOrders;
    }

    public String addItem(ItemOrder itemOrder) {
        //Add a new itemOrder to the "itemOrders" ArrayList
        //Check if the order quantity is less or equal than the available quantity
        if (itemOrder.getQuantity() <= itemOrder.getItem().getQuantity()) {
            if (itemOrders.add(itemOrder)) {
                return "Added successfully item to shoppingcart";
            } else {
                return "ERROR. Not added item to shoppingcard";
            }
        } else {
            return "ERROR. The number of avaible items is not enough!!!";
        }
    }

    public String removeItem(ItemOrder itemOrder) {
        //Remove an itemOrder from the "itemOrders" ArrayList
        if (itemOrders.remove(itemOrder)) {
            return "Removed successfully item to shoppingcart";
        } else {
            return "ERROR. Not removed item to shoppingcard";
        }
    }

    public void checkOut() {
        //Create a new Invoice and add to "invoices" Arraylist
        //1: Create an "invoice" object
        int invoiceID = bookstore.maxInvoiceIndex();
        if (invoiceID == 0) {
            //No invoice in the list
            invoiceID = 1;//Start the id from 1.
        } else {
            invoiceID++;//Increase id by 1 to generate the invoice index
        }
        Invoice invoice = new Invoice(invoiceID, customer, 0.15, 0.0, 0.0, "credit card");

        //2: Transfer "itemOrders" from ShoppingCart to Invoice
        invoice.setItemOrders(this.itemOrders);

        //3: Add new invoice
        bookstore.add(invoice);

        //4: Print out the invoice
        System.out.println("_____________________");
        System.out.println("INVOICE: \n" + invoice.toString());
        System.out.println("_____________________");
    }

    ////////////////////////////////////////////////////////////////////////////
    //Getters and setters
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<ItemOrder> getItemOrders() {
        return itemOrders;
    }

    public void setItemOrders(ArrayList<ItemOrder> itemOrders) {
        this.itemOrders = itemOrders;
    }

}
