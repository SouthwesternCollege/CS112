package lab04;
public class Dwarf extends GameCharacter {

    /**
     * Provides assistance to a specified character by improving their Armor Class (AC).
     * The method increases the target character's AC by 1 if their current AC is between 0 and 3 (inclusive).
     * This can be used to simulate a supportive action like enhancing the character's defense.
     *
     * <p>If the character's current AC is 0, 1, 2, or 3, the AC will be incremented by 1.
     * If the character's AC is already 4 or higher, no change will occur.</p>
     *
     * @param character The character to be assisted. Their AC will be increased by 1 if it is between 0 and 3.
     */

    public void assist(GameCharacter character) {
        int currentAC = character.getArmorClass();

        if (character.getArmorClass() == 0) {
            currentAC += 1;
            character.setArmorClass(currentAC);
        } else if (character.getArmorClass() == 1) {
            currentAC += 1;
            character.setArmorClass(currentAC);
        } else if (character.getArmorClass() == 2) {
            currentAC += 1;
            character.setArmorClass(currentAC);
        } else if (character.getArmorClass() == 3) {
            currentAC += 1;
            character.setArmorClass(currentAC);
        }
    }

    /**
     * Simulates an attack on a specified character. The attack's success is determined
     * by rolling a 20-sided die (d20) and comparing the result to the character's Armor Class (AC).
     * The damage dealt to the character depends on both the attack roll and the character's AC.
     *
     * <p>If the roll is between 11 and 20, the character takes 2 to 7 damage based on their AC.
     * If the roll is between 2 and 10, the character takes 1 to 4 damage based on their AC.
     * If the roll is 1, the attack misses, and no damage is dealt.</p>
     *
     * @param character The character being attacked.
     * @return A boolean indicating the success of the attack. Returns {@code true} if the attack
     *         is successful (i.e., the attack deals damage), and {@code false} if the attack fails (i.e.,
     *         no damage is dealt).
     */

    public boolean attack(GameCharacter character) {
        boolean successful = true;
        int roll = (int) (Math.random() * 20) + 1;
        int currentHP = character.getHitPoints();
        int currentAC = character.getArmorClass();

        if (roll <= 20 && roll > 10) {
            if (currentAC == 0) {
                currentHP -= 7;
                character.setHitPoints(currentHP);
            } else if (currentAC == 1) {
                currentHP -= 6;
                character.setHitPoints(currentHP);
            } else if (currentAC == 2) {
                currentHP -= 4;
                character.setHitPoints(currentHP);
            } else if (currentAC == 3) {
                currentHP -= 4;
                character.setHitPoints(currentHP);
            } else if (currentAC == 4) {
                currentHP -= 2;
                character.setHitPoints(currentHP);
            }
            successful = true;
        } else if (roll <= 10 && roll > 1) {
            if (currentAC == 0) {
                currentHP -= 4;
                character.setHitPoints(currentHP);
            } else if (currentAC == 1) {
                currentHP -= 4;
                character.setHitPoints(currentHP);
            } else if (currentAC == 2) {
                currentHP -= 2;
                character.setHitPoints(currentHP);
            } else if (currentAC == 3) {
                currentHP -= 2;
                character.setHitPoints(currentHP);
            } else if (currentAC == 4) {
                currentHP -= 1;
                character.setHitPoints(currentHP);
            }
            successful = true;
        } else {
            successful = false;
        }
        return successful;
    }

}