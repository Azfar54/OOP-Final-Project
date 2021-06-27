package restaurantmanagement;

import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Pizza extends MenuItem implements CalculateCost, OrderSystem, Serializable{

    File pizzas = new File("Pizza_Order.txt");

    @Override
    public void Order() {
        Scanner kb = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.print("Enter Pizza Flavour = ");
            this.name = kb.nextLine();
            if (this.name.equalsIgnoreCase("Chicken Tikka") 
                    || this.name.equalsIgnoreCase("Chicken Fajita") 
                    || this.name.equalsIgnoreCase("Peri Peri Chicken")
                    || this.name.equalsIgnoreCase("Pepperoni")
                    || this.name.equalsIgnoreCase("Cheese Lovers")
                    || this.name.equalsIgnoreCase("Hawaiian")) {
                flag = false;
            }
        }

        flag = true;
        while (flag) {
            System.out.print("Enter Size = ");
            this.size = kb.nextLine();
            if (this.size.equalsIgnoreCase("Small")
                    || this.size.equalsIgnoreCase("Medium")
                    || this.size.equalsIgnoreCase("Large")) {
                flag = false;
            }
        }
    }

    @Override
    public double totalcost() {
        double pizza_Cost = 0;
        if (this.size.equalsIgnoreCase("Small")) {
            pizza_Cost = 590;
        } else if (this.size.equalsIgnoreCase("Medium")) {
            pizza_Cost = 800;

        } else if (this.size.equalsIgnoreCase("Large")) {
            pizza_Cost = 1030;
        }

        return pizza_Cost;
    }

    @Override
    public String toString() {
        DecimalFormat df2 = new DecimalFormat(".##");
        df2.setRoundingMode(RoundingMode.DOWN);

        return name + "(" + size + ") " + "Rs " + df2.format(totalcost());
    }

}
