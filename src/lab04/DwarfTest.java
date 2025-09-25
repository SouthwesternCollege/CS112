package lab04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DwarfTest {
    Weapon axe = new Weapon("Axe", 85, 5, 15);
    Dwarf dwarf = new Dwarf("Gimli","Fighter", "Chaotic Good", 100, 50, 100, 80, axe, null);
    Dwarf defaultDwarf = new Dwarf();
    Dwarf dwarfCopy = new Dwarf(dwarf);

    @Test
    void testGetName() {
        assertEquals("Gimli", dwarf.getName());
    }

    @Test
    void testClassType() {
        assertEquals("fighter", dwarf.getClassType().toLowerCase());
    }

    @Test
    void testGetAlignment() {
        assertEquals("Chaotic Good", dwarf.getAlignment());
    }

    @Test
    void testGetExpPoints() {
        assertEquals(50, dwarf.getExpPoints());
    }

    @Test
    void testGetHitPoints() {
        assertEquals(100, dwarf.getHitPoints());
    }

    @Test
    void testGetArmorClass() {
        assertEquals(80, dwarf.getArmorClass());
    }

    @Test
    void testGetWeapon1() {
        assertEquals(axe, dwarf.getWeapon1());
    }

    @Test
    void testGetWeapon2() {
        assertNull(dwarf.getWeapon2());
    }

    @Test
    void testSetName() {
        assertTrue(dwarf.setName("Durin"));
        assertEquals("Durin", dwarf.getName());
        assertFalse(dwarf.setName(""));
        assertFalse(dwarf.setName(null));
    }

    @Test
    void testSetCharacterType() {
    }

    @Test
    void setAlignment() {
        assertTrue(dwarf.setAlignment("Chaotic Good"));
        assertEquals("Chaotic Good", dwarf.getAlignment());
        assertFalse(dwarf.setAlignment(""));
        assertFalse(dwarf.setAlignment(null));
    }

    @Test
    void setExpPoints() {
        assertTrue(dwarf.setExpPoints(60));
        assertEquals(60, dwarf.getExpPoints());
        assertFalse(dwarf.setExpPoints(-1));
    }

    @Test
    void setHitPoints() {
        assertTrue(dwarf.setHitPoints(90));
        assertEquals(90, dwarf.getHitPoints());
        assertFalse(dwarf.setHitPoints(-1));
    }

    @Test
    void setArmorClass() {
        assertTrue(dwarf.setArmorClass(95));
        assertEquals(95, dwarf.getArmorClass());
        assertFalse(dwarf.setArmorClass(-1));
    }

    @Test
    void setWeapon1() {
        assertTrue(dwarf.setWeapon1(null));
        assertNull(dwarf.getWeapon1());
    }

    @Test
    void setWeapon2() {
        assertTrue(dwarf.setWeapon1(new Weapon()));
        assertEquals(new Weapon(), dwarf.getWeapon1());
    }

    @Test
    void setAll() {
        assertTrue(dwarf.setAll("Durin","Dwarf", "neutral good", 110, 60, 90, 95, null, axe));
        assertFalse(dwarf.setAll("","Dwarf", "neutral good", 110, 60, 90, 95, null, axe));
        assertFalse(dwarf.setAll(null,"Dwarf", "neutral good", 110, 60, 90, 95, null, axe));
        assertFalse(dwarf.setAll("Durin","Dwarf", "", 110, 60, 90, 95, null, axe));
        assertFalse(dwarf.setAll("Durin","Dwarf", null, 110, 60, 90, 95, null, axe));
        assertFalse(dwarf.setAll("Durin","Dwarf", "neutral good", -1, 60, 90, 95, null, axe));
        assertFalse(dwarf.setAll("Durin","Dwarf", "neutral good", 110, -1, 90, 95, null, axe));
        assertFalse(dwarf.setAll("Durin","Dwarf", "neutral good", 110, 60, -1, 95, null, axe));
        assertFalse(dwarf.setAll("Durin","Dwarf", "neutral good", 110, 60, 90, -1, null, axe));
    }

    @Test
    void testToString() {
        System.out.println(dwarf);
    }

    @Test
    void testEquals() {
        assertEquals(dwarfCopy, dwarf);
        assertNotEquals(defaultDwarf, dwarf);
    }

    @Test
    void assist() {
        dwarf.assist(defaultDwarf);
    }

    @Test
    void attack() {
        dwarf.attack(defaultDwarf);
    }
}