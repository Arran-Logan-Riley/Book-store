/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This application is to test the bookstore
 *
 * @author ddang
 */
public class BookStoreApp {
    //Global variables

    static Bookstore bookstore = new Bookstore("Otatara Bookshop");
    static Customer customer = new Customer(0, "unknown",
            new Address("501", "Gloucester", "Napier", 4112, "NZ"),
            "unknown", "unknown", "logoff", "unknown", "unknown",
            new Address("501", "Gloucester", "Napier", 4112, "NZ"));
    static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ////////////////////////////////////////////////////////////////////////
        //Hard code few items to the collection
        /*
        Book javaBook = new Book(1, "Core Java", "Prentice Hall", 2015,
                "978-0-13-417730-4", 59.99, 3, "Cay S. Horstmann", "Tenth", "I");
        bookstore.add(javaBook);

        MusicAlbum loveStoryAlbum = new MusicAlbum(2, "Love Story", "Blackbird Studio", 2015,
                "789-0-12-316830-5", 33.99, 10, "Adele", "2");
        bookstore.add(loveStoryAlbum);

        Software netBeansIDE = new Software(3, "Netbeans IDE", "Apache", 2018,
                "234-4-13-760930-6", 0, 50, "10.0");
        bookstore.add(netBeansIDE);
         */

        ////////////////////////////////////////////////////////////////////////
        System.out.println("----------------------------------------------------------------");
        System.out.println("Welcome to the " + bookstore.getShopName() + ". Please pick one options:");
        System.out.println("---------");
        System.out.println("1. Show all existing items in the database (in any order).");
        System.out.println("2. Add a new item to the database.");
        System.out.println("3. Search an item based on its id.");
        System.out.println("4. Delete an item based on its id");
        System.out.println("---------");
        System.out.println("5. Change bookstore address.");
        System.out.println("6. PURCHASE");
        System.out.println("7. SAVE DATABASE (items)");
        System.out.println("---------");
        System.out.println("8. Logon");
        System.out.println("9. ONLINE SHOPPING");
        System.out.println("10. SAVE DATABASE (invoices)");
        System.out.println("11. Logoff");
        System.out.println("12. update an item");
        System.out.println("---------");
        System.out.println("q. Exit program.");
        System.out.println("----------------------------------------------------------------");

        System.out.print("What would you like to do?: ");
        String menuOption = sc.nextLine();

        while (!menuOption.contains("q")) {
            switch (menuOption) {
                case "1":
                    displayAllItems();
                    break;

                case "2":
                    addItem();
                    break;

                case "3":
                    searchItem();
                    break;

                case "4":
                    deleteItem();
                    break;

                case "5":
                    changeAddress();
                    break;

                case "6":
                    purchase();
                    break;

                case "7":
                    saveToTextFile();
                    break;

                case "8":
                    logon();
                    break;

                case "9":
                    onlineShopping();
                    break;

                case "10":
                    saveInvoices();
                    break;

                case "11":
                    logoff();
                    break;
                case "12":
                    updateItem();
                    break;

                default:
                    System.out.println("Invalid option!\n");
                    break;
            }

            //Enter option again
            System.out.print("What would you like to do?: ");
            menuOption = sc.nextLine();
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    static void changeAddress() {
        System.out.println("Current adderss: " + bookstore.getAddress());
        //
        System.out.print("Do you still want to change (y/n)? ");
        String option = sc.nextLine();
        //
        if (option.toLowerCase().equals("y")) {
            //Change to new address;
            System.out.println("please enter a new houseNumber");
            String var1 = sc.nextLine();
            System.out.println("please enter a new street name");
            String var2 = sc.nextLine();
            System.out.println("Please enter the city name");
            String var3 = sc.nextLine();
            System.out.println("please enter the postcode");
            int var4 = sc.nextInt();
            System.out.println("please enter the country");
            String var5 = sc.nextLine();
            System.out.println("Address has been changed");

            Address address = new Address(var1,var2, var3, var4, var5); //next wont wait for enter key press. Also this is initlizsed
            bookstore.setAddress(address);
        } else if (option.toLowerCase().equals("n")) {
            //Do nothing
            System.out.println("Address is not changed!\n");
        } else {
            System.out.println("Invalid!!\n");
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    static void displayAllItems() {
        //Display information of all items
        System.out.println("Display information of items:");
        //
        System.out.print("Option (book/music/software/all): ");
        String option = sc.nextLine();
        //
        if (option.toLowerCase().equals("book") || option.toLowerCase().equals("music")
                || option.toLowerCase().equals("software")) {
            String allInfo = bookstore.displayAll(option);
            System.out.println(allInfo);
        } else if (option.toLowerCase().equals("all")) {
            String allInfo = bookstore.displayAll();
            System.out.println(allInfo);
        } else {
            System.out.println("Invalid option!!\n");
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    static void addItem() {
        //Add a new item manually
        System.out.println("Add a new item to the database:");
        //Type of item
        System.out.print("What type? (book/music/software): ");
        String type = sc.nextLine();

        //Check if type is correct?
        if (type.equals("book") || type.equals("music") || type.equals("software")) {
            //Valid type. Enter item info     
            try {
                //Enter item ID                
                //Method 1: enter item ID
                //System.out.print("Item ID: ");
                //int itemID = Integer.parseInt(sc.nextLine());                              
                //Method 2: Auto-increment  to generate itemID
                int itemID = bookstore.maxItemIndex() + 1;
                
                //Enter title
                System.out.print("Title: ");
                String title = sc.nextLine();
                //Enter publisher
                System.out.print("Publisher: ");
                String publisher = sc.nextLine();
                //Enter yearpublished
                System.out.print("Year published: ");
                int yearPublished = Integer.parseInt(sc.nextLine());
                //Enter ISBN
                System.out.print("ISBN: ");
                String isbn = sc.nextLine();
                //Enter price
                System.out.print("Price: ");
                double price = Double.parseDouble(sc.nextLine());
                //Enter quanity
                System.out.print("Quantity: ");
                int quantity = Integer.parseInt(sc.nextLine());

                //
                if (type.equals("book")) {
                    //Enter specific info for book: author, edition, volume
                    //Enter author
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    //Enter edition
                    System.out.print("Edition: ");
                    String edition = sc.nextLine();
                    //Enter volume
                    System.out.print("Volume: ");
                    String volume = sc.nextLine();
                    //Create a new object: book
                    Book newBook = new Book(itemID, title, publisher, yearPublished,
                            isbn, price, quantity, author, edition, volume);
                    //Add this new object to the bookstore
                    bookstore.add(newBook);

                } else if (type.equals("music")) {
                    //Enter specific info for music CD/DVD: artist, volume                    
                    //Enter artist
                    System.out.print("Artist: ");
                    String artist = sc.nextLine();
                    //Enter volume
                    System.out.print("Volume: ");
                    String volume = sc.nextLine();
                    //Create a new object: music CD/DVD
                    MusicAlbum newAlbum = new MusicAlbum(itemID, title, publisher, yearPublished,
                            isbn, price, quantity, artist, volume);
                    //Add this new object to the bookstore
                    bookstore.add(newAlbum);

                } else {
                    //Enter specific info for software: version 
                    //Enter version
                    System.out.print("Version: ");
                    String version = sc.nextLine();
                    //Create a new object: software
                    Software newSoftware = new Software(itemID, title, publisher, yearPublished,
                            isbn, price, quantity, version);
                    //Add this new object to the bookstore
                    bookstore.add(newSoftware);
                }

            } catch (Exception e) {
                System.out.print("ERROR.\n");

            }

        } else {
            //Invalid type
            System.out.println("Invalid type!!\n");
        }

    }

    ////////////////////////////////////////////////////////////////////////////
    static void deleteItem() {
        //Delete an item by its id
        System.out.println("Delete an item from the database:");
        //Type of item
        System.out.print("Item id: ");
        String itemID = sc.nextLine();
        //
        try {
            int id = Integer.parseInt(itemID);
            bookstore.delete(id);
        } catch (Exception e) {
            System.out.print("INVALID ITEM ID! MUST BE A NUMBER ");
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    static void updateItem() {
        System.out.println("Update an item");
        System.out.println("Item id: ");
        String itemID = sc.nextLine(); //get the user input

        try {
            int id = Integer.parseInt(itemID);
           Item item = bookstore.search(id);//search for the item by id
            System.out.println("enter ISBN");
            String var1 = sc.next();
            item.setISBN(var1);
            System.out.println("Enter a new price"); //enter the price
            Double var2 = sc.nextDouble();
            item.setPrice(var2);
            System.out.println("Enter a a publisher"); //enter a publisher
            String var3 = sc.next();
            item.setPublisher(var3);
            System.out.println("enter a title");//enter a title
            String var4 = sc.next();
            item.setTitle(var4);
            System.out.println("Enter a quantity");//enter a quantity
            int var5 = sc.nextInt();
            item.setQuantity(var5);
            System.out.println("enter a year published"); //enter a year that it was published
            int var6 = sc.nextInt();
            item.setYearPublished(var6);
            System.out.println("Item has been updated");

        } catch (Exception e){
            System.out.println("Incalid entry");
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    static void searchItem() {
        //Search an item by its id
        System.out.println("Search an item to the database:");
        //Type of item
        System.out.print("Item id: ");
        String itemID = sc.nextLine();
        //
        try {
            int id = Integer.parseInt(itemID);
            bookstore.search(id);
        } catch (Exception e) {
            System.out.print("INVALID ITEM ID! MUST BE A NUMBER ");
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    static void purchase() {
        //1: Ask customer information
        System.out.println("1: Ask customer information: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.println("Address: 501, Gloucester str., Napier, 4112, NZ.");
        Address address = new Address("501", "Gloucester", "Napier", 4112, "NZ");
        System.out.print("Phone Number: ");
        String phone = sc.nextLine();
        System.out.print("Email address: ");
        String email = sc.nextLine();
        //Generate a new customer id

        Customer customer = new Customer(1, name, address, phone, email);

        //2: Check out all items in the customer's bucket
        //For test: 2 books (id=1), 1 album (id=2), 1 software (id=3)
        //Create an "invocie" object
        int invoiceID = bookstore.maxInvoiceIndex();
        if (invoiceID == 0) {
            //No invoice in the list
            invoiceID = 1;//Start the id from 1.
        } else {
            invoiceID++;//Increase id by 1 to generate the invoice index
        }
        //Create an "invocie" object
        Invoice invoice = new Invoice(invoiceID, customer, 0.15, 0.0, 0.0, "credit card");

        //
        System.out.println("2: Check out all items in the customer's bucket:");
        System.out.println("Example: items in bucket are 2 books (id=1), 1 album (id=2), 1 software (id=3)");
        while (true) {
            System.out.print("Check out item (y/n)? ");
            String checkItem = sc.nextLine();
            //
            if (checkItem.toLowerCase().equals("y")) {
                try {
                    System.out.print("Item ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Item checkoutItem = bookstore.search(id);

                    //If not found item, ask users to do again
                    if (!(checkoutItem == null)) {
                        System.out.print("Quantity: ");
                        int quantity = Integer.parseInt(sc.nextLine());
                        ItemOrder itemOrder = new ItemOrder(checkoutItem, quantity);

                        //Add itemOrder
                        String outcome = invoice.addItem(itemOrder);
                        System.out.println(outcome);
                    }
                } catch (Exception e) {
                    System.out.println("id and quantity must be entire numbers! Do it again!");
                }

            } else if (checkItem.toLowerCase().equals("n")) {
                //Simply quit the loop - checkout all items done.
                break;
            } else {
                System.out.println("Invalid! Type again!");
            }
        }

        //Purchase is successful if there is at least one itemOrder in the shopping cart
        ArrayList<ItemOrder> itemOrders = invoice.getItemOrders();
        if (itemOrders.size() > 0) {
            //3: Ask customer method of payment.
            System.out.print("3: Payment method: ");
            String payment = sc.nextLine();
            invoice.setMethodOfPayment(payment);

            //4: Print out the invoice
            System.out.println("_____________________");
            System.out.println("INVOICE: \n" + invoice.toString());
            System.out.println("_____________________");
            
            //add new invoice
            bookstore.add(invoice);
        }

    }

    ////////////////////////////////////////////////////////////////////////////
    static void saveToTextFile() {
        bookstore.saveItems("items.txt");
    }

    ////////////////////////////////////////////////////////////////////////////
    static void logon() {
        //Logon to the online system
        System.out.println("Logon to the online system:");
        //
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        //
        customer = bookstore.logon(username, password);
    }

    ////////////////////////////////////////////////////////////////////////////
    static void onlineShopping() {
        //Check if the customer is already logon?
        if (!customer.getStatus().equals("logon") || customer.getName().equals("unknown")) {
            System.out.println("ERROR! PLEASE LOGON BEFORE DOING ANY ONLINE SHOPPING!\n");

        } else {
            System.out.println("Pick up items to your shopping cart from below available items:: ");
            String allInfo = bookstore.displayAll();
            System.out.println(allInfo);
            //
            ShoppingCart shoppingCart = new ShoppingCart(customer);
            //
            while (true) {
                System.out.print("Select item (y/n)? ");
                String checkItem = sc.nextLine();
                //
                if (checkItem.toLowerCase().equals("y")) {
                    try {
                        System.out.print("Item ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        Item checkoutItem = bookstore.search(id);

                        //If not found checout item, ask users to do again
                        if (!(checkoutItem == null)) {
                            System.out.print("Quantity: ");
                            int quantity = Integer.parseInt(sc.nextLine());
                            ItemOrder itemOrder = new ItemOrder(checkoutItem, quantity);

                            //Add itemOrder to the shopping cart
                            String outcome = shoppingCart.addItem(itemOrder);
                            System.out.println(outcome);
                        }

                    } catch (Exception e) {
                        System.out.println("id and quantity must be valid! Do it again!");
                    }

                } else if (checkItem.toLowerCase().equals("n")) {
                    //Simply quit the loop - checkout all items done.
                    break;
                } else {
                    System.out.println("Invalid! Type again!");
                }
            }

            //If the online shopping is successfully, there is at least one itemOrder in the shopping cart
            ArrayList<ItemOrder> itemOrders = shoppingCart.getItemOrders();
            if (itemOrders.size() > 0) {
                //Ask customer method of payment.
                System.out.print("3: Payment method: ");
                String payment = sc.nextLine();

                //Create an "invocie" object
                int invoiceID = bookstore.maxInvoiceIndex();
                if (invoiceID == 0) {
                    //No invoice in the list
                    invoiceID = 1;//Start the id from 1.
                } else {
                    invoiceID++;//Increase id by 1 to generate the invoice index
                }

                //Create an "invoice" object
                Invoice invoice = new Invoice(invoiceID, customer, 0.15, 0.0, 0.0, payment);
                //Add all ItemOrders to invoices

                for (ItemOrder itemOrder : itemOrders) {
                    invoice.addItem(itemOrder);
                }

                //Print invoice
                System.out.println("_____________________");
                System.out.println("INVOICE: \n" + invoice.toString());
                System.out.println("_____________________");

                //add new invoice to "invoices" array
                bookstore.add(invoice);
            } else {
                System.out.println("No items in your shopping cart!");
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    static void saveInvoices() {
        //Check if the customer is already logon?
        if (!customer.getStatus().equals("logon") || customer.getName().equals("unknown")) {
            System.out.println("ERROR! PLEASE LOGON BEFORE DOING ANY ONLINE SHOPPING!\n");
        } else {
            bookstore.saveInvoices("invoices.txt");
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    static void logoff() {
        //Check if the customer is already logon?
        if (!customer.getStatus().equals("logon") || customer.getName().equals("unknown")) {
            System.out.println("NO NEED LOGOFF BECAUSE YOU ARE NOT LOGON YET!\n");
        } else {
            customer = bookstore.logoff(customer.getId());
        }
    }
}
