package restaurantmanagement;

import java.io.*;
import java.util.*;

public class Menu implements Serializable {

    private ArrayList<Pizza> pizza;
    private ArrayList<SideLines> sidelines;
    private ArrayList<Beverages> beverages;
    File pizzasFile = new File("Pizza_Order.txt");
    File sidelinesFile = new File("Sideline_Order.txt");
    File beveragesFile = new File("Beverage_Order.txt");

    public Menu() {
        pizza = new ArrayList<>();
        sidelines = new ArrayList<>();
        beverages = new ArrayList<>();
        //readData();
    }

    public ArrayList<Pizza> getPizza() {

        return pizza;
    }

    public ArrayList<SideLines> getSidelines() {

        return sidelines;
    }

    public ArrayList<Beverages> getBeverages() {

        return beverages;
    }

    public void AddItem(MenuItem item) {
        if (item instanceof Pizza) {
            getPizza().add((Pizza) item);

        }
        if (item instanceof SideLines) {
            getSidelines().add((SideLines) item);

        }
        if (item instanceof Beverages) {
            getBeverages().add((Beverages) item);

        }

        //writeData();
    }

    public void RemoveItem(MenuItem item) {

        if (item instanceof Pizza) {
            getPizza().remove((Pizza) item);

        }
        if (item instanceof SideLines) {
            getSidelines().remove((SideLines) item);

        }
        if (item instanceof Beverages) {
            getBeverages().remove((Beverages) item);

        }

        //writeData();

    }

    public double TotalCost() {
        double total1 = 0, total2 = 0, total3 = 0;
        for (Pizza pizzas : pizza) {
            total1 = total1 + pizzas.totalcost();

        }
        for (SideLines sides : sidelines) {
            total2 = total2 + sides.totalcost();

        }
        for (Beverages bev : beverages) {
            total3 = total3 + bev.totalcost();

        }

        double bill = total1 + total2 + total3;

        return bill;

    }

    @Override
    public String toString() {

        return "Pizza = " + getPizza() + "\n" + "SideLine = " + getSidelines() + "\n" + "Beverages = " + getBeverages() + "\n" + "Total Bill = Rs " + TotalCost();

    }

}
