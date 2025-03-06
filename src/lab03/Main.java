package lab03;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CaffeinatedBeverage[] inventory = new CaffeinatedBeverage[10];
        Scanner keyboard = new Scanner(System.in);
        // Prompt user with options in a loop
        int choice, ounces, brewTemp, count = 0;
        String name;
        double price;

        while (count < 10) {
            System.out.println("1) Enter new Tea");
            System.out.println("2) Enter new Yerba Mate");
            System.out.println("3) Exit");
            System.out.print(">>");
            choice = keyboard.nextInt();
            keyboard.nextLine();

            switch (choice) {
                case 1: // Tea
                    System.out.print("Enter name      : ");
                    name = keyboard.nextLine();
                    System.out.print("Enter ounces    : ");
                    ounces = keyboard.nextInt();
                    System.out.print("Enter price     $ ");
                    price = keyboard.nextDouble();
                    System.out.print("Enter brew temperature (in Celsius): ");
                    brewTemp = keyboard.nextInt();

                    // Create a Tea, put into array
                    inventory[count] = new Tea(name, ounces, price, brewTemp);

                    System.out.println("Your tea order has been added: " + inventory[count]);
                    count++;
                    break;

                case 2: // Yerba Mate
                    System.out.print("Enter name      : ");
                    name = keyboard.nextLine();
                    System.out.print("Enter ounces    : ");
                    ounces = keyboard.nextInt();
                    System.out.print("Enter price     $ ");
                    price = keyboard.nextDouble();
                    System.out.print("Enter brew temperature (in Celsius): ");
                    brewTemp = keyboard.nextInt();
                    System.out.print("Enter number of passes: ");
                    int numPasses = keyboard.nextInt();

                    inventory[count] = new YerbaMate(name, ounces, price, brewTemp, numPasses);

                    System.out.println("Your Yerba Mate has been added: " + inventory[count]);
                    count++;
                    break;

                case 3: //exit

                    for (CaffeinatedBeverage element : inventory) {
                        System.out.println(element.toString());
                        System.out.println("Average price: " + findAveragePrice(inventory) + "\nHighest Priced Yerba Mate: " + findHighestPricedYerbaMate(inventory));
                    }

            }
        }
    }

    public static double findAveragePrice(CaffeinatedBeverage[] inventory) {
        double total = 0;
        double numBevs = inventory.length;

        for (CaffeinatedBeverage element : inventory) {
            total += element.getPrice();
        }
        return total / numBevs;
    }

    public static YerbaMate findHighestPricedYerbaMate(CaffeinatedBeverage[] inventory) {
        YerbaMate highestPriced = new YerbaMate();

        for (CaffeinatedBeverage element : inventory) {
            if (element.getPrice() > highestPriced.getPrice() && element instanceof YerbaMate) {
                highestPriced = (YerbaMate) element;
            }
        }
        return highestPriced;
    }

}