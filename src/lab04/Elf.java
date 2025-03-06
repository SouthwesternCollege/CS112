package lab04;
public class Elf extends GameCharacter {

    /**
     *
     * Assists {@code character} by increasing {@code hitPoints} by 10.
     * @param character {@code character} to assist
     */

    public void assist(GameCharacter character) {
        int currentHP = character.getHitPoints();
        currentHP += 10;
        character.setHitPoints(currentHP);
    }

    /**
     * Simulates an attack on a specified character. The attack's success is determined
     * by rolling a 20-sided die (d20) and comparing the result to the character's Armor Class (AC).
     * The damage dealt to the character depends on both the attack roll and the character's AC.
     *
     * <p>If the roll is between 11 and 20, the character takes 1 to 5 damage based on their AC.
     * If the roll is between 2 and 10, the character takes 1 to 3 damage based on their AC.
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
                currentHP -= 5;
                character.setHitPoints(currentHP);
            } else if (currentAC == 1) {
                currentHP -= 5;
                character.setHitPoints(currentHP);
            } else if (currentAC == 2) {
                currentHP -= 3;
                character.setHitPoints(currentHP);
            } else if (currentAC == 3) {
                currentHP -= 3;
                character.setHitPoints(currentHP);
            } else if (currentAC == 4) {
                currentHP -= 1;
                character.setHitPoints(currentHP);
            }
            successful = true;
        } else if (roll <= 10 && roll > 1) {
            if (currentAC == 0) {
                currentHP -= 3;
                character.setHitPoints(currentHP);
            } else if (currentAC == 1) {
                currentHP -= 3;
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