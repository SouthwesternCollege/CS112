package ud0;


/*
 * UML CLASS DIAGRAM:
 * -------------------------------------------------------
 *   Card
 * -------------------------------------------------------
 * - value : int
 * - suit : char
 * + HEART : char			//static constant with value ♥
 * + DIAMOND : char			//static constant with value ♦
 * + CLUB : char			//static constant with value ♣
 * + SPADE : char			//static constant with value ♠
 * + DEFAULT_VALUE : int	//static constant with value 1
 * + DEFAULT_SUIT : char	//static constant with value ♥
 * -------------------------------------------------------
 * + Card()
 * + Card(value : int, suit : char)
 * + Card(original : Card)
 * + setValue(value : int) : boolean
 * + setSuit(suit : char) : boolean
 * + setAll(value : int, suit : char) : boolean
 * + getSuit() : char
 * + getValue() : int
 * + getPrintValue() : String
 * + getPrintCard() : String
 * + toString() : String
 * + equals(otherCard : Card) : boolean
 * + printCard() : void
 * -------------------------------------------------------
 */

public class Card {

    /*** CONSTANT VARIABLES ***/

    public static final char HEART = '♥';
    public static final char DIAMOND = '♦';
    public static final char CLUB = '♣';
    public static final char SPADE = '♠';

    public static final int DEFAULT_VALUE = 1;
    public static final char DEFAULT_SUIT = Card.HEART;

    /*** INSTANCE VARIABLES ***/
    private int value;
    private char suit;

    /*** CONSTRUCTOR METHODS ***/
    /**
     * Default constructor, builds defualt card object as: A ♥
     * @param value
     * @param suit
     */

    public Card() {
        this(DEFAULT_VALUE, DEFAULT_SUIT);
    }

    /**
     * Full constructor builds object with all data for instance variables provided.
     * If arguments are not valid, program shuts down with error message
     *
     * @param value numerical value of card (1-13), not what shows on card (A, 2-10,
     *              J, Q, K)
     * @param suit  one of four suit values (unicode value for heart, diamond,
     *              spade, or club)
     */
    public Card(int value, char suit) {
        if (!this.setAll(value, suit)) {
            System.out.println("ERROR: bad data given to full constructor. Shutting down...");
            System.exit(0);
        }
    }

    /**
     * Copy constructor builds object with all data from Card object provided. No
     * changes made to original object, no shallow copying
     *
     * @param value numerical value of card (1-13), not what shows on card (A, 2-10,
     *              J, Q, K)
     * @param suit  one of four suit values (unicode value for heart, diamond,
     *              spade, or club)
     */
    public Card(Card original) {
        if (original != null) {
            this.setAll(original.value, original.suit);
        } else {
            System.out.println("ERROR: bad data given to full constructor. Shutting down...");
            System.exit(0);
        }
    }

    /*** MUTATOR METHODS (SETTERS) ***/
    /**
     * Sets value for card only if valid, otherwise will not change instance
     * variable. Returns boolean representing whether error occured (false) or
     * operation completed successfully (true)
     *
     * @param value numerical value of card (1-13), not what shows on card (A, 2-10,
     *              J, Q, K)
     *
     * @return true if card value is between 1 and 13 (inclusive), false otherwise
     */

    public boolean setValue(int value) {
        boolean isValid = value >= 1 && value <= 13;

        if (isValid) {
            this.value = value;
        }
        return isValid;
    }



    /**
     * Sets suit for card only if valid, otherwise will not change instance
     * variable. Returns boolean representing whether error occured (false) or
     * operation completed successfully (true)
     *
     * @param suit one of four suit values (unicode value for heart, diamond, spade,
     *             or club)
     *
     * @return true if card suit is unicode value for heart, diamond, club or spade.
     *         false otherwise
     */
    public boolean setSuit(char suit) {
        boolean isValid;
        isValid = suit == Card.HEART || suit == Card.DIAMOND || suit == Card.CLUB || suit == Card.SPADE;

        if (isValid) {
            this.suit = suit;
        }
        return isValid;
    }

    /**
     * Sets suit and value for card only if valid, returns boolean representing
     * whether error occured (false) or operation completed successfully (true)
     *
     * @param suit  one of four suit values (unicode value for heart, diamond,
     *              spade, or club)
     * @param value numerical value of card (1-13), not what shows on card (A, 2-10,
     *              J, Q, K)
     *
     * @return true if card suit AND value are valid, false otherwise
     */
    public boolean setAll(int value, char suit) {
        if (!this.setValue(value)) {
            return false;
        } else if(!this.setSuit(suit)) {
            return false;
        } else {
            return true;
        }
    }

    /*** ACCESSOR METHODS (GETTERS) ***/
    /**
     * Access unicode character representing suit of card
     *
     * @return suit as unicode character for heart, spade, diamond, or club
     */
    public char getSuit() {
        return this.suit;
    }

    /**
     * Access numerical value of card (1-13)
     *
     * @return value as raw integer 1-13 (not what player sees as A, 2-10, J, Q, K;
     *         see {@link #getPrintValue()})
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Access value of card as seen by user (A, 2-10, J, Q, K) that would be printed
     * on card
     *
     * @return value as String user sees on card (A, 2-10, J, Q, K), not numerical
     *         value 1-13 (see {@link #getValue()})
     */
    public String getPrintValue() {
        switch (this.value) {
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return "" + this.value;
        }
    }

    /**
     * Access ASCII art version of card data, each line separated by newline
     * character, no newline character at end of String
     *
     * @return String containing ASCII art with card suit and card print value
     */


    /*** OTHER REQUIRED METHODS ***/
    /**
     * String of all instance variables, no newline character at end of String.
     * Using print value to use as "condensed" version of printed card (ex: A ♥)
     *
     * @return String containing (print) value and suit, separated by a space
     */
    public String toString() {
        return this.value + " " + this.suit;
    }

    /**
     * Checking for equality of Card objects, all instance variables exactly equal
     * to each other (case-sensitive). Argument object not changed
     *
     * @param other Card object to compare for equality
     *
     * @return boolean representing equality between both objects, all data is
     *         exactly equal to each other
     */
    public boolean equals(Card otherCard) {
        if (otherCard == null) {
            return false;
        } else {
            return this.value == otherCard.value && this.suit == otherCard.suit;
        }
    }
    /*** EXTRA METHODS ***/
    /**
     * Prints card ASCII art to console (see {@link #getPrintCard()})
     */


}