package lab03;
public class Tea extends CaffeinatedBeverage {

    /**INSTANCE VARIABLES**/
    private int brewTemp;

    /**CONSTANTS**/

    private final int DEFAULT_BREWTEMP = 0;

    /**CONSTRUCTORS**/

    /*Default constructor - uses super to get default CaffeinatedBeverage values and uses default brew temp */
    public Tea() {
        super();
        this.brewTemp = DEFAULT_BREWTEMP;
    }

    /* Full constructor - takes String name, int ounces, double price (dollars), and int brewTemp (celsius). Checks that brewTemp is valid data (0 < brewTemp <= 100) */
    public Tea(String name, int ounces, double price, int brewTemp) {
        super(name, ounces, price);
        if (brewTemp > 0 && brewTemp <= 100) {
            this.brewTemp = brewTemp;
        }
        else {
            System.out.println("Invalid data. Shutting down program...");
            System.exit(0);
        }
    }

    /*Copy constructor - uses CaffeinatedBeverage setAll() method to access instance variables and sets brewTemp to a given value */
    public Tea(Tea other) {
        super(other);
        this.brewTemp = other.brewTemp;
    }

    /**GETTER(S)**/
    /*getBrewTemp - returns brewTemp instance variable of a Tea object */

    public int getBrewTemp() {
        return this.brewTemp;
    }

    /***SETTER(S)***/
    /*setBrewwTemp - takes int as parameter and sets brewTemp equal to this parameter as long as it is greater than 0 (freezing point) and less than or equal to 100 (boiling point). Otherwise, exits with error message.*/
    public boolean setBrewTemp(int newBrewTemp) {
        if (newBrewTemp >= 0 ) {
            this.brewTemp = newBrewTemp;
            return true;
        }
        else {
            System.out.println("Invalid data.");
            return false;
        }
    }

    /***OTHER METHODS***/
    /*toString - outputs Tea values in String format */

    @Override
    public String toString() {
        return "Tea: " + this.getName() + ", " + this.getOunces() + " ounces, brewed at " + brewTemp
                + " degrees Celsius, $" + this.getPrice();
    }

    /*Equals - checks that other object is an instance of Tea, is not null, and that all instance variables are equal */
    @Override
    public boolean equals(Object other) {
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        Tea that = (Tea) other;
        return (this.getOunces() == that.getOunces() && Double.compare(this.getPrice(), that.getPrice()) == 0
                && this.getName().equals(that.getName()) && this.brewTemp == that.brewTemp);
    }
}