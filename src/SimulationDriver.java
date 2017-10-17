import java.util.*;

public class SimulationDriver {
    /**
     * General submission simulation driver for Single/Multiple questions
     * randomly generate the IDs and answers for a group of students to simulate the
     * submission process & check results
     * @param args
     */
    public static void main(String[] args){
        System.out.println("***iVote Simulation***");

        String questionSingle = "Which of these choices rhymes with dog?";

        List<String> singleAnswer = new ArrayList<>();
        List<String> singleOptions = new ArrayList<>();

        singleAnswer.add("c. hog");

        singleOptions.add("a. cat");
        singleOptions.add("b. chicken");
        singleOptions.add("c. hog");
        singleOptions.add("d. shark");

        Question singleQuestiontype = new SingleChoice(questionSingle,singleAnswer,singleOptions);

        String questionMulti = "Which of these choices represents a Java primitive type? (pick more than one)";

        List<String> multiAnswers = new ArrayList<String>();
        List<String> multiOptions = new ArrayList<String>();

        multiAnswers.add("a. int");
        multiAnswers.add("b. String");
        multiAnswers.add("c. char");

        multiOptions.add("a. int");
        multiOptions.add("b. String");
        multiOptions.add("c. char");
        multiOptions.add("d. Array");
        multiOptions.add("e. HashMap");

        Question multiQuestiontype = new MultipleChoice(questionMulti,multiAnswers,multiOptions);

        // simulate iVoting
        simulateVoting(singleQuestiontype, 1);
        simulateVoting(multiQuestiontype, 2);
    }

    /**
     * simulates instances of Student's voting by creating unique IDs, randomizing number of
     * students voting & finally printing out resulting statistics
     * (randomized number of students ranging from 25-50)
     * @param questionType the Type of Question being created
     * @param questionIdentifier represents an identifier of the question to help with simulation process
     */
    public static void simulateVoting(Question questionType, int questionIdentifier){
        IdGenerator generateIDs = new IdGenerator();
        int[] idNumbers = generateIDs.getIdNumbers();

        final int totalStudents = generateIDs.getStudentCount();
        Student[] randStudents = new Student[totalStudents];

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

        if(questionIdentifier == 1) {
            // single choice question
            System.out.println();
            System.out.println("- Single Choice Question -");
            System.out.println(questionType.getQuestion());
        }else{
            // multiple choice question
            System.out.println();
            System.out.println("- Multiple Choice Question -");
            System.out.println(questionType.getQuestion());
        }
        // Begin Simulation
        questionType.printChoicelist();
        System.out.println("Answer: " + questionType.getAnswer());
        System.out.println();
        System.out.println("**Simulation**");
        System.out.println("(" + totalStudents + " Students" + ")");
        System.out.println();

        serviceThread = new IVoteService(questionType);
        answerOptions = questionType.getAnswerChoices();

        for(int j = 0; j < totalStudents; j++){
            List<String> randomAnswer = pickRandom(questionIdentifier, answerOptions);
            serviceThread.submit(randStudents[j], randomAnswer);
        }

        // Output Simulation Actions
        for(int i = 0; i < totalStudents; i++){
            System.out.println("Student: " + randStudents[i].getStudentID());
            System.out.println("Answer: " + serviceThread.getResultsTable().get(randStudents[i].getStudentID()).toString());
            System.out.println("--------------------------------------------------");
        }

        //print out statistics for the results
        serviceThread.printStats();
    }

    /**
     * Helper method that randomizes an integer based on the size of the answer(s) options list,
     * this number is used to randomize an answer in the list
     * @param questionType
     * @param answerOptions
     * @return a list containing randomized answer(s) as Strings
     */
    public static List<String> pickRandom(int questionType, List<String> answerOptions){
        Random rand = new Random();
        List<String> randomAnswer = new ArrayList<String>();

        if(questionType == 1){
            String pickRandom = answerOptions.get(rand.nextInt(answerOptions.size()));
            randomAnswer.add(pickRandom);
        }else{
            // pick multiple
            List<String> tempList = new ArrayList<String>();
            int choiceSize = answerOptions.size();
            for(int i = 0; i < choiceSize; i++){
                String pickRandom = answerOptions.get(rand.nextInt(answerOptions.size()));
                tempList.add(pickRandom);
            }
            // use set to rid list of repeat choices
            Set<String> answersSet = new HashSet<String>(tempList);

            return new ArrayList<String>(answersSet);
        }

        return randomAnswer;
    }
}
