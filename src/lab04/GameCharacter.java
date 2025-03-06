package lab04;

abstract class GameCharacter {

    // Instance Variables
    private String name;
    private String characterClass;
    private String alignment;
    private int expPoints;
    private int hitPoints;
    private int armorClass;
    private Weapon weapon1;
    private Weapon weapon2;

    // Constant Variables

    public static final String DEFAULT_NAME = "default";
    public static final String DEFUALT_CHARACTER_CLASS = "Ranger";
    public static final String DEFAULT_ALIGNMENT = "lawful good";
    public static final int DEFAULT_EXP_POINTS = 0;
    public static final int DEFUALT_HIT_POINTS = 0;
    public static final int DEFAULT_ARMOR_CLASS = 0;
    public static final Weapon DEFAULT_WEAPON_1 = new Weapon();
    public static final Weapon DEFAULT_WEAPON_2 = new Weapon();


    // Mutators/Setters

    /**
     *
     * Sets name of this {@code GameCharacter}.
     * @param name name of {@code GameCharacter}
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
     * Sets the character class of this {@code GameCharacter}.
     * @param characterClass character class of {@code GameCharacter}
     * @return {@code true} if {@code characterClass} is valid and is set, {@code false} otherwise
     */

    public boolean setCharacterClass(String characterClass) {
        if (characterClass != null) {
            this.characterClass = characterClass;
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * Sets the alignment for this {@code GameCharacter}.
     * @param alignment alignment of {@code GameCharacter}
     * @return {@code true} if {@code alignment} is valid and is set, {@code false} otherwise
     */

    public boolean setAlignment(String alignment) {
        if (alignment != null) {
            this.alignment = alignment;
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * Sets the {@code expPoints} for this {@code GameCharacter}.
     * @param expPoints exp points of {@code GameCharacter}
     * @return {@code true} if {@code expPoints} is valid and is set, {@code false} otherwise
     */

    public boolean setExpPoints(int expPoints) {
        if (expPoints >= 0) {
            this.expPoints = expPoints;
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * Sets the {@code hitPoints} for this {@code GameCharacter}.
     * @param hitPoints hit points of {@code GameCharacter}
     * @return {@code true} if {@code hitPoints} is valid and is set, {@code false} otherwise
     */

    public boolean setHitPoints(int hitPoints) {
        if (hitPoints >= 0) {
            this.hitPoints = hitPoints;
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * Sets the {@code armorClass} for this {@code GameCharacter}.
     * <p>
     * Armor Class Breakdown<br></br>
     * <strong>0 - no armor</strong><br></br>
     * <strong>1 - light armor</strong><br></br>
     * <strong>2 - medium armor</strong><br></br>
     * <strong>3 - heavy armor</strong><br></br>
     * </p>
     * @param armorClass armor class of {@code GameCharacter}
     * @return {@code true} if {@code armorClass} is valid and is set, {@code false} otherwise
     */

    public boolean setArmorClass(int armorClass) {
        if (armorClass >= 0) {
            this.armorClass = armorClass;
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * Sets the {@code weapon1} for this {@code GameCharacter}
     * @param weapon weapon 1 of {@code GameCharacter}
     * @return {@code true} always becuase weapons can be null
     */

    public boolean setWeapon1(Weapon weapon) {
        weapon1 = new Weapon(weapon);
        return true;
    }

    /**
     *
     * Sets the {@code weapon2} for this {@code GameCharacter}
     * @param weapon weapon 2 of {@code GameCharacter}
     * @return {@code true} always becuase weapons can be null
     */

    public boolean setWeapon2(Weapon weapon) {
        weapon2 = new Weapon(weapon);
        return true;
    }

    /**
     *
     * Sets all fields of this {@code GameCharacter}
     * @param name name of {@code GameCharacter}
     * @param characterClass character class of {@code GameCharacter}
     * @param alignment alignment of {@code GameCharacter}
     * @param expPoints exp points of {@code GameCharacter}
     * @param hitPoints hit points of {@code GameCharacter}
     * @param armorClass armor class of {@code GameCharacter}
     * @param weapon1 weapon 1 of {@code GameCharacter}
     * @param weapon2 weapon 2 of {@code GameCharacter}
     * @return {@code true} if all fields were successfully set, {@code false} otherwise
     */

    public boolean setAll(String name, String characterClass, String alignment, int expPoints, int hitPoints, int armorClass, Weapon weapon1, Weapon weapon2) {
        return this.setName(name) && this.setCharacterClass(characterClass) && this.setAlignment(alignment)
                && this.setExpPoints(expPoints) && this.setHitPoints(hitPoints) && this.setArmorClass(armorClass)
                && this.setWeapon1(weapon1) && this.setWeapon2(weapon2);
    }

    // Accessors/Getters

    /**
     * Gets {@code GameCharacter} name.
     *
     * @return {@code GameCharacter} name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets {@code GameCharacter} class.
     *
     * @return {@code GameCharacter} class
     */
    public String getCharacterClass() {
        return characterClass;
    }

    /**
     * Gets {@code GameCharacter} alignment.
     *
     * @return {@code GameCharacter} alignment
     */
    public String getAlignment() {
        return alignment;
    }

    /**
     * Gets {@code GameCharacter} experience points.
     *
     * @return {@code GameCharacter} experience points
     */
    public int getExpPoints() {
        return expPoints;
    }

    /**
     * Gets {@code GameCharacter} hit points.
     *
     * @return {@code GameCharacter} hit points
     */
    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * Gets {@code GameCharacter} armor class.
     *
     * @return {@code GameCharacter} armor class
     */
    public int getArmorClass() {
        return armorClass;
    }

    /**
     * Gets {@code GameCharacter} first weapon.
     *
     * @return {@code GameCharacter} first weapon, or {@code null} if none is equipped
     */
    public Weapon getWeapon1() {
        return weapon1;
    }

    /**
     * Gets {@code GameCharacter} second weapon.
     *
     * @return {@code GameCharacter} second weapon, or {@code null} if none is equipped
     */
    public Weapon getWeapon2() {
        return weapon2;
    }


    // Constructors

    /**
     *
     * Constructs a {@code GameCharacter} object with the specified feilds.
     * @param name name of {@code GameCharacter}
     * @param characterClass character class of {@code GameCharacter}
     * @param alignment alignment of {@code GameCharacter}
     * @param expPoints exp points of {@code GameCharacter}
     * @param hitPoints hit points of {@code GameCharacter}
     * @param armorClass armor class of {@code GameCharacter}
     * @param weapon1 weapon 1 of {@code GameCharacter}
     * @param weapon2 weapon 2 of {@code GameCharacter}
     */

    public GameCharacter(String name, String characterClass, String alignment, int expPoints, int hitPoints, int armorClass, Weapon weapon1, Weapon weapon2) {
        if (!this.setAll(name, characterClass, alignment, expPoints, hitPoints, armorClass, weapon1, weapon2)) {
            System.out.println("ERROR: bad data given to full constructor");
            System.exit(0);
        }
    }

    /**
     * Constructs a {@code GameCharacter} object with default values.
     */

    public GameCharacter() {
        this(DEFAULT_NAME, DEFUALT_CHARACTER_CLASS, DEFAULT_ALIGNMENT, DEFAULT_EXP_POINTS, DEFUALT_HIT_POINTS,
                DEFAULT_ARMOR_CLASS, DEFAULT_WEAPON_1, DEFAULT_WEAPON_2);
    }

    /**
     * Copy constructor. Creates a new {@code GameCharacter} object that is a copy of the given object.
     * @param original the original {@code GameCharacter} object to copy
     */

    public GameCharacter(GameCharacter original) {
        if (original != null) {
            this.setAll(original.name, original.characterClass, original.alignment, original.expPoints,
                    original.hitPoints, original.armorClass, original.weapon1, original.weapon2);
        } else {
            System.out.println("ERROR: trying to copy NULL Weapon object. Exiting program...");
            System.exit(0);
        }
    }

    // Other Required Methods

    /**
     * Returns a formated string representing {@code GameCharacter}.
     * @return a formatted string describing the {@code GameCharacter}
     */

    @Override
    public String toString() {
        return String.format("Character Sheet:\n\n" + "Name: " + this.name + "\nClass: " + this.characterClass + "\nAlignment: " + this.alignment + "\nEXP: " + this.expPoints + "\nHP: " + hitPoints + "\nArmor Class: " + this.armorClass + "\n\nWeapons:\n" + this.weapon1 + this.weapon2);
        //return this.name + ", " + this.characterClass + ", " + this.alignment + ", " + this.expPoints + ", " + this.hitPoints + ", " + this.armorClass + ", " + this.weapon1 + ", " + this.weapon2;
    }

    /**
     * Checks whether this object is equal to another object.
     *
     * @param other the object to compare to
     * @return {@code true} if the objects are equal, {@code false} otherwise
     */

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (!(other instanceof GameCharacter)) {
            return false;
        } else {
            GameCharacter otherGameCharacter = (GameCharacter) other;
            return this.name.equals(otherGameCharacter.name) &&
                    this.characterClass.equals(otherGameCharacter.characterClass) &&
                    this.alignment.equals(otherGameCharacter.alignment) &&
                    this.expPoints == otherGameCharacter.expPoints &&
                    this.hitPoints == otherGameCharacter.hitPoints &&
                    this.armorClass == otherGameCharacter.armorClass &&
                    this.weapon1 == otherGameCharacter.weapon1 &&
                    this.weapon2 == otherGameCharacter.weapon2;
        }
    }

    // Abstract methods

    /**
     * Assists the specified {@code GameCharacter}.
     *
     * This method represents an action that provides aid or support to another
     * {@code GameCharacter}, such as healing or boosting attributes.
     *
     * @param character the {@code GameCharacter} to assist
     */

    public abstract void assist(GameCharacter character);

    /**
     *
     * Attacks the specified {@code GameCharacter}.
     *
     * This method represents an action where the current {@code GameCharacter}
     * attacks another {@code GameCharacter}, potentially reducing their hit points.
     *
     * @param character the {@code GameCharacter} being attacked
     * @return {@code true} if the attacked {@code GameCharacter} is still alive
     *         after the attack; {@code false} otherwise
     */

    public abstract boolean attack(GameCharacter character);


}