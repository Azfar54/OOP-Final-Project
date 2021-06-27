package restaurantmanagement;

import java.util.*;

public class PizzaRunner {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println(" ---------Welcome to Papa John's Pizza----------");
        System.out.println();

        Pizza pizza = new Pizza();

        SideLines side = new SideLines();

        Beverages bev = new Beverages();

        Menu menu = FileHandling.readMenuFromFile();
        CardPayment card = FileHandling.readCardFromFile();
        CustomerInfo customer = FileHandling.readCustomerFromFile();
        customer.setItems(menu);

        //Creating Menu
        while (true) {
            System.out.println("\n\n");
            System.out.println("Press 1 to Order");
            System.out.println("Press 2 to View Cart");
            System.out.println("Press 3 to Edit Order Details");
            System.out.println("Press 4 to Add Contact Details");
            System.out.println("Press 5 to Proceed to payment");
            System.out.println("Press 6 to Confirm Order");
            System.out.println("Press 7 to Exit.");

            System.out.println();
            System.out.print("Enter your choice:: ");
            try {

                int choice = scan.nextInt();
                System.out.println("\n");

                switch (choice) {
                    case 1:
                        System.out.println("Choose your Flavours");
                        System.out.println("1.Chicken Tikka \n2.Chicken Fajita \n3.Peri Peri Chicken \n4.Pepperoni \n5.Cheese Lovers \n6.Hawaiian\n");
                        pizza = new Pizza();
                        pizza.Order();
                        pizza.totalcost();
                        menu.AddItem(pizza);

                        System.out.println("\nChoose your sidelines");
                        System.out.println("1. Fries \n2. Potato Wedges \n3. Hot Tenders \n4. Garlic Bread\n");
                        side = new SideLines();
                        side.Order();
                        side.totalcost();
                        menu.AddItem(side);

                        System.out.println("\nChoose Drinks");
                        System.out.println("1. Coke \n2. Sprite \n3. Fanta \n4. Dew \n5. Nestle Water\n");
                        bev = new Beverages();
                        bev.Order();
                        bev.totalcost();
                        menu.AddItem(bev);
                        FileHandling.writeToFile(menu);
                        break;
                    case 2:

                        menu.TotalCost();
                        System.out.println(menu);
                        break;

                    case 3:
                        System.out.println("What would you like to remove? \n1.Pizza \n2.SideLines \n3.Beverages");
                        System.out.println("\nPress 1 or 2 or 3: ");
                        int c = scan.nextInt();

                        OUTER:
                        do {
                            switch (c) {
                                case 1:
                                    if (menu.getPizza().isEmpty()) {
                                        System.out.println("No Pizza added!");
                                    } else {
                                        System.out.println("What would you like to remove?");
                                        int i = 1;
                                        for (Pizza p : menu.getPizza()) {
                                            System.out.println(i + "." + p.getName());
                                            i++;
                                        }

                                        int ch = 0;

                                        INNER:
                                        do {

                                            System.out.println("\nSelect: ");

                                            ch = scan.nextInt();

                                            if (ch > 0 && ch < i) {
                                                break INNER;
                                            } else {
                                                System.out.println("invalid choice please re-enter");
                                                System.out.println("");
                                            }
                                        } while (ch <= 0 || ch >= i);
                                        menu.RemoveItem(menu.getPizza().get(ch - 1));
                                        System.out.println("Pizza has been removed from the order.");

                                    }
                                    break OUTER;
                                case 2:
                                    if (menu.getSidelines().isEmpty()) {
                                        System.out.println("No Sideline added!");
                                    } else {
                                        System.out.println("What would you like to remove?");
                                        int i = 1;
                                        for (SideLines s : menu.getSidelines()) {
                                            System.out.println(i + "." + s.getName());
                                            i++;
                                        }

                                        int ch = 0;

                                        INNER:
                                        do {

                                            System.out.println("\nSelect: ");

                                            ch = scan.nextInt();

                                            if (ch > 0 && ch < i) {
                                                break INNER;
                                            } else {
                                                System.out.println("invalid choice please re-enter");
                                                System.out.println("");
                                            }
                                        } while (ch <= 0 || ch >= i);
                                        menu.RemoveItem(menu.getSidelines().get(ch - 1));
                                        System.out.println("Sideline has been removed from the order");

                                    }

                                    break OUTER;
                                case 3:
                                    if (menu.getBeverages().isEmpty()) {
                                        System.out.println("No Beverage added!");
                                    } else {
                                        System.out.println("What would you like to remove?");
                                        int i = 1;
                                        for (Beverages p : menu.getBeverages()) {
                                            System.out.println(i + "." + p.getName());
                                            i++;
                                        }

                                        int ch = 0;

                                        INNER:
                                        do {

                                            System.out.println("\nSelect: ");

                                            ch = scan.nextInt();

                                            if (ch > 0 && ch < i) {
                                                break INNER;
                                            } else {
                                                System.out.println("invalid choice please re-enter");
                                                System.out.println("");
                                            }
                                        } while (ch <= 0 || ch >= i);
                                        menu.RemoveItem(menu.getBeverages().get(ch - 1));
                                        System.out.println("Beverage has been removed from the order");

                                    }
                                    break OUTER;
                                default:
                                    System.out.println("invalid choice please re-enter");
                                    System.out.println("");
                                    System.out.println("\nPress 1 or 2 or 3: ");
                                    c = scan.nextInt();
                                    break;
                            }
                        } while (c > 0 || c < 4);
                        FileHandling.writeToFile(menu);
                        break;

                    case 4:
                        customer.CustomerDetails();
                        FileHandling.writeToFile(customer);
                        break;
                    case 5:

                        System.out.println("Payment by: \n1.Cash on Delivery \n2.Card");
                        System.out.print("Choose your option  (1 or 2) :  ");
                        int option = scan.nextInt();
                        scan.nextLine();
                        System.out.println("\n");
                        OUTER:
                        do {
                            if (option == 1) {
                                System.out.println("Payment Mode = Cash on Delivery.\n");
                                card.setCardNumber(null);
                                break OUTER;
                            } else if (option == 2) {
                                System.out.println("Payment Mode = Card.\n");
                                card.cardInfo();
                                break OUTER;
                            } else {
                                System.out.println("Invalid option entered.  Choose again");
                                System.out.println("");
                                System.out.println("Payment by: \n1.Cash on Delivery \n2.Card");
                                System.out.print("Choose your option  (1 or 2) :  ");
                                option = scan.nextInt();

                            }
                        } while (option > 0 || option < 3);

                        FileHandling.writeToFile(card);
                        break;

                    case 6:
                        System.out.println("Order Confirmed\n");
                        System.out.println(customer.toString());
                        if (card.getCardNumber() == null) {
                            System.out.print("\nPayment Mode: Cash");
                        } else {
                            System.out.print("\nPayment Mode: Card");

                        }
                        break;

                    case 7:

                        System.exit(0);
                        break;
                    default:
                        System.out.println("Incorrect input!!! Please re-enter choice from the menu");
                }
            } catch (InputMismatchException e) {
                System.out.println("Only numeric values allowed. \n");
                scan.next();
            }

        }

    }

}
