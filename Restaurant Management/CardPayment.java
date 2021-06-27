package restaurantmanagement;

import java.io.File;
import java.io.Serializable;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
public class CardPayment implements Serializable{

    private String Name;
    private String CardNumber;
    private String PIN;
    private String expiryDate;
    
    private File cardFile = new File("Card_Payment.txt");

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String CardNumber) {
        this.CardNumber = CardNumber;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;

    }

    @Override
    public String toString() {
        return String.format("Name = %s \nCardNumber = %s \nPIN = %s \nexpiryDate = %s", Name, CardNumber, PIN, expiryDate);
    }

    public void cardInfo() {
        Scanner kb = new Scanner(System.in);

        System.out.print("Enter Name = ");
        this.Name = kb.nextLine();

        System.out.print("Enter Card Number = ");
        this.CardNumber = kb.nextLine();
        OUTER:
        do {

            if (CardNumber.length() == 16) {
                break OUTER;
            } else {
                System.out.println("Inalid Card number. \nPlease enter again");
                System.out.print("Enter Card Number = ");
                this.CardNumber = kb.nextLine();
            }
        } while (CardNumber.length() > 0 || CardNumber.length() < 17);

        System.out.print("Enter 3 digit CVV  = ");
        this.PIN = kb.nextLine();
        OUTER:
        do {
            if (PIN.length() == 3) {
                break OUTER;
            } else {
                System.out.println("Invalid Pin. Must contain 3 digits");
                System.out.print("Enter 3 digit CVV  = ");
                this.PIN = kb.nextLine();

            }
        } while (PIN.length() > 0 || PIN.length() < 4);

        System.out.print("Enter Card Expiry Date = ");
        this.expiryDate = kb.nextLine();
        OUTER:
        while (true) {
            try {
                DateTimeFormatter ccMonthFormatter = DateTimeFormatter.ofPattern("MM/uu");

                YearMonth lastValidMonth = YearMonth.parse(expiryDate, ccMonthFormatter);
                break OUTER;
            } catch (DateTimeParseException dtpe) {
                System.out.println("Not a valid expiry date: " + "\nType Again");
                System.out.print("Enter Card Expiry Date = ");
                this.expiryDate = kb.nextLine();
            }

        }

    }

}
