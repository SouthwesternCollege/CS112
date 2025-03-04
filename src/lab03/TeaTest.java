package lab03;
/**
 * Test for Tea class
 * @author Raul Soto
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeaTest {

    // Tea object will revert to this state after each test.
    Tea tea = new Tea("Earl Grey", 12, 2.50, 180);
    Tea defaultTea = new Tea();
    Tea copy = new Tea(tea);

    @Test
    void getBrewTemp() {
        assertEquals(180, tea.getBrewTemp());
    }

    @Test
    void setBrewTemp() {
        assertEquals(false, tea.setBrewTemp(-1));
        assertEquals(true, tea.setBrewTemp(175));
        assertEquals(175, tea.getBrewTemp());
    }

    @Test
    void setAll() {
        assertEquals(false, tea.setAll("Chamomile", -10, 2.00, 170));
        assertEquals(false, tea.setAll("Chamomile", 10, -2.00, 170));
        assertEquals(false, tea.setAll("Chamomile", 10, 2.00, -170));
        assertEquals(true, tea.setAll("Chamomile", 10, 2.00, 170));
        assertEquals("Chamomile", tea.getName());
        assertEquals(10, tea.getOunces());
        assertEquals(2.00, tea.getPrice());
        assertEquals(170, tea.getBrewTemp());
    }


    @Test
    void testEquals() {
        assertEquals(true, tea.equals(new Tea("Earl Grey", 12, 2.50, 180)));
        assertEquals(false, tea.equals(new Tea()));
    }

    @Test
    void testToString() {
        System.out.println(tea);
    }
}