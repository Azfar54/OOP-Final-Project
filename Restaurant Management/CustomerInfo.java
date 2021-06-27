
package restaurantmanagement;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

public class CustomerInfo implements Serializable{
    private String customerName;
  
    private String phoneNumber;
    private Menu items;
    private String orderDate;
    private String orderTime;
    private String address;

    CustomerInfo(Menu items) {

        this.items = items;
    }

    public void setItems(Menu items) {
        this.items = items;
    }

    
    CustomerInfo() {

    }

    @Override
    public String toString() {
        int rand = 0;
        rand = (int) (Math.random() * 100 + 1);
  orderDate = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
        orderTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        return String.format("Order No  %d |  %s  |  %s    \n\nCustomerName = %s \nAddress [%s]\nPhoneNumber = %s  \n\nOrder Summary \n\n%s", rand,orderDate, orderTime, customerName, address, phoneNumber, items);
    }

    public void CustomerDetails() {
        Scanner kb = new Scanner(System.in);
        System.out.print("Customer Name = ");
        this.customerName = kb.nextLine();
        System.out.print("Address = ");
        this.address = kb.nextLine();
        System.out.print("Contact = ");
        this.phoneNumber = kb.nextLine();

    }
}
