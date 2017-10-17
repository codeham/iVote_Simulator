import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class IdGenerator {
    private int studentCount;
    private Random rand;
    private int[] idNumbers;

    public IdGenerator() {
        rand = new Random();
        studentCount = rand.nextInt((50 - 25) + 1) + 25;
//        studentCount = rand.nextInt((10 - 1) + 1) + 10;
        idNumbers = makeUniqueIDs(studentCount);
    }

    public int[] makeUniqueIDs(int randomInt){
        int[] nonRepeats = new int[randomInt];
        for (int i = 0; i < nonRepeats.length; i++) {
            int idMaker = rand.nextInt(90000) + 10000;
            nonRepeats[i] = idMaker;
        }
        Collections.shuffle(Arrays.asList(nonRepeats));

        return nonRepeats;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public int[] getIdNumbers() {
        return idNumbers;
    }
}
