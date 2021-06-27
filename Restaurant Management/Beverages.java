package restaurantmanagement;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;
public class Beverages extends MenuItem implements CalculateCost,OrderSystem, Serializable{

    @Override
    public double totalcost() {
        double bev_Cost = 0;
        if (this.size.equalsIgnoreCase("Small")) {
            bev_Cost = 45;
        } else if (this.size.equalsIgnoreCase("Medium")) {
            bev_Cost = 95;

        } else if (this.size.equalsIgnoreCase("Large")) {
            bev_Cost = 160;
        }

        return bev_Cost;
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
            System.out.print("Enter Beverage = ");
            this.name = kb.nextLine();
            if (this.name.equalsIgnoreCase("Coke")
                    || this.name.equalsIgnoreCase("Sprite")
                    || this.name.equalsIgnoreCase("Fanta")
                    || this.name.equalsIgnoreCase("Dew")
                    || this.name.equalsIgnoreCase("Nestle Water")) {
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


