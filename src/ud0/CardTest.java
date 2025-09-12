package ud0;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test for Card class
 * @author Raul Soto
 * @version 0.0.α
 */
class CardTest {

    @Test
    void testDefaultConstructor() {
        Card card = new Card();
        assertEquals(1, card.getValue());
        assertEquals(Card.HEART, card.getSuit());
        assertEquals("A", card.getPrintValue());
        assertEquals("A ♥", card.toString());
    }

    @Test
    void testFullConstructorValid() {
        Card card = new Card(13, Card.SPADE);
        assertEquals(13, card.getValue());
        assertEquals(Card.SPADE, card.getSuit());
        assertEquals("K", card.getPrintValue());
        assertEquals("K ♠", card.toString());
    }

    @Test
    void testCopyConstructor() {
        Card original = new Card(11, Card.DIAMOND);
        Card copy = new Card(original);
        assertEquals(original.getValue(), copy.getValue());
        assertEquals(original.getSuit(), copy.getSuit());
        assertTrue(original.equals(copy));
    }

    @Test
    void testSetValueValid() {
        Card card = new Card();
        assertTrue(card.setValue(10));
        assertEquals(10, card.getValue());
        assertEquals("10", card.getPrintValue());
    }

    @Test
    void testSetValueInvalid() {
        Card card = new Card();
        assertFalse(card.setValue(20));
        assertEquals(1, card.getValue()); // stays default
    }

    @Test
    void testSetSuitValid() {
        Card card = new Card();
        assertTrue(card.setSuit(Card.CLUB));
        assertEquals(Card.CLUB, card.getSuit());
    }

    @Test
    void testSetSuitInvalid() {
        Card card = new Card();
        assertFalse(card.setSuit('X'));
        assertEquals(Card.HEART, card.getSuit()); // stays default
    }

    @Test
    void testSetAllValid() {
        Card card = new Card();
        assertTrue(card.setAll(12, Card.SPADE));
        assertEquals(12, card.getValue());
        assertEquals(Card.SPADE, card.getSuit());
        assertEquals("Q ♠", card.toString());
    }

    @Test
    void testSetAllInvalid() {
        Card card = new Card();
        assertFalse(card.setAll(15, 'Z'));
        assertEquals(1, card.getValue()); // unchanged
        assertEquals(Card.HEART, card.getSuit());
    }

    @Test
    void testGetPrintValue() {
        Card ace = new Card(1, Card.SPADE);
        Card num = new Card(7, Card.HEART);
        Card jack = new Card(11, Card.CLUB);
        Card queen = new Card(12, Card.DIAMOND);
        Card king = new Card(13, Card.SPADE);

        assertEquals("A", ace.getPrintValue());
        assertEquals("7", num.getPrintValue());
        assertEquals("J", jack.getPrintValue());
        assertEquals("Q", queen.getPrintValue());
        assertEquals("K", king.getPrintValue());
    }

    @Test
    void testEquals() {
        Card c1 = new Card(10, Card.CLUB);
        Card c2 = new Card(10, Card.CLUB);
        Card c3 = new Card(9, Card.CLUB);
        assertTrue(c1.equals(c2));
        assertFalse(c1.equals(c3));
    }

    @Test
    void testGetPrintCard() {
        Card card = new Card(1, Card.HEART);
        String expected = """
                -------
                |♥   ♥|
                |  A  |
                |♥   ♥|
                -------""";
        assertEquals(expected, card.getPrintCard());
    }
}
