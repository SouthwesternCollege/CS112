package lab02;
/**
 * Main.java - Driver class to demonstrate revised historical examples
 *
 * @author Mikhail Nikulin
 * @version ???
 */

public class Main {
    public static void main(String[] args) {


        String revised1 = "Caesar sided with Cleopatra and was soon besieged by the Ptolemaic forces by land and sea in the great harbour. He realized that his only chance lay in setting fire to the enemy fleet, and it was by that drastic measure that he managed to gain the upper hand. Yet he is remarkably silent regarding the extent of the destruction caused by the fire in the city itself. Subsequent authors, however, provide details of the ensuing destruction. Most explicit is Plutarch, who, after a personal visit to Alexandria, explained that “Caesar was forced to repel the danger by using fire, which spread from the dockyards and destroyed the Great Library.",
                citation1 ="https://www.britannica.com/topic/Library-of-Alexandria/The-fate-of-the-Library-of-Alexandria",
                description1 = "The library of Alexandria burnt down as the result of war.";
        Date date1 = new Date(1,1,1642);
        RevisedHistoricalEvent event1 = new RevisedHistoricalEvent(description1, date1, revised1, citation1);
        System.out.println("\n====================================================");
        System.out.println("REVISED HISTORICAL EVENT EXAMPLE:");
        System.out.println("====================================================");
        event1.teach();
        System.out.println(event1);
    }
}