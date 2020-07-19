/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapp;

import java.util.ArrayList;

/**
 *
 * @author ddang
 */
public class Invoice {

    //Properties
    private int id;
    private Customer customer;
    private double salesTax = 0.15;//Goods and Services Tax (GST) = 15% is added to almost all purchases in NZ
    private double shippingFee = 0;
    private double total = 0.0;
    private String methodOfPayment = "credit card";
    private ArrayList<ItemOrder> itemOrders = new ArrayList<ItemOrder>();

    //Constructors
    /**
     *
     * @param id
     * @param customer
     * @param salesTax
     * @param shippingFee
     * @param total
     * @param methodOfPayment
     */
    public Invoice(int id, Customer customer, double salesTax, double shippingFee,
            double total, String methodOfPayment) {
        this.id = id;
        this.customer = customer;
        this.salesTax = salesTax;
        this.shippingFee = shippingFee;
        this.methodOfPayment = methodOfPayment;
        //
        this.itemOrders = new ArrayList<ItemOrder>();

    }

    //Methods
    public String toString() {
        String itemOrders = "";
        for (ItemOrder itemOrder : this.itemOrders) {

            String className = itemOrder.getItem().getClass().getName();
            String itemType = className.substring(className.indexOf(".") + 1);

            itemOrders += ("Item: " + itemType + ". Title: " + itemOrder.getItem().getTitle() + ". Quantity: " + itemOrder.getQuantity() + "\n");
        }
        //
        return "Invoice number: " + id + "\n"
                + "Customer Info: " + "\n"
                + customer.toString()
                + "GST: " + salesTax + "\n"
                + "Shipping fee: " + shippingFee + "\n"
                + "Item(s): " + "\n" + itemOrders
                + "Total: " + (total + (total * salesTax) + shippingFee) + "\n"
                + "Payment method: " + methodOfPayment + ".";
    }

    /**
     *
     * @return
     */
    public String toSave() {
        String itemOrders = "";
        for (ItemOrder itemOrder : this.itemOrders) {
            itemOrders += (itemOrder.toSave() + ";");
        }
        //
        return id + "|" + customer.getId() + "|" + salesTax + "|" + shippingFee + "|"
                + itemOrders + "|"
                + (total + (total * salesTax) + shippingFee)
                + "|" + methodOfPayment;
    }

    //Add orderItem
    /**
     *
     * @param itemOrder
     * @return
     */
    public String addItem(ItemOrder itemOrder) {
        //Add a new itemOrder to the "itemOrders" ArrayList
        //Check if the order quantity is less or equal than the available quantity
        if (itemOrder.getQuantity() <= itemOrder.getItem().getQuantity()) {
            if (itemOrders.add(itemOrder)) {
                //Add item cost to the total cost
                setTotal(getTotal() + itemOrder.getPrice());                                
                //Print out a message                
                return "Added item successfully ";
            } else {
                return "ERROR. Not added item!";
            }
        } else {
            return "ERROR. The number of avaible items is not enough!!!";
        }

    }

    //In case customers want to remove items from the bucket
    /**
     *
     */
    public void remove() {
        //This is all statements to store invoice in database and other actions

    }

    ////////////////////////////////////////////////////////////////////////////
    //Getters, setters
    /**
     *
     * @return
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     *
     * @param customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     *
     * @return
     */
    public double getSalesTax() {
        return salesTax;
    }

    /**
     *
     * @param salesTax
     */
    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    /**
     *
     * @return
     */
    public double getShippingFee() {
        return shippingFee;
    }

    /**
     *
     * @param shippingFee
     */
    public void setShippingFee(double shippingFee) {
        this.shippingFee = shippingFee;
    }

    /**
     *
     * @return
     */
    public double getTotal() {
        return total;
    }

    /**
     *
     * @param total
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     *
     * @return
     */
    public String getMethodOfPayment() {
        return methodOfPayment;
    }

    /**
     *
     * @param methodOfPayment
     */
    public void setMethodOfPayment(String methodOfPayment) {
        this.methodOfPayment = methodOfPayment;
    }

    /**
     *
     * @return
     */
    public ArrayList<ItemOrder> getItemOrders() {
        return itemOrders;
    }

    /**
     *
     * @param itemOrders
     */
    public void setItemOrders(ArrayList<ItemOrder> itemOrders) {
        this.itemOrders = itemOrders;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

}
