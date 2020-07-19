/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The Bookstore class contains shop name, its address, and all items: books,
 * musicCD_DVDs, softwares
 *
 * @author ddang
 */
public class Bookstore {

    //Properties
    private String shopName;
    private Address address;
    private ArrayList<Item> items; //All items including books, music albums and software
    private ArrayList<Invoice> invoices;//Store all invoices
    private ArrayList<Customer> customers;//Store all customers

    //Constructors
    /**
     * This constructor creates a bookstore object with name. Its physical
     * address is default to "501, Gloucester, Napier, 4112, New Zealand"
     *
     * @param name - String
     */
    public Bookstore(String name) {
        this.shopName = name;
        this.address = new Address("501", "Gloucester", "Napier", 4112, "New Zealand");
        this.items = new ArrayList<Item>();
        this.invoices = new ArrayList<Invoice>();
        this.customers = new ArrayList<Customer>();

        //Load items from text file: items.txt
        loadItems("items.txt");
        loadCustomers("customers.txt");
        loadInvoices("invoices.txt");
    }

    //Methods
    /**
     * This method returns a string storing all information of all items
     * (including books, software, music CD/DVD) available in the bookstore;
     *
     * @return
     */
    public String displayAll() {
        String allInfo = "";
        //Display all info of items in bookstore
        allInfo += "All items in the bookstore: " + items.size() + "\n";

        //Loop through all items and add its info
        for (Item item : items) {
            allInfo += (item.toString() + "\n");
        }

        //Return all info        
        return allInfo;
    }

    /**
     *
     * @param option
     * @return
     */
    public String displayAll(String option) {
        String allInfo = "";
        //Display all info of items in bookstore
        allInfo += "All " + option + "(s)" + " in the bookstore:\n";

        //Loop through all items and add its info if matching
        for (Item item : items) {
            //Only appendix info of relevant item
            String className = item.getClass().getName();
            String itemType = className.substring(className.indexOf("."));
            if (itemType.toLowerCase().contains(option.toLowerCase())) {
                allInfo += (item.toString() + "\n");
            }
        }

        //Return all info        
        return allInfo;
    }

    /**
     * Add a new book to bookstore
     *
     * @param book
     */
    public void add(Book book) {
        //Check to make sure that the new itemID is UNIQUE
        boolean idIsUnique = true;
        for (Item item : items) {
            if (book.getItemID() == item.getItemID()) {
                idIsUnique = false;
            }
        }
        //Add new book
        if (idIsUnique) {
            //this.books.add(book);
            this.items.add(book);
            System.out.println("Add a new book successfully!");
        } else {
            System.out.println("ERROR! Book ID is not unique!");
        }
    }

    /**
     * Add a new music album to bookstore
     *
     * @param musicAlbum
     */
    public void add(MusicAlbum musicAlbum) {
        //Check to make sure that the new itemID is UNIQUE
        boolean idIsUnique = true;
        for (Item item : items) {
            if (musicAlbum.getItemID() == item.getItemID()) {
                idIsUnique = false;
            }
        }
        //Add new music Album
        if (idIsUnique) {
            //this.musicCD_DVDs.add(musicAlbum);
            this.items.add(musicAlbum);
            System.out.println("Add a new music album successfully!");
        } else {
            System.out.println("ERROR! Music Album ID is not unique!");
        }
    }

    /**
     * Add a new software to bookstore
     *
     * @param software
     */
    public void add(Software software) {
        //Check to make sure that the new itemID is UNIQUE
        boolean idIsUnique = true;
        for (Item item : items) {
            if (software.getItemID() == item.getItemID()) {
                idIsUnique = false;
            }
        }
        //Add new software
        if (idIsUnique) {
            //this.softwares.add(software);
            this.items.add(software);
            System.out.println("Add a new book successfully!");
        } else {
            System.out.println("ERROR! Software ID is not unique!");
        }
    }

    /**
     * Search an item by its id
     *
     * @param itemID
     * @return
     */
    public Item search(int itemID) {
        boolean found = false;
        Item foundItem = null;
        //Loop through all items
        for (Item item : items) {
            if (itemID == item.getItemID()) {
                foundItem = item;
                System.out.println("FOUND: " + item.toString());
                found = true;
                break;
            }
        }
        //
        if (!found) {
            System.out.println("NOT FOUND!");
        }
        //
        return foundItem;
    }

    /**
     *
     * @param customerID
     * @return
     */
    public Customer searchCustomer(int customerID) {
        boolean found = false;
        Customer foundCustomer = null;
        //Loop through all items
        for (Customer customer : customers) {
            if (customerID == customer.getId()) {
                foundCustomer = customer;
                System.out.println("FOUND: " + foundCustomer.toString());
                found = true;
                break;
            }
        }
        //
        if (!found) {
            System.out.println("NOT FOUND!");
        }
        //
        return foundCustomer;
    }

    /**
     *
     * @return
     */
    public int maxItemIndex() {
        int maxIndex = 0;
        for (Item item : items) {
            if (maxIndex <= item.getItemID()) {
                maxIndex = item.getItemID();
            }
        }
        //Return value
        return maxIndex;
    }

    /**
     *
     * @return
     */
    public int maxInvoiceIndex() {
        int maxIndex = 0;
        for (Invoice invoice : invoices) {
            if (maxIndex <= invoice.getId()) {
                maxIndex = invoice.getId();
            }
        }
        //Return value
        return maxIndex;
    }

    /**
     * Delete an item based on its id
     *
     * @param itemID
     */
    public void delete(int itemID) {
        boolean found = false;
        //Loop through all items
        for (Item item : items) {
            if (itemID == item.getItemID()) {
                items.remove(item);
                System.out.println("DELETE SUCCESSFULLY: " + item.toString() + "\n");
                found = true;
                break;
            }
        }
        //
        if (!found) {
            System.out.println("NOT FOUND THAT ITEM!\n");
        }
    }

    /**
     *
     * @param newInvoice
     */
    public void add(Invoice newInvoice) {
        //Check to make sure that the new invoice is UNIQUE
        boolean idIsUnique = true;
        for (Invoice invoice : invoices) {
            if (invoice.getId() == newInvoice.getId()) {
                idIsUnique = false;
            }
        }
        //Add new invoice
        if (idIsUnique) {
            this.invoices.add(newInvoice);
            //Subtract the item quantity in "items" array
            //Get all ItemOrders to be subtract the quantity in "items" array
            ArrayList<ItemOrder> itemOrdereds = newInvoice.getItemOrders();
            for (ItemOrder itemOrdered : itemOrdereds) {
                //Get the quantity of itemOrdered                
                int itemOrderedQuantity = itemOrdered.getQuantity();
                //Get "item" to be subtracted                
                Item itemSold = itemOrdered.getItem();
                int itemSoldID = itemSold.getItemID();            
                //Subtract the quantity of itemOrder from "items" array
                for (Item item: items) {
                    if (item.getItemID() == itemSoldID) {
                        item.setQuantity(item.getQuantity() - itemOrderedQuantity);
                    }
                }              
            }
            //Print out a message            
            System.out.println("Add a new invoice successfully!\n");
        } else {
            System.out.println("ERROR! Invoice ID is not unique!\n");
        }
    }

    /**
     *
     * @param fileName
     */
    public void loadItems(String fileName) {
        //Load existing notes stored in a text file
        //This method reads one line at a time from text file
        String line = null;

        //Try to open the text file and then read it line by line
        try {
            //1: Open text file: create an object "fileReader" to open text file:
            //A FileReader class is a general tool to read in characters from a File.
            FileReader fileReader = new FileReader(fileName);

            //2: Always wrap FileReader in BufferedReader:
            //The BufferedReader class can wrap around Readers, like FileReader, to buffer the input and improve efficiency. 
            //So you wouldn't use one over the other, but both at the same time by passing the FileReader object to the BufferedReader constructor.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //Now read line by line by using .readLine() method.
            //We have to check if we haven't reached the end of file (="null") before reading line --> While loop
            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);

                //Extract item info
                String itemInfo[] = line.split("\\|");

                //Only extract item info if the line is valid
                if (itemInfo.length > 1) {
                    String type = itemInfo[0];
                    String id = itemInfo[1];
                    String title = itemInfo[2];
                    String publisher = itemInfo[3];
                    String yearPublished = itemInfo[4];
                    String ISBN = itemInfo[5];
                    String price = itemInfo[6];
                    String quantity = itemInfo[7];

                    //DISPLAY ON SCREEN: FOR TESTING
                    System.out.println("Load: " + line + ". Type: " + type);

                    if (type.toLowerCase().equals("book")) {
                        String author = itemInfo[8];
                        String edition = itemInfo[9];
                        String volume = itemInfo[10];
                        Book book = new Book(Integer.parseInt(id), title, publisher,
                                Integer.parseInt(yearPublished), ISBN, Double.parseDouble(price), Integer.parseInt(quantity),
                                author, edition, volume);
                        this.items.add(book);
                    } else if (type.toLowerCase().equals("musicalbum")) {
                        String artist = itemInfo[8];
                        String volume = itemInfo[9];
                        MusicAlbum album = new MusicAlbum(Integer.parseInt(id), title, publisher,
                                Integer.parseInt(yearPublished), ISBN, Double.parseDouble(price), Integer.parseInt(quantity),
                                artist, volume);
                        this.items.add(album);
                    } else if (type.toLowerCase().equals("software")) {
                        String version = itemInfo[8];
                        Software software = new Software(Integer.parseInt(id), title, publisher,
                                Integer.parseInt(yearPublished), ISBN, Double.parseDouble(price), Integer.parseInt(quantity),
                                version);
                        this.items.add(software);
                    } else {
                        //Error
                        System.out.println("ERROR! LOAD UNSUCCESSFULLY!");
                    }
                } else {
                    //Not valid line
                    System.out.println("ERROR! LOAD UNSUCCESSFULLY THIS LINE!");
                }
            }

            //3: Always close file after reading
            bufferedReader.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file " + fileName);
            // Or we could just do this: ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error reading file " + fileName);
            // Or we could just do this: ex.printStackTrace();
        }
    }

    /**
     *
     */
    public void saveItems(String fileName) {
        //Writing Text Files in Java
        //To write a text file in Java, use FileWriter instead of FileReader, 
        //  and BufferedOutputWriter instead of BufferedOutputReader. 
        try {
            //1: Open text file
            FileWriter fileWrite = new FileWriter(fileName);

            //2: Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWrite);

            //3: Write to file line by line
            // Note that write() does not automatically append a newline character.
            for (int i = 0; i < this.items.size(); i++) {
                String getClassName = this.items.get(i).getClass().getName();
                String itemType = getClassName.substring(getClassName.indexOf(".") + 1);
                //
                String itemInfo = this.items.get(i).toSave();
                bufferedWriter.write(itemInfo);//Write item info on a line
                bufferedWriter.newLine();//Go to new line
            }

            //4: Always close files after writing
            bufferedWriter.close();

            //
            System.out.println("SUCCESFFULLY SAVE ALL ITEMS!!");

        } catch (IOException ex) {
            System.out.println("Error writing to file " + fileName);
            //Or we could just do this:ex.printStackTrace();
        }
    }

    public void loadCustomers(String fileName) {
        String line = null;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                String customerInfo[] = line.split("\\|");
                if (customerInfo.length > 6) {
                    //DISPLAY ON SCREEN: FOR TESTING
                    System.out.println("Load: " + line);

                    int id = Integer.parseInt(customerInfo[0]);
                    String name = customerInfo[1];

                    String address = customerInfo[2];
                    String addressBuild[] = address.split(";");
                    Address physicalAddress = new Address(addressBuild[0],
                            addressBuild[1], addressBuild[2],
                            Integer.parseInt(addressBuild[3]),
                            addressBuild[4]);

                    String phone = customerInfo[3];
                    String email = customerInfo[4];
                    String status = customerInfo[5];
                    String username = customerInfo[6];
                    String password = customerInfo[7];

                    String address2 = customerInfo[8];
                    String addressBuild2[] = address2.split(";");
                    Address billingAddress = new Address(addressBuild2[0],
                            addressBuild2[1], addressBuild2[2],
                            Integer.parseInt(addressBuild2[3]),
                            addressBuild2[4]);

                    //Create Customer object
                    Customer customer = new Customer(id, name, physicalAddress, phone, email,
                            status, username, password, billingAddress);
                    //Add to customers array
                    customers.add(customer);

                } else {
                    //Not valid line
                    System.out.println("ERROR! LOAD UNSUCCESSFULLY THIS LINE!");
                }
            }

            //3: Always close file after reading
            bufferedReader.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file " + fileName);
            // Or we could just do this: ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error reading file " + fileName);
            // Or we could just do this: ex.printStackTrace();
        }
    }

    public void loadInvoices(String fileName) {
        String line = null;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                String invoiceInfo[] = line.split("\\|");

                if (invoiceInfo.length > 1) {
                    //DISPLAY ON SCREEN: FOR TESTING
                    System.out.println("Load: " + line);

                    int invoiceID = Integer.parseInt(invoiceInfo[0]);

                    int customerID = Integer.parseInt(invoiceInfo[1]);
                    Customer loadCustomer = searchCustomer(customerID);

                    double salesTax = Double.parseDouble(invoiceInfo[2]);
                    double shippingFee = Double.parseDouble(invoiceInfo[3]);
                    double total = Double.parseDouble(invoiceInfo[5]);
                    String payment = invoiceInfo[6];
                    //
                    String itemOrderArray[] = invoiceInfo[4].split(";");
                    //Build itemOrders
                    ArrayList<ItemOrder> itemOrders = new ArrayList<ItemOrder>();
                    for (int i = 0; i < itemOrderArray.length; i++) {
                        String itemOrder[] = itemOrderArray[i].split(",");
                        if (itemOrder.length > 1) {
                            Item itemOrderLoad = search(Integer.parseInt(itemOrder[0]));
                            itemOrders.add(new ItemOrder(itemOrderLoad, Integer.parseInt(itemOrder[1])));
                        }
                    }
                    //Create Invoice object
                    Invoice invoice = new Invoice(invoiceID, loadCustomer, salesTax, shippingFee, total, payment);
                    invoice.setItemOrders(itemOrders);

                    //Add to "invoices" array
                    invoices.add(invoice);

                } else {
                    //Not valid line
                    System.out.println("ERROR! LOAD UNSUCCESSFULLY THIS LINE!");
                }
            }

            //3: Always close file after reading
            bufferedReader.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file " + fileName);
            // Or we could just do this: ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error reading file " + fileName);
            // Or we could just do this: ex.printStackTrace();
        }
    }

    public void saveInvoices(String fileName) {
        try {
            FileWriter fileWrite = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWrite);

            for (int i = 0; i < this.invoices.size(); i++) {
                String invoiceInfo = this.invoices.get(i).toSave();

                //DISPLAY ON SCREEN: FOR TESTING
                System.out.println("Write: " + invoiceInfo);

                bufferedWriter.write(invoiceInfo);//Write item info on a line
                bufferedWriter.newLine();//Go to new line
            }

            bufferedWriter.close();
            System.out.println("SUCCESFFULLY SAVE ALL INVOICES!! \n");

        } catch (IOException ex) {
            System.out.println("Error writing to file " + fileName + "\n");
            //Or we could just do this: ex.printStackTrace();
        }
    }

    /**
     *
     * @param username
     * @param password
     * @return
     */
    public Customer logon(String username, String password) {
        //Loop through all "customers" array to see if any customer matching?
        boolean found = false;
        Customer foundCustomer = new Customer(0, "unknown",
                new Address("501", "Gloucester", "Napier", 4112, "NZ"),
                "unknown", "unknown", "logoff", "unknown", "unknown",
                new Address("501", "Gloucester", "Napier", 4112, "NZ"));
        //
        for (Customer customer : this.customers) {
            if (customer.getUsername().toLowerCase().equals(username.toLowerCase())
                    && customer.getPassword().toLowerCase().equals(password)) {
                found = true;
                foundCustomer = customer;
                if (customer.getStatus().equals("logon")) {
                    //Already logon
                    System.out.println("You're already logon!\n");
                } else {
                    customer.setStatus("logon");
                    System.out.println("Congratulation! You're logon successfully!\n");
                }
                break;//Quit loop
            }
        }

        if (!found) {
            System.out.println("ERROR! Username or Password is incorrect! TRY AGAIN!\n");
        }

        //return this customer
        return foundCustomer;
    }

    public Customer logoff(int customerID) {
        for (Customer customer : this.customers) {
            if (customer.getId() == customerID) {
                //Set its status to logoff
                customer.setStatus("logoff");
                break;
            }
        }

        Customer defaultCustomer = new Customer(0, "unknown",
                new Address("501", "Gloucester", "Napier", 4112, "NZ"),
                "unknown", "unknown", "logoff", "unknown", "unknown",
                new Address("501", "Gloucester", "Napier", 4112, "NZ"));
        //
        System.out.println("GOOD BYE! You're logoff successfully!\n");
        return defaultCustomer;
    }

    ////////////////////////////////////////////////////////////////////////////
    //Getters/Setters
    /**
     * Get shop name
     *
     * @return
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * Set shop name
     *
     * @param shopName
     */
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    /**
     * Get shop address
     *
     * @return
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Set shop address
     *
     * @param address
     */
    public void setAddress(Address address) {
        this.address = address;
    }
}
