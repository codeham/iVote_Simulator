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
        simulateVoting(singleQuestiontype, 1);
//        simulateVoting(multiQuestiontype);
    }

    public static void simulateVoting(Question questionType, int questionFlag){
        /**
         * randomized number of students ranging from 25-50
         * Max 50 student classroom
         * Min 25 student classroom
         */
        IdGenerator generateIDs = new IdGenerator();
        int[] idNumbers = generateIDs.getIdNumbers();

        final int totalStudents = generateIDs.getStudentCount();
        Student[] randStudents = new Student[totalStudents];
//        System.out.println("number of random students : " + generateIDs.getRandomStudents());

        // populate array of students with unique ID
        for(int i = 0; i < randStudents.length; i++){
            randStudents[i] = new Student();
            String idValue = String.valueOf(idNumbers[i]);
            randStudents[i].setStudentID(idValue);
        }

        // submit players answers, along with ID
        // randomize answers from the list of options
        // simulate a random number of answers to choose from depending on the type of question (Single or Multiple)

        Random rand = new Random();
        IVoteService serviceThread;
        List<String> answerOptions = new ArrayList<String>();

        if(questionFlag == 1) {
            // single choice question
            // single choice is going to generate only one answer from the list of choices
            // randomize a number based on the list size of a single choice question
            // pick an index at random in that list

            serviceThread = new IVoteService(questionType);
            answerOptions = questionType.getAnswerChoices();
            System.out.println(answerOptions);

//            List<String> randomAnswer = new ArrayList<String>();

            for(int j = 0; j < totalStudents; j++){
                String pickRandom = answerOptions.get(rand.nextInt(answerOptions.size()));
                List<String> randomAnswer = new ArrayList<String>();
                randomAnswer.add(pickRandom);
                serviceThread.submit(randStudents[j], randomAnswer);
            }

            //TESTING PURPOSES
            System.out.println(serviceThread.getResultsTable());

            for(int i = 0; i < totalStudents; i++){
                System.out.println( serviceThread.getResultsTable().get(randStudents[i].getStudentID()).toString());
            }

        }
    }

    public static void generateAnswers(){
        List<String> answerList = new ArrayList<String>();

    }

    public static List<String> simulateVoting(){

        return new ArrayList<String>();
    }

}
