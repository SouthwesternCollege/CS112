package lab02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistoricalEventTest {

    private lab02.Date fixedDate;

    @BeforeEach
    void setUp() {
        // Use a fixed date to avoid issues with new Date() changing at runtime
        fixedDate = new Date(1,1,1000);
    }

    @Test
    void testDefaultConstructor() {
        HistoricalEvent event = new HistoricalEvent();
        assertEquals(HistoricalEvent.DEFAULT_DESCRIPTION, event.getDescription());
        assertEquals(HistoricalEvent.DEFAULT_EVENT_DATE, event.getEventDay());
    }

    @Test
    void testConstructorWithDescriptionOnly() {
        HistoricalEvent event = new HistoricalEvent("Moon Landing");
        assertEquals("Moon Landing", event.getDescription());
        assertEquals(HistoricalEvent.DEFAULT_EVENT_DATE, event.getEventDay());
    }

    @Test
    void testConstructorWithDescriptionAndDate() {
        HistoricalEvent event = new HistoricalEvent("Moon Landing", fixedDate);
        assertEquals("Moon Landing", event.getDescription());
        assertEquals(fixedDate, event.getEventDay());
    }

    @Test
    void testCopyConstructor() {
        HistoricalEvent original = new HistoricalEvent("Moon Landing", fixedDate);
        HistoricalEvent copy = new HistoricalEvent(original);

        assertEquals(original.getDescription(), copy.getDescription());
        assertEquals(original.getEventDay(), copy.getEventDay());
        assertNotSame(original, copy); // different objects
    }

    @Test
    void testSettersAndGetters() {
        HistoricalEvent event = new HistoricalEvent();
        event.setDescription("Independence Day");
        event.setEventDay(fixedDate);

        assertEquals("Independence Day", event.getDescription());
        assertEquals(fixedDate, event.getEventDay());
    }

    @Test
    void testSetAll() {
        HistoricalEvent event = new HistoricalEvent();
        event.setAll("Fall of Berlin Wall", fixedDate);

        assertEquals("Fall of Berlin Wall", event.getDescription());
        assertEquals(fixedDate, event.getEventDay());
    }

    @Test
    void testToString() {
        HistoricalEvent event = new HistoricalEvent("Moon Landing", fixedDate);
        String output = event.toString();
        assertTrue(output.contains("Moon Landing"));
        assertTrue(output.contains(fixedDate.toString()));
    }

    @Test
    void testEqualsWithSameValues() {
        HistoricalEvent event1 = new HistoricalEvent("Moon Landing", fixedDate);
        HistoricalEvent event2 = new HistoricalEvent("Moon Landing", fixedDate);

        assertEquals(event1, event2);
        assertTrue(event1.equals(event2));
    }

    @Test
    void testEqualsWithDifferentDescription() {
        HistoricalEvent event1 = new HistoricalEvent("Moon Landing", fixedDate);
        HistoricalEvent event2 = new HistoricalEvent("Apollo 11", fixedDate);

        assertNotEquals(event1, event2);
    }

    @Test
    void testEqualsWithDifferentDate() {
        HistoricalEvent event1 = new HistoricalEvent("Moon Landing", fixedDate);
        HistoricalEvent event2 = new HistoricalEvent("Moon Landing", new Date(6,8,1984));

        assertNotEquals(event1, event2);
    }

    @Test
    void testEqualsWithNull() {
        HistoricalEvent event = new HistoricalEvent("Moon Landing", fixedDate);
        assertNotEquals(event, null);
    }

    @Test
    void testEqualsWithDifferentType() {
        HistoricalEvent event = new HistoricalEvent("Moon Landing", fixedDate);
        assertNotEquals(event, "Not a HistoricalEvent");
    }
}
