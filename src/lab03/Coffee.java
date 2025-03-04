package lab03;
public class Coffee extends CaffeinatedBeverage {

    // CONSTANT VARIABLES
    public static final String DEFAULT_BREW_TYPE = "Pour-over";

    //INSTANCE VARIABLES
    private String brewType;

    //CONSTRUCTORS

    public Coffee(String name, int ounces, double price, String brewType) {
        super(name, ounces, price);
        if (!this.setBrewType(brewType)) {
            System.out.println("ERROR: Bad data given to full Coffee constructor.");
            System.exit(0);
        }
    }

    /*
     * Default constructor
     */
    public Coffee() {
        super();
        this.setBrewType(DEFAULT_BREW_TYPE);
    }

    /*
     * copy constructor
     */
    public Coffee(Coffee original) {
        if (original != null) {
            this.setAll(original.getName(), original.getOunces(), original.getPrice(), original.brewType);
        } else {
            System.out.println("ERROR: null data given to copy Coffee constructor.");
            System.exit(0);
        }
    }

    // SETTERS/MUTATORS

    public boolean setBrewType(String brewType) {
        if (brewType != null || brewType.length() > 0) {
            this.brewType = brewType;
            return true;
        } else {
            return false;
        }
    }

    public boolean setAll(String name, int ounces, double price, String brewType) {
        return super.setAll(name, ounces, price) && this.setBrewType(brewType);
    }

    //Getters/Accessors
    public String getBrewType() {
        return this.brewType;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        Coffee otherCoffee = (Coffee) other;
        return super.equals(otherCoffee) && this.brewType.equals(otherCoffee.brewType);
    }

    @Override
    public String toString() {
        String caffeineString = super.toString();
        int colonLocation = caffeineString.indexOf(":");
        caffeineString = caffeineString.substring(colonLocation + 2);

        return String.format("Coffee: %s, brewed by %s method", caffeineString, this.brewType);
    }

}