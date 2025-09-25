package lab04;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test for Weapon class
 * @author Raul Soto
 * @version 0.0.α
 */
class WeaponTest {
    Weapon weapon = new Weapon("Excalibur", 100, 50, 10);
    Weapon defaultWeapon = new Weapon();
    Weapon copy = new Weapon(weapon);

    @Test
    void testGetName() {
        assertEquals("Excalibur", weapon.getName());
    }

    @Test
    void testGetDamage() {
        assertEquals(100, weapon.getDamage());
    }

    @Test
    void testGetRange() {
        assertEquals(50, weapon.getRange());
    }

    @Test
    void testSetName() {
        assertTrue(weapon.setName("Sting"));
        assertEquals("Sting", weapon.getName());
        assertFalse(weapon.setName(null));
    }

    @Test
    void testSetDamage() {
        assertTrue(weapon.setDamage(50));
        assertEquals(50, weapon.getDamage());
        assertFalse(weapon.setDamage(-1));
    }

    @Test
    void testSetRange() {
        assertTrue(weapon.setRange(80));
        assertEquals(80, weapon.getRange());
        assertFalse(weapon.setRange(-1));
    }

    @Test
    void testSetAll() {
        assertFalse(weapon.setAll(null, 10, 20, 30));
        assertFalse(weapon.setAll("Sting", -1, 20, 30));
        assertFalse(weapon.setAll("Sting", 10, -1, 30));
        assertFalse(weapon.setAll("Sting", 10, 20, -1));
        assertTrue(weapon.setAll("Sting", 10, 20, 30));
        assertEquals(weapon, new Weapon("Sting", 10, 20, 30));

    }

    @Test
    void testEquals() {
        assertEquals(weapon, copy);
        assertNotEquals(weapon, defaultWeapon);
    }

    @Test
    void testToString() {
        System.out.println(weapon.toString());
    }
}