package restaurantmanagement;

import java.io.*;

public class FileHandling {

   // File pizzas = new File("Pizza_Order.txt");

    public static void writeToFile(Menu menu) {

        File f = new File("menu.ser");
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(f));
            os.writeObject(menu);
            os.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public static void writeToFile(CardPayment cardPayment) {

        File f = new File("card.ser");
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(f));
            os.writeObject(cardPayment);
            os.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public static void writeToFile(CustomerInfo customer) {

        File f = new File("customer.ser");
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(f));
            os.writeObject(customer);
            os.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static Menu readMenuFromFile() {

        File f = new File("menu.ser");

        Menu menu = new Menu();

        if (f.exists()) {
            try {

                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                menu = (Menu) ois.readObject();
                ois.close();
            } catch (Exception e) {
                menu = new Menu();
            }
        }

        return menu;

    }
    public static CardPayment readCardFromFile() {

        File f = new File("card.ser");

        CardPayment card = new CardPayment();

        if (f.exists()) {
            try {

                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                card = (CardPayment) ois.readObject();
                ois.close();
            } catch (Exception e) {
                card = new CardPayment();
            }
        }

        return card;

    }
    public static CustomerInfo readCustomerFromFile() {

        File f = new File("customer.ser");

        CustomerInfo customer = new CustomerInfo();

        if (f.exists()) {
            try {

                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                customer = (CustomerInfo) ois.readObject();
                ois.close();
            } catch (Exception e) {
                customer = new CustomerInfo();
            }
        }

        return customer;

    }

}
