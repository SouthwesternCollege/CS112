package lab04;

public class Weapon {

    // Instance Variables
    private String name;
    private int damage;
    private int range;
    private int attackBonus;

    // Constant Variables

    public static final String DEFAULT_NAME = "default";
    public static final int DEFAULT_DAMAGE = 0;
    public static final int DEFAULT_RANGE = 0;
    public static final int DEFAULT_ATTACK_BONUS = 0;

    // Mutators/Setters

    /**
     *
     * Sets the name of this weapon.
     * @param name name of this weapon
     * @return {@code true} if {@code name} is valid and is set, {@code false} otherwise
     */

    public boolean setName(String name) {
        if (name != null) {
            this.name = name;
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * Sets the damage of this weapon.
     * @param damage damage of this weapon
     * @return {@code true} if {@code damage} is valid and is set, {@code false} otherwise
     */

    public boolean setDamage(int damage) {
        if (damage >= 0) {
            this.damage = damage;
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * Sets the range of this weapon.
     * @param range range of this weapon
     * @return {@code true} if {@code range} is valid and is set, {@code false} otherwise
     */

    public boolean setRange(int range) {
        if (range >= 0) {
            this.range = range;
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * Sets the attack bonus of this weapon.
     * @param attackBonus attack bonus of this weapon
     * @return {@code true} if {@code attackBonus} is valid and is set, {@code false} otherwise
     */

    public boolean setAttackBonus(int attackBonus) {
        if (attackBonus >= 0) {
            this.attackBonus = attackBonus;
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * Sets all instance variables with error checking.
     * @param name name of this name weapon
     * @param damage damage of this weapon
     * @param range range of this weapon
     * @param attackBonus attackBonus of this weapon
     * @return {@Code true} if all valid, {@code false} otherwise
     */

    public boolean setAll(String name, int damage, int range, int attackBonus) {
        boolean isValid;

        isValid = Weapon.isValidName(name) && Weapon.isValidDamage(damage) && Weapon.isValidRange(range)
                && Weapon.isValidAttackBonus(attackBonus);

        if (isValid) {
            this.name = name;
            this.damage = damage;
            this.range = range;
            this.attackBonus = attackBonus;

        }
        return isValid;

    }

    // Accessors/Getters

    /**
     *
     * Gets the name of this weapon.
     * @return the name of this weapon
     */

    public String getName() {
        return name;
    }

    /**
     *
     * Gets the damage of this weapon.
     * @return the damage of this weapon
     */

    public int getDamage() {
        return damage;
    }

    /**
     *
     * Gets the range of this weapon.
     * @return the range of this weapon
     */

    public int getRange() {
        return range;
    }

    /**
     *
     * Gets the attack bonus of this weapon.
     * @return the attack bonus of this weapon
     */

    public int getAttackBonus() {
        return attackBonus;
    }

    // Constructors

    /**
     *
     * Constructs a {@code Weapon} object with specified values.
     * @param name the name of this weapon
     * @param damage the damage of this weapon
     * @param range the range of this weapon
     * @param attackBonus the attack bonus of this weapon
     */

    public Weapon(String name, int damage, int range, int attackBonus) {
        this.name = name;
        this.damage = damage;
        this.range = range;
        this.attackBonus = attackBonus;
    }

    /**
     *
     * Constructs a {@code Weapon} object with default values.
     */

    public Weapon() {
        this(DEFAULT_NAME, DEFAULT_DAMAGE, DEFAULT_RANGE, DEFAULT_ATTACK_BONUS);
    }

    /**
     *
     * Copy constructor creates a deep copy of original Weapon object, if object null
     * outputs error message and exits program.
     * @param original Valid weapon object to deep copy
     */

    public Weapon(Weapon original) {
        if (original != null) {
            this.setAll(original.name, original.damage, original.range, original.attackBonus);
        } else {
            System.out.println("ERROR: trying to copy NULL Weapon object. Exiting program...");
            System.exit(0);
        }
    }

    // Valididty Methods

    /**
     *
     * Helper method to check name for validity.
     * @param name name to check for validity
     * @return {@code true} if valid, {@code false} otherwise
     */

    public static boolean isValidName(String name) {
        return name != null;
    }

    /**
     *
     * Helper method to check damage for validity.
     * @param damage damage to check for validity
     * @return {@code true} if valid, {@code false} otherwise
     */

    public static boolean isValidDamage(int damage) {
        return damage >= 0;
    }

    /**
     *
     * Helper method to check range for validity.
     * @param range range to check for validity
     * @return {@code true} if valid, {@code false} otherwise
     */

    public static boolean isValidRange(int range) {
        return range >= 0;
    }

    /**
     *
     * Helper method to check attack bonus for validity.
     * @param attackBonus attackBonus to check for validity
     * @return {@code true} if valid, {@code false} otherwise
     */

    public static boolean isValidAttackBonus(int attackBonus) {
        return attackBonus >= 0;
    }

    // Other required methods

    /**
     *
     * Checks whether this object is equal to another.
     * @param other the object to compare to
     * @return {@code true} if the objects are equal, {@code false} otherwise
     */

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (!(other instanceof Weapon)) {
            return false;
        } else {
            Weapon otherWeapon = (Weapon) other;
            return this.name.equals(otherWeapon.name) &&
                    this.damage == otherWeapon.damage &&
                    this.range == otherWeapon.range &&
                    this.attackBonus == otherWeapon.attackBonus;
        }
    }

    /**
     *
     * Returns a string representation of Weapon.
     * @return a formated String representing the Weapon object
     */

    @Override
    public String toString() {
        return String.format("\n" + this.name + "\nDamage: " + this.damage + "\nRange: " + this.range + "\nAttack Bonus: " + this.attackBonus + "\n");
        //return this.name + ", " + this.damage + ", " + this.range + ", " + this.attackBonus;
    }

}