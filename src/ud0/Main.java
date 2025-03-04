package ud0;
/**
 * Driver program that creates standard 52-card deck (as Card array)
 * and prints out each card in deck.
 *
 * @author ???
 * @version ???
 */

public class Main {

    /* ALGORITHM
    *
    1. Generate 52 card deck into Card array
    - ???
    2. Print deck (simple)
    - ???
    *
    */
    public static void main(String[] args) {
        /*** RUNNING TESTER ***/
        //uncomment line below to run CardTester:
        //CardTester.main(null);

        /*** DRIVER PROGRAM ***/
        //1. Generate 52 card deck into Card array
        Card[] deck = new Card[52];
        char[] suits = { Card.DIAMOND, Card.HEART, Card.SPADE, Card.CLUB };

        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 13; j++)
            {
                deck[i*13 + j] = new Card(j + 1, suits[i]);
            }
        }

        //2. Print deck
        for(int i = 0;i < deck.length; i++)
        {
            if( i % 13 == 0 && i != 0)
            {
                System.out.println();
            }
            System.out.print(deck[i] + "\t");
        }
    }
}