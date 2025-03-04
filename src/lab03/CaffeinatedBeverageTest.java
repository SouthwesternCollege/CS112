package lab03;

import static org.junit.jupiter.api.Assertions.*;

class CaffeinatedBeverageTest {
    // CaffeneitedBeverage object will always revert to this state after each test.
    CaffeinatedBeverage beverage = new CaffeinatedBeverage("Coffee", 16, 3.50);
    CaffeinatedBeverage defaultBeverage = new CaffeinatedBeverage();
    CaffeinatedBeverage copy = new CaffeinatedBeverage(beverage);


    @org.junit.jupiter.api.Test
    void getName() {
        assertEquals("Coffee", beverage.getName());
    }

    @org.junit.jupiter.api.Test
    void getOunces() {
        assertEquals(16, beverage.getOunces());
    }

    @org.junit.jupiter.api.Test
    void getPrice() {
        assertEquals(3.50, beverage.getPrice());
    }

    @org.junit.jupiter.api.Test
    void setName() {
        beverage.setName("Espresso");
        assertEquals("Espresso", beverage.getName());
    }

    @org.junit.jupiter.api.Test
    void setOunces() {
        beverage.setOunces(20);
        assertEquals(20, beverage.getOunces());
    }

    @org.junit.jupiter.api.Test
    void setPrice() {
        beverage.setPrice(4.50);
        assertEquals(4.50, beverage.getPrice());
    }

    @org.junit.jupiter.api.Test
    void setAll() {
        assertEquals(false, beverage.setAll("Cappuccino", -12, 3.50));
        assertEquals(false, beverage.setAll("Cappuccino", 12, -3.50));
        assertEquals(true, beverage.setAll("Cappuccino", 12, 3.50));
        assertEquals("Cappuccino", beverage.getName());
        assertEquals(12, beverage.getOunces());
        assertEquals(3.50, beverage.getPrice());
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        beverage.setAll("Cappuccino", 12, 3.50);
        assertEquals(true, beverage.equals(new CaffeinatedBeverage("Cappuccino", 12, 3.50)));
        assertEquals(false, beverage.equals(new CaffeinatedBeverage()));
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        System.out.println(beverage);
    }

    @org.junit.jupiter.api.Test
    void sip() {
        int sip = 8;
        beverage.setOunces(sip);
        assertEquals(true, beverage.sip(sip - 1));
        assertEquals(false, beverage.sip(sip + 1));
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        System.out.println(beverage);
        assertEquals(false, beverage.isEmpty());
        beverage.sip(beverage.getOunces());
        assertEquals(0, beverage.getOunces());
        assertEquals(true, beverage.isEmpty());
    }
}