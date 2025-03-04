package lab03;
/**
 *  Driver
 *
 *  Takes student orders for drinks and saves those drinks.
 *
 * @author:Michael Garcia
 * @version: 1.1
 */

/*
 * UML DIAGRAM:
 * -----------------------------------------------------------
 *  Main
 * -----------------------------------------------------------
 * + choice : int
 * + ounces : int
 * + brewTemp : int
 * + count : int
 * + name : String
 * + price : double
 * -----------------------------------------------------------
 * + printDrinks(drinks : CaffeinatedBeverage[], numDrinsk : int)
 * + findAveragePrice(drinks : CaffeinatedBeverage[], numDrinsk : int)
 * + findHighestPricedYerbaMate(drinks : CaffeinatedBeverage[], numDrinsk : int)
 * -----------------------------------------------------------
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CaffeinatedBeverage[] inventory = new CaffeinatedBeverage[10];
        Scanner keyboard = new Scanner(System.in);
        // Prompt user with options in a loop
        int choice, ounces, brewTemp, count = 0;
        String name;
        double price;

        do {
            System.out.println("1) Enter new Tea");
            System.out.println("2) Enter new Yerba Mate");
            System.out.println("3) Exit");
            System.out.print(">>");
            choice = keyboard.nextInt();
            keyboard.nextLine();

            switch (choice) {
                case 1://Tea
                case 2: //Yerb
                    System.out.print("Enter name      : ");
                    name = keyboard.nextLine();
                    System.out.print("Enter ounces    : ");
                    ounces = keyboard.nextInt();
                    System.out.print("Enter price     $ ");
                    price = keyboard.nextDouble();
                    System.out.print("Enter brew temperature (in Celsius): ");
                    brewTemp = keyboard.nextInt();

                    // Create a Tea, put into array
                    if (choice == 1) {
                        inventory[count] = new Tea(name, ounces, price, brewTemp);
                    } else if (choice == 2) {
                        inventory[count] = new YerbaMate(name, ounces, price, brewTemp);
                    }

                    System.out.println("Your tea order has been added: " + inventory[count]);
                    count++;
                    break;

            }

        } while (choice != 3);
        //Print Drinks
        System.out.println("\n All drinks:");
        Main.printDrinks(inventory, count);

        //Average price
        System.out.printf("\nAverage Price = $%.2f%n", Main.findAveragePrice(inventory, count));

        //PrintHighestprice
        YerbaMate mostExpensive = Main.findHighestPricedYerbaMate(inventory, count);
        if (mostExpensive != null) {
            System.out.printf("\nhighest priced mate = %s%n", mostExpensive);
        } else {
            System.out.println("No YerbaMate found in list.");
        }
        keyboard.close();
    }

    /**
     * printDrinks - Prints out each drink that is stored in the array.
     * @param drinks
     * @param numDrinks
     */
    public static void printDrinks(CaffeinatedBeverage[] drinks, int numDrinks) {
        for (int i = 0; i < numDrinks; i++) {
            System.out.println("Drink number: " + i + "=" + drinks[i]);
        }
    }

    /**
     * findAveragePrice - Adds the price of all drinks and divides them by the numDrinks.
     * @param drinks
     * @param numDrinks
     * @return average price
     */
    public static double findAveragePrice(CaffeinatedBeverage[] drinks, int numDrinks) {
        double totalPrice = 0;
        for (int i = 0; i < numDrinks; i++) {
            totalPrice += drinks[i].getPrice();
        }
        return totalPrice / numDrinks;
    }

    /**
     * findHighestPricedYerbaMate - goes through array to check for the highest price.
     * @param drinks
     * @param numDrinks
     * @return Highest Price.
     */
    public static YerbaMate findHighestPricedYerbaMate(CaffeinatedBeverage[] drinks, int numDrinks) {
        YerbaMate mate = new YerbaMate(), highestPrice = null;

        for (int i = 0; i < numDrinks; i++) {
            if (drinks[i].getClass() == mate.getClass()) {
                if (highestPrice == null) {
                    highestPrice = (YerbaMate) drinks[i];
                } else if (highestPrice.getPrice() < drinks[i].getPrice()) {
                    highestPrice = (YerbaMate) drinks[i];
                }
            }
        }
        return highestPrice;
    }

}