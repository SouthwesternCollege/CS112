package lab03;
public class YerbaMate extends Tea {

    /***INSTANCE VARIABLES***/
    private int numPasses;
    /*represents number of people who have drank from the same gourd when sharing a Mate in accordance with traditional customs */

    /***CONSTANT(S)***/
    private final int DEFAULT_NUMPASSES = 0;

    /***CONSTRUCTORS***/

    /*Full constructor - takes naame, ounces, price, brewTemp, and numPasses and checks numPasses for validity */
    public YerbaMate(String name, int ounces, double price, int brewTemp, int numPasses) {
        super(name, ounces, price, brewTemp);
        if (numPasses >= 0) {
            this.numPasses = numPasses;
        }
        else {
            System.out.println("Error: invalid numPasses value given. Shutting down program...");
            System.exit(0);
        }
    }

    /*Default constructor - creates YerbaMate object with all values set to defaults*/
    public YerbaMate() {
        super();
        this.numPasses = DEFAULT_NUMPASSES;
    }

    /*Copy constructor - uses other YerbaMate object for parameters and copies it.*/
    public YerbaMate(YerbaMate other) {
        super(other);
        this.numPasses = other.numPasses;
    }

    /***OTHER METHODS***/

    /*refill - takes input for number of ounces and adds it to the amount of ounces in the Yerba Mate already */
    public void refill(int ouncesAdded) {
        this.setOunces(this.getOunces() + ouncesAdded);
    }

    /*passMate - Increments numPasses and prints a notification that the mate was passes, along with the current pass count. */
    public void passMate() {
        this.numPasses += 1;
        System.out.println("Mate was passed. " + numPasses + " passes so far.");
    }

    /*getNumPasses - returns number of passes so far */
    public int getNumPasses() {
        return this.numPasses;
    }

    /*toString - returns a string detailing all values of the Yerba Mate */
    @Override
    public String toString() {
        return "Yerba Mate: " + this.getName() + ", " + this.getOunces() + " ounces, brewed at " + this.getBrewTemp()
                + " degrees Celsius, $" + this.getPrice() + ", " + this.numPasses + " passes so far.";
    }

    /**equals - returns true if object is an instance of Yerba Mate with the same values for all instance variables as the comparison. */
    @Override
    public boolean equals(Object other) {
        if (other == null || other.getClass() != this.getClass()) {
            return false;
        }
        YerbaMate that = (YerbaMate) other;
        return (this.getName() == that.getName() && this.getOunces() == that.getOunces()
                && this.getPrice() == that.getPrice() && this.getBrewTemp() == that.getBrewTemp()
                && this.numPasses == that.numPasses);
    }
}