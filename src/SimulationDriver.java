import java.util.*;

public class SimulationDriver {
    public static void main(String[] args){
        /**
         *  General simulation for Single/Multiple choice questions
         */
//        randomly generate the IDs and answers for a group of students to simulate the
//        submission process & check results

        System.out.println("***iVote Simulation***");

        // Question Simulation
        String questionSingle = "Which of these choices rhymes with dog?";

        List<String> singleAnswer = new ArrayList<>();
        List<String> singleOptions = new ArrayList<>();

        singleAnswer.add("c");

        singleOptions.add("a. cat");
        singleOptions.add("b. chicken");
        singleOptions.add("c. hog");
        singleOptions.add("d. shark");

        Question singleQuestiontype = new SingleChoice(questionSingle,singleAnswer,singleOptions);

        // multiple choice question
        String questionMulti = "Which of these choices represents a Java primitive type? (pick more than one)";

        List<String> multiAnswers = new ArrayList<String>();
        List<String> multiOptions = new ArrayList<String>();

        multiAnswers.add("a");
        multiAnswers.add("b");
        multiAnswers.add("c");

        multiOptions.add("a. int");
        multiOptions.add("b. String");
        multiOptions.add("c. char");
        multiOptions.add("d. Array");
        multiOptions.add("e. HashMap");

        Question multiQuestiontype = new MultipleChoice(questionMulti,multiAnswers,multiOptions);

        // single choice question
        System.out.println("Single Question: " + singleQuestiontype.getQuestion());
        singleQuestiontype.printChoicelist();
        System.out.println("Single Answer: " + singleQuestiontype.getAnswer());

        System.out.println("");

        // multi question
        System.out.println("Multi Question: " + multiQuestiontype.getQuestion());
        multiQuestiontype.printChoicelist();
        System.out.println("Multi Answer: " + multiQuestiontype.getAnswer());

        // simulate iVoting
        simulateVoting(singleQuestiontype);
//        simulateVoting(multiQuestiontype);
    }

    public static void simulateVoting(Question questionType){
        Random rand = new Random();
        /**
         * randomized number of students ranging from 25-50
         * Max 50 student classroom
         * Min 25 student classroom
         */
        int randomInt = rand.nextInt((50 - 25) + 1) + 25;

        Student[] randStudents = new Student[randomInt];
        System.out.println("number of random students : " + randomInt);

        int[] idNumbers = uniqueNums(randomInt);

        // populate array of students with unique ID
        for(int i = 0; i < randStudents.length; i++){
            randStudents[i] = new Student();
            randStudents[i].setStudentID(String.valueOf(idNumbers[i]));
            String x = randStudents[i].getStudentID();
            System.out.println(x);
        }

        // submit players answers, along with ID
        // randomize answers from the list of options
        // simulate a random number of answers to choose from depending on the type of question (Single or Multiple)
        



    }

    public static List<String> simulateVoting(){

        return new ArrayList<String>();
    }

    public static int[] uniqueNums(int randomInt){
        Random rand = new Random();
        int[] nums = new int[randomInt];
        for (int i = 0; i < nums.length; i++) {
            int idMaker = rand.nextInt(90000) + 10000;
            nums[i] = idMaker;
        }
        Collections.shuffle(Arrays.asList(nums));
//        System.out.println(Arrays.toString(nums));
        return nums;
    }
}
