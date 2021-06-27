package restaurantmanagement;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class SideLines extends MenuItem implements CalculateCost, OrderSystem, Serializable {

    @Override
    public double totalcost() {
        double side_Cost = 0;
        if (this.size.equalsIgnoreCase("Small")) {
            side_Cost = 110;
        } else if (this.size.equalsIgnoreCase("Medium")) {
            side_Cost = 225;

        } else if (this.size.equalsIgnoreCase("Large")) {
            side_Cost = 350;
        }

        return side_Cost;
    }

    @Override
    public String toString() {
        DecimalFormat df2 = new DecimalFormat(".##");
        df2.setRoundingMode(RoundingMode.DOWN);

        return name + "(" + size + ") " + "Rs " + df2.format(totalcost());
    }

    @Override
    public void Order() {
        Scanner kb = new Scanner(System.in);

        boolean flag = true;
        while (flag) {
            System.out.print("Enter SideLine = ");
            this.name = kb.nextLine();
            if (this.name.equalsIgnoreCase("Fries")
                    || this.name.equalsIgnoreCase("Potato Wedges")
                    || this.name.equalsIgnoreCase("Hot Tenders")
                    || this.name.equalsIgnoreCase("Garlic Bread")) {
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
}
