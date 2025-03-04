package lab03;
/**
 * Represents a tea beverage, extending CaffeinatedBeverage.
 * Includes additional properties for brewing temperature.
 *
 * @author Charles Fator
 * @version 1.0
 *
 */
public class Tea extends CaffeinatedBeverage {
    private int brewTemp;

    public static final int DEFAULT_BREW_TEMP = 100;

    /**
     * Constructs a new Tea with the specified attributes.
     *
     * @param name     the name of the tea
     * @param ounces   the number of ounces in the tea (must be >= 0)
     * @param price    the price of the tea (must be >= 0)
     * @param brewTemp the brew temperature in Celsius (must be >= 0)
     */
    public Tea(String name, int ounces, double price, int brewTemp) {
        super(name, ounces, price);
        if (brewTemp < 0) {
            throw new IllegalArgumentException("Brew temperature must be non-negative.");
        }
        this.brewTemp = brewTemp;
    }

    /**
     * Constructs a new Tea with default values.
     */

    public Tea() {
        this(DEFAULT_NAME, 12, DEFAULT_PRICE, DEFAULT_BREW_TEMP);
    }

    /**
     * Copy Constructer. Creates a new Tea object that is a copy of the given object.
     *
     * @param original the original Tea object to copy
     */

    public Tea(Tea original) {
        if (original != null) {
            this.setAll(original.getName(), original.getOunces(), original.getPrice(), original.getBrewTemp());
        } else {
            System.out.println("ERROR: trying to copy NULL Weapon object. Exiting program...");
            System.exit(0);
        }

    }

    /**
     * Gets the brew temperature of the tea.
     *
     * @return the brew temperature in Celsius
     */
    public int getBrewTemp() {
        return brewTemp;
    }

    /**
     * Sets the brew temperature of the tea.
     *
     * @param brewTemp the new brew temperature in Celsius (must be >= 0)
     * @return {@code true} if brew temp is valid and set, {@code false} otherwise
     */
    public boolean setBrewTemp(int brewTemp) {
        if (brewTemp >= 0) {
            this.brewTemp = brewTemp;
            return true;
        } else {
            return false;
        }

    }

    /**
     * Sets all fields of this CaffeinatedBeverage.
     * @param name name of beverage
     * @param ounces ounces for beverage
     * @param price price of beverage
     * @param brewTemp brew temp of beverage
     * @return {@code true} if all fields were successfully set, {@code false} otherwise
     */

    public boolean setAll(String name, int ounces, double price, int brewTemp) {
        return this.setName(name) && this.setOunces(ounces) && this.setPrice(price) && this.setBrewTemp(brewTemp);
    }

    /**
     *
     * Checks whether this object is equal to another object.
     *
     * @param o the object to compare to
     * @return {@code true} if the objects are equal, {@code false} otherwise
     */

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Tea tea = (Tea) o;
        return this.brewTemp == tea.brewTemp;
    }

    /**
     * Returns a formated string representing a Tea.
     * @return string representing Tea
     */

    @Override
    public String toString() {
        return String.format("Tea: %s, brewed @ %d°C", super.toString(), brewTemp);
    }
}