import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * this class is utilized to streamline the process of
 * creating unique student IDs
 */
public class IdGenerator {
    /**
     * represents the randomized student count
     * this amount is final since it's never changed
     * throughout the lifecycle of the program
     */
    private final int studentCount;
    /**
     * Random object to randomize
     */
    private Random rand;
    /**
     * array that stores unique student ID numbers
     */
    private int[] idNumbers;

    /**
     * Default constructor
     */
    public IdGenerator() {
        rand = new Random();
        studentCount = rand.nextInt((50 - 25) + 1) + 25;
        idNumbers = makeUniqueIDs(studentCount);
    }

    /**
     * helper method used to generate unique IDs
     * @param randomInt specifies how many randomized Student IDs will be made
     * @return nonrepeated unique IDs
     */
    public int[] makeUniqueIDs(int randomInt){
        int[] nonRepeats = new int[randomInt];
        for (int i = 0; i < nonRepeats.length; i++) {
            int idMaker = rand.nextInt(90000) + 10000;
            nonRepeats[i] = idMaker;
        }
        Collections.shuffle(Arrays.asList(nonRepeats));

        return nonRepeats;
    }

    /**
     * getter for randomized student count
     * within the range of 25-50
     * @return number of randomized students
     */
    public int getStudentCount() {
        return studentCount;
    }

    /**
     * getter for unique idNumbers
     * @return array holding uniqe ID numbers
     */
    public int[] getIdNumbers() {
        return idNumbers;
    }
}
