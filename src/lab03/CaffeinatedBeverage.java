package lab03;
public class CaffeinatedBeverage
{
    /***INSTANCE VARIABLES***/
    private String name;
    private int ounces;
    private double price;

    /***CONSTANTS***/

    private final String DEFAULT_NAME = "Black Coffee";
    private final int DEFAULT_OUNCES = 0;
    private final double DEFAULT_PRICE = 0.00;

    /***CONSTRUCTORS***/

    /* Default constructor - initializes as Black Coffee, 8 oz, $5.00 */
    public CaffeinatedBeverage() {
        this.name = DEFAULT_NAME;
        this.ounces = DEFAULT_OUNCES;
        this.price = DEFAULT_PRICE;
    }

    /*Full Constructor - takes String, int, double as parameters. Checks that price and ounces are greater than or equal to 0.*/
    public CaffeinatedBeverage(String name, int ounces, double price) {
        this.name = name;
        if (ounces >= 0 && price >= 0) {
            this.ounces = ounces;
            this.price = price;
        }
        else {
            System.out.println("Bad data entered. Shutting down program...");
            System.exit(0);
        }
    }

    /*Copy Constructor- takes CaffeinatedBeverage as parameter*/
    public CaffeinatedBeverage(CaffeinatedBeverage other) {
        this.name = other.getName();
        this.ounces = other.getOunces();
        this.price = other.getPrice();
    }

    /***SETTERS***/

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOunces(int ounces) {
        this.ounces = ounces;
    }

    public boolean setAll(String name, int ounces, double price) {
        if (ounces >= 0 && price >= 0 && name != null) {
            this.ounces = ounces;
            this.price = price;
            this.name = name;
            return true;
        }
        else {
            System.out.println("Bad data entered.");
            return false;
        }
    }

    /***GETTERS***/

    public double getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public int getOunces() {
        return this.ounces;
    }

    /***OTHER ESSENTIAL METHODS***/

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass())
            return false;
        CaffeinatedBeverage that = (CaffeinatedBeverage) o;
        return this.ounces == that.ounces &&
                Double.compare(this.price, that.price) == 0 && this.name.equals(that.name);
    }

    @Override
    public String toString() {
        return "Caffeinated Beverage: " + this.name + ", " + this.ounces + " ounces, $" + this.price;
    }

    public boolean sip(int ouncesSipped) {
        int remaining = this.ounces - ouncesSipped;
        if (remaining > 0) {
            this.ounces -= ouncesSipped;
            return true;
        } else {
            this.ounces = 0;
            return false;
        }
    }

    public boolean isEmpty() {
        if (this.ounces > 0) {
            return false;
        }
        else {
            return true;
        }
    }
}