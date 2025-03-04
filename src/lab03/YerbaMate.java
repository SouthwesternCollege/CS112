package lab03;
/**
 *  YerbaMate Class extends Tea
 *
 *  Stores data for YerbaMate.
 *
 * @author:Michael Garcia
 * @version: 1.1
 */

/*
 * UML DIAGRAM:
 * -----------------------------------------------------------
 * YerbaMate
 * -----------------------------------------------------------
 * - numPasses : int
 * -----------------------------------------------------------
 * + YerbaMate()
 * + YerbaMate(name : string, ounces : int, price : double, brewTemp : int, numPasses : int)
 * + YerbaMate(name : string, ounces : int, price : double, brewTemp : int)
 * + YerbaMate(other : YerbaMate)
 * + setNumPasses(numPasses : int)
 * + getNumPasses()
 * + passMate()
 * + refill(ounces : int)
 * + equals (o : object) : Boolean
 * + toString()
 * -----------------------------------------------------------
 */
public class YerbaMate extends Tea {

    //INSTANCE VARIABLES
    private int numPasses;

    /**
     * Default constructor
     */
    public YerbaMate() {
        super();
        this.numPasses = 1;
    }

    /**
     * Full Constructor
     * @param name
     * @param ounces
     * @param price
     * @param brewTemp
     * @param numPasses
     */
    public YerbaMate(String name, int ounces, double price, int brewTemp, int numPasses) {
        super(name, ounces, price, brewTemp);
        this.setNumPasses(numPasses);
    }

    /**
     * OverLoaded Constructor
     * @param name
     * @param ounces
     * @param price
     * @param brewTemp
     */
    public YerbaMate(String name, int ounces, double price, int brewTemp) {
        super(name, ounces, price, brewTemp);
        this.setNumPasses(0); //Default value
    }

    /**
     * Copy Constructor
     * @param other
     */
    public YerbaMate(YerbaMate other) {
        super(other.getName(), other.getOunces(), other.getPrice(), other.getBrewTemp());
        this.setNumPasses(numPasses);
    }

    /**
     * Setter for numPasses
     * @param numPasses
     * @return
     */
    public boolean setNumPasses(int numPasses) {
        if(numPasses >= 0){
            this.numPasses = numPasses;
            return true;
        }else{
            return false;
        }
    }

    /**
     * Getter for numPasses
     * @return
     */
    public int getNumPasses() {
        return numPasses;
    }

    /**
     * passMate
     * Increments by 1 for each time the mate gets passed.
     * prints a statment keeping track of times passed.
     */
    public void passMate() {
        this.numPasses++;
        System.out.printf("The mate has passed! There are currently %d passes.", this.numPasses);
    }

    /**
     * Refill
     * Refills the mate a certain amount of ounces
     * @param ounces
     */
    public void refill(int ounces) {
        if (ounces > 0) {
            this.setOunces(this.getOunces() + ounces);
        }
    }

    /**
     * ToString
     * @returns a String
     */
    @Override
    public String toString() {
        String teaString = super.toString();
        int colonlocation = teaString.indexOf(":");
        teaString = teaString.substring(colonlocation + 2);

        return String.format("YerbaMate: %s, %d passes so far", teaString, this.numPasses);
    }

    /**
     * Equals method
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        YerbaMate yerbaMate = (YerbaMate) o;
        return numPasses == yerbaMate.numPasses;
    }
}