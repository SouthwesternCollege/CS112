package lab03;
/**
 *  CaffeinatedBeverage Class
 *
 *  Class keeps data of caffienated bevaerages at coffee shop.
 *
 * @author:Michael Garcia
 * @version: 1.1
 */

/*
 * UML DIAGRAM:
 * -----------------------------------------------------------
 * Caffinated beverage
 * -----------------------------------------------------------
 * - name : String
 * - ounces : int
 * - price : double
 * + DEFAULT_NAME : String
 * + DEFAULT_OUNCES : int
 * + DEFAULT_PRICE : double
 * -----------------------------------------------------------
 * + CaffeiantedBeverage()
 * + CaffeinatedBeverage(name : string, ounces : int, price : double)
 * + CaffeinatedBeverage(other : CaffeinatedBeverage)
 * + getName()
 * + setName(name : String) : boolean
 * + getOunces()
 * + setOunces(ounces : int) : boolean
 * + getPrice()
 * + setPrice(price : double) : boolean
 * + setAll(name : String, ounces : int, price : double) : boolean
 * + equals (o : object) : Boolean
 *
 * -----------------------------------------------------------
 */

public class CaffeinatedBeverage
{
    //CONSTANT VARIBLES
    public static final String DEFAULT_NAME = "Caffeinated Beverage";
    public static final int DEFAULT_OUNCES = 0;
    public static final double DEFAULT_PRICE = 0.00;

    //INSTANCE VARIBLES
    private String name; // name of beverage
    private int ounces; // ounces in beverage
    private double price; // cost of beverage in USD

    /**
     * Default Constructor
     */
    public CaffeinatedBeverage() {
        this.name = DEFAULT_NAME;
        this.ounces = DEFAULT_OUNCES;
        this.price = DEFAULT_PRICE;
    }

    /**
     * Full Constructor
     * @param name
     * @param ounces
     * @param price
     */
    public CaffeinatedBeverage(String name, int ounces, double price) {
        this.setAll(name, ounces, price);
    }

    /**
     * Copy Constructor.
     * @param other
     */
    public CaffeinatedBeverage(CaffeinatedBeverage other) {
        this.setAll(other.getName(), other.getOunces(), other.getPrice());
    }

    /**
     * Get Name - returns name string.
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set name - Sets name string to Param
     * @param name
     */
    public boolean setName(String name) {
        if (name != null && name.length() > 0) {
            this.name = name;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get Ounces - Returns ounces int
     * @return
     */
    public int getOunces() {
        return this.ounces;
    }

    /**
     * setOunces - Sets ounces to param if >= 0
     * @param ounces
     * @return
     */
    public boolean setOunces(int ounces) {
        if (ounces >= 0){
            this.ounces = ounces;
            return true;
        } else {
            return false;
        }

    }

    /**
     * Get prices - Returns price double
     * @return
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Set Price - Sets price of beverage to param if >= 0
     * @param price
     * @return
     */
    public boolean setPrice(double price) {
        if (price >= 0) {
            this.price = price;
            return true;
        } else {
            return false;
        }
    }

    /**
     * setAll method : sets all params to the object is valid.
     * @param name
     * @param ounces
     * @param price
     * @return
     */
    public boolean setAll(String name, int ounces, double price) {
        return this.setName(name) && this.setOunces(ounces) && this.setPrice(price);

    }

    /**
     * equals method.
     * @param o
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass())
            return false;
        CaffeinatedBeverage that = (CaffeinatedBeverage) o;
        return this.ounces == that.ounces &&
                Double.compare(this.price, that.price) == 0 &&
                this.name.equals(that.name);
    }

    /**
     * To String - Creates a string for the Caffeinated beverage.
     */
    @Override
    public String toString() {
        return String.format("CaffeinatedBeverage: name = %s, %d fl. oz., $%.2f",
                this.name, this.ounces, this.price);
    }

    /**
     * sip - Removes an amount of oz from the beverage. If sipAmount exceeds oz then oz ounces will be left at 0.
     * @param sipAmount
     * @return
     */
    public boolean sip(int ounces) {
        if (this.ounces >= ounces) {
            this.ounces -= ounces;
        } else {
            this.ounces = 0;
        }
        return this.ounces > 0;
    }

    /**
     * isEmpty : checks to see if container is empty.
     * @return true if there are more ounces left
     */
    public boolean isEmpty() {
        return this.ounces == 0;
    }

}