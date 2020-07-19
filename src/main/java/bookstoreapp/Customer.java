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
public class Customer {

    //Properties
    private int id;
    private String name;
    private Address address;
    private String phoneNumber;
    private String email;
    //For online transaction
    private String status;//2 options: login or logoff
    private String username;
    private String password;
    private Address billingAddress;

    //Constructor(s):
    public Customer(int id, String name, Address address, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    //Assume that usename = "user1" and password = "1234"
    //Normally those authentication info is loaded from database
    public Customer(int id, String name, Address address, String phoneNumber, String email,
            String status, String username, String password, Address billingAddress) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        //
        this.status = status;
        this.username = username;
        this.password = password;
        this.billingAddress = billingAddress;
    }

    //Methods
    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nAddress " + address.toString()
                + "\nPhone number: " + phoneNumber + "\nEmail: " + email + "\n";
    }

    public String toString(String online) {
        return "ID: " + id + "\nName: " + name + "\nAddress " + address.toString()
                + "\nPhone number: " + phoneNumber + "\nEmail: " + email + "\n"
                + "\nStatus: " + status + "\nUsername: " + username + "\n"
                + "\nBilling Address " + billingAddress.toString();
    }

    public String toSave() {
        return id + ";" + name + ";" + address.toString() + ";" + phoneNumber + ";" + email;
    }

    public void validate(String username, String password) {
        if (this.status.equals("logon")) {
            //Already logon
            System.out.println("You're already logon!");
        } else {
            if (this.username.equals(username) && this.password.equals(password)) {
                status = "logon";
                System.out.println("Congratulation! You're logon successfully!");
            } else {
                System.out.println("ERROR! Username or Password is incorrect!!");
            }
        }
    }
   

    ////////////////////////////////////////////////////////////////////////////
    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

}
