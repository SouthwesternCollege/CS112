package lab04;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Weapon class tester
 * @author Raul Soto
 */
class WeaponTest {
    Weapon weapon = new Weapon("Excalibur", 100, 50, 10);
    Weapon defaultWeapon = new Weapon();
    Weapon copy = new Weapon(weapon);

    @Test
    void getName() {
        assertEquals("Excalibur", weapon.getName());
    }

    @Test
    void getDamage() {
        assertEquals(100, weapon.getDamage());
    }

    @Test
    void getRange() {
        assertEquals(50, weapon.getRange());
    }

    @Test
    void getAttackBonus() {
        assertEquals(10, weapon.getAttackBonus());
    }

    @Test
    void setName() {
        assertTrue(weapon.setName("Sting"));
        assertEquals("Sting", weapon.getName());
        assertFalse(weapon.setName(null));
    }

    @Test
    void setDamage() {
        assertTrue(weapon.setDamage(50));
        assertEquals(50, weapon.getDamage());
        assertFalse(weapon.setDamage(-1));
    }

    @Test
    void setRange() {
        assertTrue(weapon.setRange(80));
        assertEquals(80, weapon.getRange());
        assertFalse(weapon.setRange(-1));
    }

    @Test
    void setAttackBonus() {
        assertTrue(weapon.setAttackBonus(42));
        assertEquals(42, weapon.getAttackBonus());
        assertFalse(weapon.setAttackBonus(-1));
    }

    @Test
    void setAll() {
        assertFalse(weapon.setAll(null, 10, 20, 30));
        assertFalse(weapon.setAll("Sting", -1, 20, 30));
        assertFalse(weapon.setAll("Sting", 10, -1, 30));
        assertFalse(weapon.setAll("Sting", 10, 20, -1));
        assertTrue(weapon.setAll("Sting", 10, 20, 30));
        assertEquals(weapon, new Weapon("Sting", 10, 20, 30));

    }

    @Test
    void testEquals() {
        assertTrue(weapon.equals(copy));
        assertFalse(weapon.equals(defaultWeapon));
    }

    @Test
    void testToString() {
        System.out.println(weapon.toString());
    }
}