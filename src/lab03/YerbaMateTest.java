package lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YerbaMateTest {

    YerbaMate yerbaMate = new YerbaMate("Guayaki", 16, 4.50, 65, 0);
    YerbaMate defaultYerbaMate = new YerbaMate();
    YerbaMate copy = new YerbaMate(yerbaMate);
    @Test
    void getNumPasses() {
        assertEquals(0, yerbaMate.getNumPasses());
    }

    @Test
    void passMate() {
        yerbaMate.passMate();
        assertEquals(1, yerbaMate.getNumPasses());
    }

    @Test
    void refill() {
        yerbaMate.setOunces(0);
        yerbaMate.refill(12);
        assertEquals(12, yerbaMate.getOunces());
    }

    @Test
    void testEquals() {
        assertEquals(true, yerbaMate.equals(new YerbaMate("Guayaki", 16, 4.50, 65, 0)));
        assertEquals(false, yerbaMate.equals(new YerbaMate()));
    }


    @Test
    void testToString() {
        System.out.println(yerbaMate);
    }
}